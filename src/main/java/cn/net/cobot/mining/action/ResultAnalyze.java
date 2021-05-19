package cn.net.cobot.mining.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ToolRunner;
import org.apache.mahout.common.Pair;
import org.apache.mahout.fpm.pfpgrowth.convertors.string.TopKStringPatterns;

import cn.net.cobot.mining.database.Connection;
import cn.net.cobot.mining.database.VarietyInfoOperation;
import cn.net.cobot.mining.model.FileVector;
import cn.net.cobot.mining.model.FrequentSetSupportInfo;
import cn.net.cobot.mining.model.VarietyInfo;
import cn.net.cobot.mining.util.GitCommand;
/**
 * 分析提交模式数据库，获取频繁模式
 * 1. 获取全部提交数据库
 * 2. 频繁子集挖掘，去除频次极高的方法
 * 3. 频繁子集挖掘，获取频繁模式
 * 4. 查找频繁模式的支持项目
 * 5. 获取项目相关的提交注释和代码，并保存至指定目录
 * @author lihaiyang
 *
 */
public class ResultAnalyze {
	
	List<FileVector> fileVectors = new ArrayList<FileVector>();
	
	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		if(args.length != 5) {
			System.out.println("需要如下命令行参数");
			System.out.println("java -jar test.jar minTimes, maxTimes, outPath, resultHome, responstoryHome");
			System.out.println("分别对应最小的支持度， 需要筛选掉的频繁出现的方法的次数，保存路径");
		}
		int minTimes = Integer.parseInt(args[0]), maxTimes = Integer.parseInt(args[1]);
		String outPath = args[2], resultHome = args[3], responstoryHome = args[4];
		
		ResultAnalyze resultAnalyze = new ResultAnalyze();
		Connection databaseConnection = new Connection();
		VarietyInfoOperation varietyInfoOperation = new VarietyInfoOperation(databaseConnection);
		FPGrowthRunner runner = new FPGrowthRunner();
		List<VarietyInfo> varietyInfos = varietyInfoOperation.selectAllVarietyInfo();
		
		
		for(VarietyInfo varietyInfo : varietyInfos) {
			FileVector fileVector = varietyInfo.toFileVector();
			resultAnalyze.fileVectors.add(fileVector);
		}
		System.out.print("generate vector list: ");
		List<Pair<List<String>, Long>> dataset = resultAnalyze.getVarietyVector();
		System.out.println(String.valueOf(dataset.size()));
		
		System.out.print("filter methods too many ");
		runner.dataset = dataset;
		resultAnalyze.filterMethods(runner, maxTimes, outPath);
		System.out.println("vectors left: " + String.valueOf(runner.dataset.size()));
		
		System.out.print("generate frequent pattern: ");
		List<List<String>> frequentSet = resultAnalyze.generateFrequentPattern(runner, minTimes, outPath);
		System.out.println(frequentSet.size());
		
		System.out.println("get support info : ");
		ArrayList<FrequentSetSupportInfo> frequentSetSupportInfos = resultAnalyze.getSupportInfo(frequentSet);
		
