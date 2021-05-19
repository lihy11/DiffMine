package cn.net.cobot.mining.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import cn.net.cobot.cobot_preprocess.manager.model.impl.CobotJavaProject;
import cn.net.cobot.parsers.javaparser.core.dom.CompilationUnit;

public class MethodVectors {
	
	public static final boolean DEBUG=false;	 
	private String projectPath;
	Map<Info,Integer> infoNumMap;
	public final int RELEASENUM=1000;
	
	public MethodVectors(String projectPath,String objectMapPath){
		this.projectPath = projectPath;
		this.infoNumMap = JavaMinerUtility.readObjectMap(objectMapPath);
	}
	
	public ArrayList<CommitVector> getVectors() {
		ArrayList<CommitVector> vectors = new ArrayList<CommitVector>();
		GitCommand git = new GitCommand(projectPath);
		List<String> commitIds = git.getCommitIdList();
		if (commitIds.size() < 1)
			return vectors;
//		if(commitIds.size() < 10000) {
//			System.out.println(projectPath + " too small");
//			return vectors;
//		}
		git.resetHardGit();
		SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()) +" : " + projectPath + " : " + commitIds.size());
		try {
			String curCommitID = "";
			for (int i = 0; i < commitIds.size(); i++) {
				String commitID = commitIds.get(i);
				String diffMsg = git.getDiff(commitIds.get(i));
		//		System.out.println("commitID::" + commitIds.get(i));
//				if (DEBUG) {
//					if (commitIds.get(i).equals("2ec72123e347e684ac40a1e1111a79a11211aadb"))
//						System.out.println("debug");
//				}
				if( i % 1000 == 0) {
					System.out.println(df.format(new Date()) +" : " + String.valueOf(i) + "  " + commitID);
				}
				HashSet<DiffMsgInfCollect> diffs = (new DiffMsgInfCollect()).readDiffMsg(diffMsg);
				if (diffs.size() == 0)
					continue;
				CommitVector commitVector = new CommitVector();
				// 当前版本下分析代码
				// git.resetHardGit();
				if(!curCommitID.equals(commitID)) {
					git.resetCommitHard(commitID);
					curCommitID = commitID;
				}
				for (DiffMsgInfCollect diff : diffs) {
					String path = diff.getFilePath();
					if (path.lastIndexOf(".java") == -1 || path.contains("test")) {
						continue;
					}
					FileVector fileVector = new FileVector();
					fileVector.path = path;

					for (int change = 0; change < diff.changeSet.size(); change++) {
						fileVector.changeSet.add(diff.changeSet.get(change));
						fileVector.secVectors.add(new HashSet<String>());
					}
					if (diff.changeSet.size() > 0) {
						analysisCu(projectPath, path, fileVector, false, infoNumMap);
						commitVector.fileVectors.put(path, fileVector);
					}
				}
				// 切换至上一个版本分析其代码
				if (i < commitIds.size() - 1 && !curCommitID.equals(commitIds.get(i + 1))) {
					git.resetCommitHard(commitIds.get(i + 1));
					curCommitID = commitIds.get(i+1);
				}
				for (DiffMsgInfCollect diff : diffs) {
					String path = diff.getFilePath();
					if (path.lastIndexOf(".java") == -1 || path.contains("test")) {
						continue;
					}
					FileVector fileVector = null;
					if (commitVector.fileVectors.containsKey(path)) {
						fileVector = commitVector.fileVectors.get(path);
					} else {
						fileVector = new FileVector();
						for (int change = 0; change < diff.changeSet.size(); change++) {
							fileVector.changeSet.add(diff.changeSet.get(change));
							fileVector.secVectors.add(new HashSet<String>());
						}
					}
					
					if (diff.changeSet.size() > 0) {
						analysisCu(projectPath, path, fileVector, true, infoNumMap);
						if (!commitVector.fileVectors.containsKey(path))
							commitVector.fileVectors.put(path, fileVector);
					}
				}
				HashSet<String> paths = new HashSet<String>();
				paths.addAll(commitVector.fileVectors.keySet());
				for(String pathString : paths) {
					if(commitVector.fileVectors.get(pathString).isEmpty() == true) {
						commitVector.fileVectors.remove(pathString);
					}
				}
				if (commitVector.fileVectors.size() != 0) {
					commitVector.commitID = commitIds.get(i);
					vectors.add(commitVector);
				}
			}
		} catch (Exception e) {
		}
		git.realseGit();
		return vectors;
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
	private void analysisCu(String projectPath, String filePath,FileVector fileVector, Boolean isRemove,
			Map<Info, Integer> methodNumMap) {
		try {
			CobotJavaProject project = new CobotJavaProject(projectPath
					+ filePath, null);
			DiffVisitor visitor = new DiffVisitor();
			visitor.beforeVisitor(fileVector, isRemove, methodNumMap);
			List<CompilationUnit> cuList = project.getCompilationUnitList();

			for (CompilationUnit cu : cuList) {
				cu.accept(visitor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}