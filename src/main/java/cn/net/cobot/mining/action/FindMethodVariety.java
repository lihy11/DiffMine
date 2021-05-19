package cn.net.cobot.mining.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import cn.net.cobot.cobot_preprocess.manager.model.impl.CobotJavaProject;
import cn.net.cobot.mining.database.Connection;
import cn.net.cobot.mining.database.VarietyInfoOperation;
import cn.net.cobot.mining.model.FileVector;
import cn.net.cobot.mining.model.ProjectInfo;
import cn.net.cobot.mining.model.VarietyInfo;
import cn.net.cobot.mining.util.GitCommand;
import cn.net.cobot.parsers.javaparser.core.dom.CompilationUnit;
import cn.net.cobot.parsers.javaparser.core.dom.ImportDeclaration;

public class FindMethodVariety {
	
	public static final boolean DEBUG=false;	 
	public ArrayList<String> libList;
	/**
	 * 查询并处理所有没有存入数据库的对应工程的提交
	 * @param projectPath  git仓库路径
	 * @param databaseConnection  数据库连接
	 */
	public String findMethodVarietyOfProject(String projectPath, ProjectInfo projectInfo, 
			Connection databaseConnection) throws Exception{
		
		GitCommand git = new GitCommand(projectPath);
		ArrayList<String> commitList = (ArrayList<String>) git.getCommitIdList();
		if (commitList.size() < 1 || commitList.size() > 10000) {  //filter too big project
			git.realseGit();
			return null;
		}
		
		/*检查数据库project info， 找到最近更新的commit id,只遍历没有遍历过的commit*/
		String lastCommitID = projectInfo.getLast_commit_checked();
		int lastCommitIndex = commitList.indexOf(lastCommitID);
		if(lastCommitIndex == -1 || DEBUG)   //如果没有更新过则全部遍历
			lastCommitIndex = commitList.size();
		
		SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()) +" : " + projectPath + " : " + commitList.size());
		
		ArrayList<FileVector> fileVectors = getFileVectorsOfProject(commitList, git, lastCommitIndex);
		git.realseGit();
		
		/*检查filevector并插入数据库*/
		VarietyInfoOperation varietyInfoOperation = new VarietyInfoOperation(databaseConnection);
		for(FileVector fileVector : fileVectors) {
			if(fileVector.isEmpty())
				continue;
			VarietyInfo varietyInfo = new VarietyInfo(fileVector);
			varietyInfo.setProject_id(projectInfo.getProject_id());
			varietyInfo.setProject_name(projectInfo.getProject_name());
			varietyInfo.setVarietyinfo_id(getOnlyPKey());
			
			varietyInfoOperation.insertVarietyInfo(varietyInfo);
		}
		return commitList.get(0);
	}
	
	/**获取工程多次提交的所有filevector
	 * @param commitList
	 * @param git
	 * @param lastCommitIndex
	 * @return
	 */
	public ArrayList<FileVector> getFileVectorsOfProject(ArrayList<String> commitList, GitCommand git, 
			int lastCommitIndex){
		
		git.resetHardGit();  //除去未提交代码，防止checkout操作失败
		String projectPath = git.prjPath;
		/*遍历需要遍历的commit*/
		String curCommitID = "";
		ArrayList<FileVector> fileVectors = new ArrayList<FileVector>();
		for(int i = 0; i < lastCommitIndex; i ++) {
			if(i % 5000 == 0) {
				SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm:ss");//设置日期格式
				System.out.println(df.format(new Date()) +" : " + String.valueOf(i));
			}
			String commitID = commitList.get(i);
			String diffMsg = git.getDiff(commitID);
			
			if (DEBUG) 
				if (commitID.equals("26413f769177b9518cf5081a3497d0993484df15"))
					System.out.println("debug");
			
			HashSet<DiffMsgInfCollect> diffs = (new DiffMsgInfCollect()).readDiffMsg(diffMsg);
			if (diffs.size() == 0)
				continue;
			ArrayList<FileVector> fileVectorsOfCommit = new ArrayList<FileVector>();
			// 当前版本下分析代码
			if(!curCommitID.equals(commitID)) {
				git.resetCommitHard(commitID);
				curCommitID = commitID;
			}
			for (DiffMsgInfCollect diff : diffs) {
				String path = diff.getFilePath();
				if (!path.endsWith(".java") || path.contains("test")) {
					continue;
				}
				FileVector fileVector = new FileVector();
				fileVector.path = path;
				fileVector.commitID = commitID;
				for (int change = 0; change < diff.changeSet.size(); change++) {
					fileVector.changeSet.add(diff.changeSet.get(change));
					fileVector.methodVectorSets.add(new HashSet<String>());
				}
				if (diff.changeSet.size() > 0) {
					analysisCu(projectPath, path, fileVector, false);
					fileVectorsOfCommit.add(fileVector);
				}
			}
			// 切换至上一个版本分析其代码
			if (i < lastCommitIndex - 1 && !curCommitID.equals(commitList.get(i + 1))) {
				git.resetCommitHard(commitList.get(i + 1));
				curCommitID = commitList.get(i+1);
			}
			for (FileVector fileVector : fileVectorsOfCommit) {
				String path = fileVector.path;
				analysisCu(projectPath, path, fileVector, true);
				if(!fileVector.isEmpty())
					fileVectors.add(fileVector);
			}
		}
		return fileVectors;
	}
	
	/**
	  * analyze cu and get vectors of methods had been changed
	 * @param projectPath
	 * @param libpath
	 * @param changes
	 * @param fileVector 
	 * @param isRemove
	 * @param methodNumMap
	 */
	@SuppressWarnings("unchecked")
	private void analysisCu(String projectPath, String filePath,FileVector fileVector, Boolean isRemove) {
		try {
			
			CobotJavaProject project = new CobotJavaProject(projectPath + File.separator
					+ filePath, libList);
			MethodVarietyVisitor visitor = new MethodVarietyVisitor();
			
			List<CompilationUnit> cuList = project.getCompilationUnitList();
			for (CompilationUnit cu : cuList) {
				ArrayList<ImportDeclaration> imports = new ArrayList<ImportDeclaration>();
				if(cu.imports() != null)
					imports.addAll(cu.imports());
				visitor.beforeVisitor(fileVector, isRemove, imports);
				cu.accept(visitor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getOnlyPKey() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