		System.out.println("get commit code info");
		try {
			resultAnalyze.getResultInfo(frequentSetSupportInfos, resultHome, responstoryHome);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("analyze over!");
	}
	private void getResultInfo(ArrayList<FrequentSetSupportInfo> frequentSetSupportInfos, String resultHome, 
			String responstoryHome) throws IOException {
		String allResultPath = resultHome + File.separator + "result";
		File allFile = new File(allResultPath);
		if(!allFile.exists())
			allFile.mkdir();
		
		String apiChangePath = resultHome + File.separator + "api_change.csv";
		BufferedWriter apiChangeWriter = new BufferedWriter(new FileWriter(apiChangePath));
		apiChangeWriter.write("NO,Method del, Method add, project support, commit support\n");
		
		for(int modeNO = 0; modeNO < frequentSetSupportInfos.size(); modeNO++) {
			FrequentSetSupportInfo info = frequentSetSupportInfos.get(modeNO);
			System.out.println("handling " +modeNO + " / " +  frequentSetSupportInfos.size() + " pattern");
			
			/*子文件夹*/
			String dirPath = allResultPath + File.separator + String.valueOf(modeNO);
			(new File(dirPath)).mkdir();
			
			BufferedWriter mdWriter = new BufferedWriter(new FileWriter(dirPath + File.separator + "result.md"));
			/*方法信息*/
			String methodDel = "";
			String methodAdd = "";
			for(String method: info.frequentSet) {
				if(method.startsWith("+")) {
					methodAdd += method + "\n";
				}else {
					methodDel += method + "\n";
				}
			}
			mdWriter.write("###  infomation \n" + "method del:\n" + methodDel + "method add：\n" + methodAdd);
			mdWriter.flush();
			
			/*支持度数据*/
			/*获取支持工程和提交*/
			BufferedWriter csvWriter = new BufferedWriter(new FileWriter(dirPath + File.separator + "result.csv"));
			for(FileVector fileVector : info.fileVectors) {
				csvWriter.write(fileVector.projectName + "," + fileVector.commitID + "," + fileVector.path + "\n");
			}
			csvWriter.close();
			
			/*支持度数据*/
			HashSet<String> projNames = new HashSet<String>();
			for(FileVector fileVector : info.fileVectors) {
				projNames.add(fileVector.projectName);
			}
			String projSupport = String.valueOf(projNames.size());
			String commitSupport = String.valueOf(info.fileVectors.size());
			mdWriter.write("###  support count\n" + 
							"project count : " + projSupport + "\n" + 
							"commit count : " + commitSupport + "\n");
			mdWriter.flush();
			if(!methodAdd.trim().equals("") && !methodDel.trim().equals("") ) {
				apiChangeWriter.write(String.valueOf(modeNO) + "," + methodDel.replace("\n", " ") + "," 
						+ methodAdd.replace("\n", " ") + "," + projSupport + "," + commitSupport + "," + "\n");
			}
			/*写入变更代码*/
			writeVarietyCode(mdWriter, info, responstoryHome);
			mdWriter.close();
			apiChangeWriter.flush();
		}
		apiChangeWriter.close();
	}
	
	public void writeVarietyCode(BufferedWriter mdWriter, FrequentSetSupportInfo info, String responstoryHome) throws IOException {
		/*写入变更代码*/
		mdWriter.write("###  code\n");
		GitCommand git = null;
		for(int i = 0; i < info.fileVectors.size(); i ++) {
			FileVector fileVector = info.fileVectors.get(i);
			String proName = fileVector.projectName;
			String commitID = fileVector.commitID;
			String filePath = fileVector.path;
			
			HashMap<String, Integer> change = fileVector.changeSet.get(info.varietyPossionInFileVectors.get(i));
			
//			String projectDir = getProjectDir(responstoryHome, fileVector);
			String projectDir = getProjectDir(fileVector);
			if(projectDir == null)
				return ;
//			System.out.println(projectDir + "  " + fileVector.projectID);
			if(git == null ) {
				git=new GitCommand(projectDir);
			}else if(!git.prjPath.equals(projectDir )) {
				git.realseGit();
				git = new GitCommand(projectDir);
			}
		
			String commitMsg = git.getCommitMsg(commitID);
			if(commitMsg == null)
				commitMsg = "";
			mdWriter.write("ProjectName: " + proName + "\n" + "CommitID: " + commitID + "\n"  + 
						"CommitMsg: " + commitMsg + "\n"  + "FilePath: " + filePath + "**\n");
			String diffMsg = git.getDiff(commitID);
			HashSet<DiffMsgInfCollect> diffs = (new DiffMsgInfCollect()).readDiffMsg(diffMsg);
			/*写入代码*/
			mdWriter.write("```diff\n");
			ArrayList<String> realCode = null;
			for(DiffMsgInfCollect diff : diffs) {
				if(!diff.getFilePath().equals(filePath)) 
					continue;
				for(ArrayList<String> code : diff.totalDiffCodes) {
					if(code.size() == 0) 
						continue;
					if(!code.get(0).startsWith("@@"))
						continue;
					String[] tmp = code.get(0).split(" ");
					int oldLineNum = Integer.parseInt(tmp[1].split(",")[0].substring(1));
					int newLineNum = Integer.parseInt(tmp[2].split(",")[0].substring(1));
					if(oldLineNum > change.get(DiffMsgInfCollect.DEL_POSSION) && newLineNum > change.get(DiffMsgInfCollect.ADD_POSSION))
						break;
					realCode = code;
				}
			}
			if(realCode == null) {
				mdWriter.write("somrthing must be wrong!,there is no code\n");
			}else {
				writeCode(realCode, mdWriter, change);
			}
			mdWriter.write("```\n");
			mdWriter.flush();
		}
	}
	
