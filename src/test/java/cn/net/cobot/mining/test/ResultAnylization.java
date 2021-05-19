package cn.net.cobot.mining.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ResultAnylization {
	
	public static void main(String[] args) {
		String allResultPath = "/home/lihaiyang/miner/midresult/allresult";
		String frequentSetPath = "/home/lihaiyang/miner/midresult/frequent";
		String objectMapPath="/home/lihaiyang/miner/midresult/modelObject.txt";
		String resultHome = "/home/lihaiyang/miner/result"; 
		String projectRepo = "/home/lihaiyang/miner/projects";
		String min_support = "5";
		ResultAnylization showResult = new ResultAnylization();
	
		try {
			HashMap<String, ArrayList<CommitVector>> allResultMap = showResult.getAllResultMap(allResultPath);
			System.out.println("生成变更向量文件");
			String vecHome = "/home/lihaiyang/miner/midresult";
			showResult.generateVecFile(vecHome, allResultMap);
			
			System.out.println("过滤过度常用的方法");
			String fimPath = "/home/lihaiyang/miner/fimi06/fim_closed";
			showResult.filterMethod(vecHome + "/apivec", fimPath, "500");
			
			System.out.println("生成频繁子集文件");
			Runtime.getRuntime().exec(fimPath + " " + vecHome + "/apivec_filtered" + " " 
									+ min_support + " " + frequentSetPath).waitFor();
			
			System.out.println("分析结果");
			showResult.anylizeResult(frequentSetPath, allResultMap, objectMapPath, projectRepo, resultHome);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void generateVecFile(String vecHome, HashMap<String, ArrayList<CommitVector>> allResultMap) throws IOException {
		String apiVecPath = vecHome + "/" + "apivec";
		String otherVecPath = vecHome + "/" + "othervec";
		BufferedWriter apiWriter = new BufferedWriter(new FileWriter(apiVecPath));
		BufferedWriter otherWriter = new BufferedWriter(new FileWriter(otherVecPath));
		
		for(String projectName : allResultMap.keySet()) {
			for(CommitVector commitVector : allResultMap.get(projectName)) {
				for(String filePath : commitVector.fileVectors.keySet()) {
					FileVector fileVector = commitVector.fileVectors.get(filePath);
					
					ArrayList<HashSet<String> > subsetToRemove = new ArrayList<HashSet<String>>();
					
					for (int i = 0; i < fileVector.secVectors.size(); i++) {
						HashSet<String> subset = fileVector.secVectors.get(i);
						if (subset.size() == 0) {
							subsetToRemove.add(subset);
							continue;
						}
						ArrayList<Integer> addvec = new ArrayList<Integer>();
						ArrayList<Integer> delvec = new ArrayList<Integer>();
						for (String num : subset) {
							if(num.startsWith("+"))
								addvec.add(Integer.parseInt(num.substring(1)));
							else if(num.startsWith("-"))
								delvec.add(Integer.parseInt(num.substring(1)));
						}
						if(addvec.size() == delvec.size() && addvec.containsAll(delvec)) {
							subsetToRemove.add(subset);
							for (String num : subset) {
								otherWriter.write(num + " ");
							}
							otherWriter.write("\n");
							
						}else if(addvec.size() == 0 || delvec.size() == 0){
							subsetToRemove.add(subset);
							continue;
						}else {
							for(int num : addvec) {
								if(!delvec.contains(num))
									apiWriter.write("+" + String.valueOf(num) + " ");
								else {
									subset.remove("+" + String.valueOf(num));
								}
							}
							for(int num : delvec) {
								if(!addvec.contains(num))
									apiWriter.write("-" + String.valueOf(num) + " ");
								else {
									subset.remove("-" + String.valueOf(num));
								}
							}
							apiWriter.write("\n");
						}
					}
					fileVector.secVectors.removeAll(subsetToRemove);
				}
			}
			otherWriter.flush();
			apiWriter.flush();
		}
		otherWriter.close();
		apiWriter.close();
	}
	public HashMap<String, ArrayList<CommitVector>> getAllResultMap(String allResultPath) throws Exception{
		HashMap<String, ArrayList<CommitVector>> allResultMap = new HashMap<String, ArrayList<CommitVector>>();
		BufferedReader reader = new BufferedReader(new FileReader(allResultPath));
		String line = reader.readLine();
		String projName = "";
		while(line != null) {
			projName = line.trim();
			line = reader.readLine();
			ArrayList<CommitVector> commitVectors = new ArrayList<CommitVector>();
			while(line != null && line.startsWith("----")) {
				String commiID = line.split(" ")[1];
				line = reader.readLine();
				HashMap<String,FileVector> fileVectors = new HashMap<String,FileVector>();
				while(line != null && line.startsWith("---- ----")) {
					FileVector fileVector = new FileVector();
					fileVector.path = line.split(" ")[2];
					line = reader.readLine();
					while(line != null && line.startsWith("---- ---- ----")) {
						HashMap<String, Integer> change = new HashMap<String, Integer>();
						HashSet<String> vec = new HashSet<String>();
						String[] tmp = line.split(" ");
						change.put(DiffMsgInfCollect.ADD_POSSION, Integer.valueOf(tmp[3].split(":")[1]));
						change.put(DiffMsgInfCollect.ADD_WIDTH,Integer.valueOf(tmp[4].split(":")[1]));
						change.put(DiffMsgInfCollect.DEL_POSSION, Integer.valueOf(tmp[5].split(":")[1]));
						change.put(DiffMsgInfCollect.DEL_WIDTH,Integer.valueOf(tmp[6].split(":")[1]));
						for(int i = 7; i < tmp.length; i ++) {
							vec.add(tmp[i]);
						}
						fileVector.changeSet.add(change);
						fileVector.secVectors.add(vec);
						line = reader.readLine();
					}
					if(fileVector.changeSet.size() != 0) {
						fileVectors.put(fileVector.path, fileVector);
					}
				}
				if(fileVectors.size() != 0) {
					CommitVector commitVector = new CommitVector();
					commitVector.commitID = commiID;
					commitVector.fileVectors = fileVectors;
					commitVectors.add(commitVector);
				}
			}
			if(commitVectors.size() != 0) {
				if(allResultMap.containsKey(projName)) {
					if(allResultMap.get(projName).size() < commitVectors.size())
						allResultMap.put(projName, commitVectors);
				}else {
					allResultMap.put(projName, commitVectors);
				}
			}
		}
		reader.close();
		return allResultMap;
	}
	public void anylizeResult(String frequentSetPath, HashMap<String, ArrayList<CommitVector>> allResultMap,
			String mapObjPath, String projectDir, String resultHome) 
	{
		/*  1. 读取频繁子集*/
		ArrayList<ArrayList<String> > frequentSubset = null;
		try {
			frequentSubset = getFrequentSubset(frequentSetPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*   2. 找到支持频繁子集的项目*/
		System.out.println("找到支持频繁子集的项目");
		ArrayList<FrequentSetSupportInfo> frequentSetSupportInfos = getSupportInfo(allResultMap, frequentSubset);
		
		/*  4. 分析打印处理结果*/
		try {
			printAllResultFinal(frequentSetSupportInfos,mapObjPath,projectDir,resultHome);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private ArrayList<FrequentSetSupportInfo> getSupportInfo(HashMap<String, ArrayList<CommitVector>> allResultMap,
			ArrayList<ArrayList<String>> frequentSubset) {
		ArrayList<FrequentSetSupportInfo> subsetInfos = new ArrayList<FrequentSetSupportInfo>();
		for(ArrayList<String> subset : frequentSubset) {
			FrequentSetSupportInfo subsetInfo = new FrequentSetSupportInfo(new HashSet<String>(subset));
			for(String projName : allResultMap.keySet()) {
				for(CommitVector commit : allResultMap.get(projName)) {
					for(String filePath : commit.fileVectors.keySet()) {
						FileVector fileVector = commit.fileVectors.get(filePath);
						for(int i = 0; i < fileVector.secVectors.size(); i ++) {
							if(fileVector.secVectors.get(i).containsAll(subset)) {
								subsetInfo.projName.add(projName);
								subsetInfo.filePath.add(filePath);
								subsetInfo.commitID.add(commit.commitID);
								subsetInfo.changeMap.add(fileVector.changeSet.get(i));
							}
						}
					}
				}
			}
			subsetInfos.add(subsetInfo);
		}
		return subsetInfos;
	}

	/**
	 * 总表：模式编号 | 删除方法 | 添加方法 | 支持工程数 | 支持提交数 |
	 * 单独结果：
	 * .md: 添加方法：xxx
	 *	    删除方法：ccc
	 *	    变更代码：随机提取最多十段代码
	 *.csv : 项目名称 | 对应支持提交 ...|
	 * @param frequentSubset
	 * @param projects
	 * @param subset2Project
	 * @param projectDir 
	 * @param mapObjPath 
	 * @param resultHome 
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void printAllResult(ArrayList<FrequentSetSupportInfo> subsetInfos,
			String mapObjPath, String projectDir, String resultHome) throws IOException{
		
		Map<Info,Integer> methodNumMap = JavaMinerUtility.readObjectMap(mapObjPath);
		
		String allResultPath = resultHome + "/result";
		File allFile = new File(allResultPath);
		if(!allFile.exists())
			allFile.mkdir();
		String paramChangeModePath = resultHome + "/param_change.csv";
		BufferedWriter paramChangeWriter = new BufferedWriter(new FileWriter(paramChangeModePath));
		paramChangeWriter.write("NO,Method del, Method add, project support, commit support\n");
		
		String apiChangePath = resultHome + "/api_change.csv";
		BufferedWriter apiChangeWriter = new BufferedWriter(new FileWriter(apiChangePath));
		apiChangeWriter.write("NO,Method del, Method add, project support, commit support\n");
		
		String delAddChangePath = resultHome + "/del_add_change.csv";
		BufferedWriter delAddChangeWriter = new BufferedWriter(new FileWriter(delAddChangePath));
		delAddChangeWriter.write("NO,Method del, Method add, project support, commit support\n");
		
		for(int modeNO = 0; modeNO < subsetInfos.size(); modeNO++) {
			FrequentSetSupportInfo info = subsetInfos.get(modeNO);
			System.out.println("处理第" +modeNO + " / " +  subsetInfos.size() + "，模式");
			/*获取删除添加的方法*/
			/*子文件夹*/
			String dirPath = allResultPath + "/" + String.valueOf(modeNO);
			File dir = new File(dirPath);
			dir.mkdir();
			BufferedWriter mdWriter = new BufferedWriter(new FileWriter(dirPath + "/result.md"));
			/*方法相关信息*/
			ArrayList<Integer> numadd = new ArrayList<Integer>();
			ArrayList<Integer> numdel = new ArrayList<Integer>();
			String methodDel = "";
			String methodAdd = "";
			for(String num: info.frequentSet) {
				int methodnum = Integer.parseInt(num);
				String name = methodNameOfNum(methodNumMap, methodnum);
				if(methodnum > 0) {
					numadd.add(methodnum);
					methodAdd += name + " ";
				}else {
					numdel.add(0 - methodnum);
					methodDel += name + " ";
				}
			}
			mdWriter.write("###  统计信息\n");
			mdWriter.write("删除方法：\n");
			mdWriter.write(methodDel.replace(' ', '\n'));
			mdWriter.write("添加方法：\n");
			mdWriter.write(methodAdd.replace(' ', '\n'));
			mdWriter.flush();
			
			/*获取支持工程和提交*/
			BufferedWriter csvWriter = new BufferedWriter(new FileWriter(dirPath + "/result.csv"));
			for(int count = 0; count < info.projName.size(); count ++) {
				csvWriter.write(info.projName.get(count) + "," + info.commitID.get(count) + "," + info.filePath.get(count) + "\n");
			}
			csvWriter.close();
			/*支持度数据*/
			HashSet<String> projNames = new HashSet<String>(info.projName);
			String projSupport = String.valueOf(projNames.size());
			String commitSupport = String.valueOf(info.commitID.size());
			mdWriter.write("###  支持度\n");
			mdWriter.write("项目数量 : " + projSupport + "\n");
			mdWriter.write("提交数量 : " + commitSupport + "\n");
			/*判断是否是参数变更,将数据写入各自的表格*/
			if(numadd.size() == numdel.size() &&  numadd.containsAll(numdel)) {
				paramChangeWriter.write(String.valueOf(modeNO) + "," + methodDel + "," 
								+ methodAdd + "," + projSupport + "," + commitSupport + "," + "\n");
			}else if(numadd.size() != 0 && numdel.size() != 0){
				apiChangeWriter.write(String.valueOf(modeNO) + "," + methodDel + "," 
								+ methodAdd + "," + projSupport + "," + commitSupport + "," + "\n");
			}else {
				delAddChangeWriter.write(String.valueOf(modeNO) + "," + methodDel + "," 
								+ methodAdd + "," + projSupport + "," + commitSupport + "," + "\n");
			}
			
			/*写入变更代码*/
			mdWriter.write("###  提交代码\n");
			GitCommand git = null;
			for(int count  = 0; count < info.projName.size(); count ++) {
				String proName = info.projName.get(count);
				String commitID = info.commitID.get(count);
				String filePath = info.filePath.get(count);
				HashMap<String, Integer> change = info.changeMap.get(count);
				mdWriter.write("**" + proName + "**\n" + "**" + commitID + "**\n" + "**" + filePath + "**\n");
				if(git == null ) {
					git=new GitCommand(projectDir + "/" + proName);
				}else if(!git.prjPath.equals(projectDir + "/" + proName)) {
					git.realseGit();
					git = new GitCommand(projectDir + "/" + proName);
				}
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
					mdWriter.write("/*somrthing must be wrong!,there is no code*/\n");
				}else {
					writeCode(realCode, mdWriter, change);
				}
				mdWriter.write("```\n");
				mdWriter.flush();
			}
			mdWriter.close();
			paramChangeWriter.flush();
			apiChangeWriter.flush();
			delAddChangeWriter.flush();
		}
		paramChangeWriter.close();
		apiChangeWriter.close();
		delAddChangeWriter.close();
	}
	
	private void printAllResultFinal(ArrayList<FrequentSetSupportInfo> subsetInfos,
			String mapObjPath, String projectDir, String resultHome) throws IOException{
		
		Map<Info,Integer> methodNumMap = JavaMinerUtility.readObjectMap(mapObjPath);
		
		String allResultPath = resultHome + "/result";
		File allFile = new File(allResultPath);
		if(!allFile.exists())
			allFile.mkdir();
		
		String apiChangePath = resultHome + "/api_change.csv";
		BufferedWriter apiChangeWriter = new BufferedWriter(new FileWriter(apiChangePath));
		apiChangeWriter.write("NO,Method del, Method add, project support, commit support\n");
		
		for(int modeNO = 0; modeNO < subsetInfos.size(); modeNO++) {
			FrequentSetSupportInfo info = subsetInfos.get(modeNO);
			System.out.println("处理第" +modeNO + " / " +  subsetInfos.size() + "，模式");
			/*获取删除添加的方法*/
			/*子文件夹*/
			String dirPath = allResultPath + "/" + String.valueOf(modeNO);
			File dir = new File(dirPath);
			dir.mkdir();
			BufferedWriter mdWriter = new BufferedWriter(new FileWriter(dirPath + "/result.md"));
			/*方法相关信息*/
			String methodDel = "";
			String methodAdd = "";
			for(String num: info.frequentSet) {
				int methodnum = Integer.parseInt(num);
				String name = methodNameOfNum(methodNumMap, methodnum);
				if(methodnum > 0) {
					methodAdd += name + " ";
				}else {
					methodDel += name + " ";
				}
			}
			mdWriter.write("###  统计信息\n");
			mdWriter.write("删除方法：\n");
			mdWriter.write(methodDel.replace(' ', '\n'));
			mdWriter.write("添加方法：\n");
			mdWriter.write(methodAdd.replace(' ', '\n'));
			mdWriter.flush();
			
			/*获取支持工程和提交*/
			BufferedWriter csvWriter = new BufferedWriter(new FileWriter(dirPath + "/result.csv"));
			for(int count = 0; count < info.projName.size(); count ++) {
				csvWriter.write(info.projName.get(count) + "," + info.commitID.get(count) + "," + info.filePath.get(count) + "\n");
			}
			csvWriter.close();
			/*支持度数据*/
			HashSet<String> projNames = new HashSet<String>(info.projName);
			String projSupport = String.valueOf(projNames.size());
			String commitSupport = String.valueOf(info.commitID.size());
			mdWriter.write("###  支持度\n");
			mdWriter.write("项目数量 : " + projSupport + "\n");
			mdWriter.write("提交数量 : " + commitSupport + "\n");
			
			/*判断是否是参数变更,将数据写入各自的表格*/
			apiChangeWriter.write(String.valueOf(modeNO) + "," + methodDel + "," 
								+ methodAdd + "," + projSupport + "," + commitSupport + "," + "\n");
			
			/*写入变更代码*/
			mdWriter.write("###  提交代码\n");
			GitCommand git = null;
			for(int count  = 0; count < info.projName.size(); count ++) {
				String proName = info.projName.get(count);
				String commitID = info.commitID.get(count);
				String filePath = info.filePath.get(count);
				HashMap<String, Integer> change = info.changeMap.get(count);
				mdWriter.write("**" + proName + "**\n" + "**" + commitID + "**\n" + "**" + filePath + "**\n");
				if(git == null ) {
					git=new GitCommand(projectDir + "/" + proName);
				}else if(!git.prjPath.equals(projectDir + "/" + proName)) {
					git.realseGit();
					git = new GitCommand(projectDir + "/" + proName);
				}
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
					mdWriter.write("/*somrthing must be wrong!,there is no code*/\n");
				}else {
					writeCode(realCode, mdWriter, change);
				}
				mdWriter.write("```\n");
				mdWriter.flush();
			}
			mdWriter.close();
			apiChangeWriter.flush();
		}
		apiChangeWriter.close();
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
	private String methodNameOfNum(Map<Info,Integer> methodMap, Integer num) {
		if(num < 0) {
			num = -num;
		}
		for(Info info : methodMap.keySet()) {
			if(methodMap.get(info).equals(num)) {
				if(info instanceof MethodInfo)
					return ((MethodInfo)info).getPackageName() + "." +  info.getInfoName();
				else if(info instanceof AnnotationInfo) {
					return info.getInfoName();
				}
			}
		}
		return null;
	}
	
	private  ArrayList<ArrayList<String>> getFrequentSubset(String frequentItemPath) throws Exception{
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		System.out.println("读取频繁子集");
		BufferedReader reader = new BufferedReader(new FileReader(frequentItemPath));
		String line = reader.readLine();
		while(line != null) {
			ArrayList<String> subset = new ArrayList<String>();
			for(String num : line.split(" ")) {
				if(num.startsWith("(") && num.endsWith(")")) {
					continue;
				}else {
					subset.add(num);
				}
			}
			if(subset.size() > 1)
				result.add(subset);
			line = reader.readLine();
		}
		reader.close();
		return result;
	}
	private void filterMethod(String vecPath,String fimPath, String filter_count) throws Exception {
		String newVecPath = vecPath + "_filtered";
		Runtime.getRuntime().exec(fimPath + " " + vecPath + " " + filter_count + " " + newVecPath).waitFor();
		BufferedReader reader = new BufferedReader(new FileReader(newVecPath));
		String line = "";
		ArrayList<ArrayList<String>> setFiltered = new ArrayList<ArrayList<String>>();
		
		while((line = reader.readLine()) != null) {
			ArrayList<String> subset = new ArrayList<String>();
			String[] tmp = line.split(" ");
			for(String t : tmp) {
				if(t.startsWith("(") )
					continue;
				else {
					subset.add(t);
				}
			}
			if(!subset.isEmpty())
				setFiltered.add(subset);
		}
		reader.close();
		ArrayList<ArrayList<String>> set = new ArrayList<ArrayList<String>>();
		reader = new BufferedReader(new FileReader(vecPath));
		while((line = reader.readLine()) != null) {
			ArrayList<String> subset = new ArrayList<String>();
			String[] tmp = line.split(" ");
			for(String t : tmp) {
				if(t.startsWith("(") )
					continue;
				else {
					subset.add(t);
				}
			}
			if(!subset.isEmpty())
				set.add(subset);
		}
		reader.close();
		for(ArrayList<String> subset : setFiltered) {
			for(ArrayList<String> s : set) {
				s.removeAll(subset);
			}
		}
		BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(newVecPath));
		for(ArrayList<String> subset : set) {
			if(subset.size() == 0)
				continue;
			else {
				for(String string : subset)
					writer.write(string + " ");
				writer.write("\n");
			}
		}
		writer.close();
	}
}