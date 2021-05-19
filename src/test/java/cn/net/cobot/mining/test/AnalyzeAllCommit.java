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

public class AnalyzeAllCommit {
	public static void main(String args[]) {
		try {
			if(args.length != 1) {
				System.out.println("命令行参数不对");
				System.exit(-1);
			}
			AnalyzeAllCommit anylizeAllCommit = new AnalyzeAllCommit();
			anylizeAllCommit.runStep(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void runStep(String NO) {
		String objectMapPath = "/home/lihaiyang/miner/midresult/modelObject.txt";
		String projectPath = "";

		String projectTestDir = "/home/lihaiyang/miner/projectTest"+NO;
		File dirFile = new File(projectTestDir);

		String viewedList = "/home/lihaiyang/miner/midresult/viewed_list"+NO;
		HashSet<String> viewed = null;
		try {
			viewed = getViewedList(viewedList);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String allResultPath = "/home/lihaiyang/miner/midresult/allresult"+NO;
		BufferedWriter viewedWriter = null,  allResult = null;
		try {
			viewedWriter = new BufferedWriter(new FileWriter(viewedList, true));
			allResult = new BufferedWriter(new FileWriter(allResultPath, true));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			for (String path : dirFile.list()) {
				projectPath = projectTestDir + "/" + path + "/";
				if (path.startsWith(".") || viewed.contains(path)) {
					try {
						Runtime.getRuntime().exec("rm -rf " + projectPath).waitFor();
					} catch (InterruptedException | IOException e) {
						e.printStackTrace();
					}
					continue;
				}
				File file = new File(projectPath);
				if (!file.exists() || file.isFile())
					continue;
				MethodVectors vectors = new MethodVectors(projectPath, objectMapPath);
				ArrayList<CommitVector> projectVector = null;
				try {
					projectVector = vectors.getVectors();
				} catch (NullPointerException e) {
					System.out.println(projectPath + "\n\n");
				} finally {
					try {
						Runtime.getRuntime().exec("rm -rf " + projectPath).waitFor();
					} catch (InterruptedException | IOException e) {
						e.printStackTrace();
					}
				}
				if (projectVector == null) {
					viewedWriter.write(path + "\n");
					viewedWriter.flush();
					continue;
				}
				allResult.write(path + "\n");
				for (CommitVector commitVector : projectVector) {
					allResult.write("---- " + commitVector.commitID + "\n");
					for (String filepath : commitVector.fileVectors.keySet()) {
						FileVector fileVector = commitVector.fileVectors.get(filepath);
						allResult.write("---- ---- " + filepath + "\n");
						for (int i = 0; i < fileVector.secVectors.size(); i++) {
							HashSet<String> subset = fileVector.secVectors.get(i);
							if (subset.size() == 0)
								continue;
							allResult.write("---- ---- ---- ");
							allResult.write("add_possion:"
									+ fileVector.changeSet.get(i).get(DiffMsgInfCollect.ADD_POSSION) + " ");
							allResult.write(
									"add_width:" + fileVector.changeSet.get(i).get(DiffMsgInfCollect.ADD_WIDTH) + " ");
							allResult.write("del_possion:"
									+ fileVector.changeSet.get(i).get(DiffMsgInfCollect.DEL_POSSION) + " ");
							allResult.write(
									"del_width:" + fileVector.changeSet.get(i).get(DiffMsgInfCollect.DEL_WIDTH) + " ");
							for (String num : subset) {
								allResult.write(num + " ");
							}
							allResult.write("\n");
						}
					}
				}
				allResult.flush();
				viewedWriter.write(path + "\n");
				viewedWriter.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				allResult.close();
				viewedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	void totalRun() throws Exception {
		String objectMapPath = "/home/lihaiyang/miner/midresult/modelObject.txt";
		String projectPath = "";

		String projectTestDir = "/home/lihaiyang/miner/projectTest";
		File dirFile = new File(projectTestDir);

		String vecResultPath = "/home/lihaiyang/miner/midresult/vecresult";
		String allResultPath = "/home/lihaiyang/miner/midresult/allresult";
		BufferedWriter vecResult = new BufferedWriter(new FileWriter(vecResultPath, true));
		BufferedWriter allResult = new BufferedWriter(new FileWriter(allResultPath, true));

		HashMap<String, ArrayList<CommitVector>> allResultMap = new HashMap<String, ArrayList<CommitVector>>();

		for (String path : dirFile.list()) {
			if (path.startsWith("."))
				continue;
			projectPath = projectTestDir + "/" + path + "/";
			File file = new File(projectPath);
			if (!file.exists() || file.isFile())
				continue;
			MethodVectors vectors = new MethodVectors(projectPath, objectMapPath);
			ArrayList<CommitVector> projectVector = vectors.getVectors();
			allResult.write(path + "\n");
			for (CommitVector commitVector : projectVector) {
				boolean thisVectorUsed = false;
				allResult.write("---- " + commitVector.commitID + "\n");
				for (String filepath : commitVector.fileVectors.keySet()) {
					FileVector fileVector = commitVector.fileVectors.get(filepath);
					allResult.write("---- ---- " + filepath + "\n");
					for (int i = 0; i < fileVector.secVectors.size(); i++) {
						HashSet<String> subset = fileVector.secVectors.get(i);
						if (subset.size() == 0)
							continue;
						allResult.write("---- ---- ---- ");
						allResult.write(
								"add_possion:" + fileVector.changeSet.get(i).get(DiffMsgInfCollect.ADD_POSSION) + " ");
						allResult.write(
								"add_width:" + fileVector.changeSet.get(i).get(DiffMsgInfCollect.ADD_WIDTH) + " ");
						allResult.write(
								"del_possion:" + fileVector.changeSet.get(i).get(DiffMsgInfCollect.DEL_POSSION) + " ");
						allResult.write(
								"del_width:" + fileVector.changeSet.get(i).get(DiffMsgInfCollect.DEL_WIDTH) + " ");
						for (String num : subset) {
							vecResult.write(num + " ");
							allResult.write(num + " ");
						}
						thisVectorUsed = true;
						vecResult.write("\n");
						allResult.write("\n");
					}
				}
				if (thisVectorUsed) {
					thisVectorUsed = false;
					if (!allResultMap.containsKey(path)) {
						allResultMap.put(path, new ArrayList<CommitVector>());
					}
					allResultMap.get(path).add(commitVector);
				}
			}
			allResult.flush();
			vecResult.flush();
		}
		vecResult.close();
		allResult.close();
		/* 数据挖掘 */
		String frequentSetPath = "/home/lihaiyang/miner/midresult/frequent";
		String cmd = "/home/lihaiyang/miner/fimi06/fim_closed";
		cmd += " " + vecResultPath;
		cmd += " " + "10";
		cmd += " " + frequentSetPath;
		Runtime.getRuntime().exec(cmd).waitFor();

		/* 结果展示 */
		String resultHome = "/home/lihaiyang/miner/result";
		String projectRepo = "/home/lihaiyang/miner";
		ResultAnylization showResult = new ResultAnylization();
		showResult.anylizeResult(frequentSetPath, allResultMap, objectMapPath, projectRepo, resultHome);
	}

	private HashSet<String> getViewedList(String path) throws Exception {
		HashSet<String> list = new HashSet<String>();
		File viewedFile = new File(path);
		if(!viewedFile.exists()){
			viewedFile.createNewFile();
			return list;
		}
		BufferedReader reader = new BufferedReader(new FileReader(viewedFile));
		String lineString = "";
		while ((lineString = reader.readLine()) != null) {
			if (lineString.equals(""))
				continue;
			list.add(lineString);
		}
		reader.close();
		return list;
	}
	
}