	private void writeCode(ArrayList<String> realCode, BufferedWriter mdWriter,HashMap<String, Integer> change) throws IOException {
		String[] tmp = realCode.get(0).split(" ");
		int oldLineNum = Integer.parseInt(tmp[1].split(",")[0].substring(1));
		int newLineNum = Integer.parseInt(tmp[2].split(",")[0].substring(1));
		int i = 1;
		for(;i < realCode.size(); i ++) {
			String line = realCode.get(i);
			if(line.startsWith("-")) {
				oldLineNum ++;
			}else if(line.startsWith("+")) {
				newLineNum ++;
			}else {
				oldLineNum ++;
				newLineNum ++;
			}
			if(oldLineNum == change.get(DiffMsgInfCollect.DEL_POSSION) || newLineNum == change.get(DiffMsgInfCollect.ADD_POSSION)) {
				break;
			}
		}
		if(i >= realCode.size()) {
			mdWriter.write("there must something wrong, this code block do not contians your change script\n");
			mdWriter.write(String.valueOf(change.get(DiffMsgInfCollect.ADD_POSSION)) + "\n");
			mdWriter.write(String.valueOf(change.get(DiffMsgInfCollect.DEL_POSSION)) + "\n");
		}else {
			boolean writing = false;
			for(;i < realCode.size(); i ++) {
				String line = realCode.get(i);
				if(writing && !line.startsWith("-")  && !line.startsWith("+")) {
					break;
				}else {
					mdWriter.write(line + "\n");
					writing = true;
				}
			}
		}
		mdWriter.flush();
	}
	private String getProjectDir(String responstoryHome, FileVector fileVector) {
		
		if(fileVector.projectID.length() <= 4) {
			return responstoryHome + File.separator + "0" + File.separator + fileVector.projectID + "-" + fileVector.projectName;
		}else if(fileVector.projectID.length() == 5){
			return responstoryHome + File.separator + fileVector.projectID.charAt(0) + File.separator + 
					fileVector.projectID + "-" + fileVector.projectName;
		}else if(fileVector.projectID.length() == 6) {
			return responstoryHome + File.separator + fileVector.projectID.substring(0, 2) + File.separator + 
					fileVector.projectID + "-" + fileVector.projectName;
		}
		return "";
	}
	
	private String getProjectDir(FileVector fileVector) {
		String projID = fileVector.projectID;
		String repo6789 = "/home/lihaiyang/githubrepo";
		String repo1012 = "/home/lihaiyang/res/githubrepo";
		String repo2x = "/home/lihaiyang/allgithubrepo";
		String path = "";
		if(projID.length() == 5) {
			path = repo6789 + File.separator + projID.charAt(0) + File.separator + 
					projID + "-" + fileVector.projectName;
		}else if(projID.length() == 6) {
			if(projID.startsWith("1")) {
				path = repo1012 + File.separator + projID.substring(0, 2) + File.separator + 
						projID + "-" + fileVector.projectName;
			}else if(projID.startsWith("2")) {
				path = repo2x + File.separator + projID.substring(0, 2) + File.separator + 
						projID + "-" + fileVector.projectName;
			}
		}
		File dir = new File(path);
		if(!dir.exists())
			return null;
		return path;
	}
	
	public ArrayList<FrequentSetSupportInfo> getSupportInfo(List<List<String>> frequentSet) {
		ArrayList<FrequentSetSupportInfo> subsetInfos = new ArrayList<FrequentSetSupportInfo>();
		
		for(List<String> set : frequentSet) {
			FrequentSetSupportInfo subsetInfo = new FrequentSetSupportInfo(set);
			for(FileVector fileVector : this.fileVectors) {
				for(int i = 0; i < fileVector.methodVectorSets.size(); i ++) {
					if(fileVector.methodVectorSets.get(i).containsAll(set)) {
						subsetInfo.fileVectors.add(fileVector);
						subsetInfo.varietyPossionInFileVectors.add(i);
					}
				}
			}
			subsetInfos.add(subsetInfo);
		}
		
		return subsetInfos;
	}
	public List<Pair<List<String>, Long>> getVarietyVector(){
		List<Pair<List<String>, Long>> dataset = new ArrayList<Pair<List<String>,Long>>();
		List<FileVector> fileVectorsToRemove = new ArrayList<FileVector>();
		
		for(FileVector fileVector : this.fileVectors) {
			boolean isUsed = false;
			for(HashSet<String> methodSet : fileVector.methodVectorSets) {
				if(methodSet.isEmpty())
					continue;
				List<String> addvec = new ArrayList<String>();
				List<String> delvec = new ArrayList<String>();
				/*区分添加和删除方法*/
				for(String method : methodSet) {
					if(method.startsWith("-"))
						delvec.add(method.substring(1));
					else {
						addvec.add(method.substring(1));
					}
				}
				/*去除如下情况： 1. 在删除和添加中都存在的方法， 2. 只删除或者添加的情况, 剩余情况加入向量列表*/
				List<String> methodList = new ArrayList<String>();
				if(addvec.isEmpty() || delvec.isEmpty()) {
					continue;
				}else if(addvec.size() == delvec.size() && addvec.containsAll(delvec)) {
					continue;
				}else {
					isUsed = true;
					for(String m : addvec) {
						if(!delvec.contains(m))
							methodList.add("+" + m);
						else 
							methodSet.remove("+" + m);
					}
					for(String m : delvec) {
						if(!addvec.contains(m))
							methodList.add("-" + m);
						else 
							methodSet.remove("-" + m);
					}
				}
				/*获得变更向量*/
				Long l1 = new Long(1);
				dataset.add(new Pair<List<String>, Long>(methodList, l1));
			}
			if(!isUsed)
				fileVectorsToRemove.add(fileVector);
		}
		this.fileVectors.removeAll(fileVectorsToRemove);
		return dataset;
	}
	@SuppressWarnings("static-access")
	public void filterMethods(FPGrowthRunner runner, int maxTimes, String outPath) {
		String[] args = {"-s", String.valueOf(maxTimes), "-o", outPath};
		try {
			ToolRunner.run(new Configuration(), runner, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Pair<String, TopKStringPatterns>> frequentPatterns = runner.frequentPatterns;
		List<String> methodToRemove = new ArrayList<String>();
		for (Pair<String, TopKStringPatterns> entry : frequentPatterns) {
		     methodToRemove.add(entry.getFirst());
		}
		for(Pair<List<String>, Long> pair : runner.dataset) {
			List<String> subset = pair.getFirst();
			for(String method : methodToRemove) {
				if(subset.contains(method))
					subset.remove(method);
			}
		}
		runner.frequentPatterns.clear();
	}
	
	@SuppressWarnings("static-access")
	public List<List<String>> generateFrequentPattern(FPGrowthRunner runner, int minTimes, String outPath) {
		String[] args = {"-s", String.valueOf(minTimes), "-o", outPath};
		try {
			ToolRunner.run(new Configuration(), runner, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<List<String>> frequentSet = new ArrayList<List<String>>();
		for (Pair<String, TopKStringPatterns> entry : runner.frequentPatterns) {
		     List<Pair<List<String>, Long>> pairs = entry.getSecond().getPatterns();
		     for(Pair<List<String>, Long> pair : pairs) {
		    	 List<String> subset = pair.getFirst();
		    	 if(!frequentSet.contains(subset))
		    		 frequentSet.add(subset);
		     }
		}
		return frequentSet;
	}
}
