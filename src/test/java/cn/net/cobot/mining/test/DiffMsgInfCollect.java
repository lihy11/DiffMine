package cn.net.cobot.mining.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DiffMsgInfCollect {
	private String filePath;
	ArrayList<ArrayList<String>> totalDiffCodes;
	ArrayList<HashMap<String, Integer>> changeSet;
	public static String ADD_POSSION = "add_possion", DEL_POSSION = "del_possion", ADD_WIDTH = "add_width",
			DEL_WIDTH = "del_width";
	private final int LIMITPerFile = 8;
	private final int LIMITTotal = 128;

	public DiffMsgInfCollect() {
		filePath = "";
		changeSet = new ArrayList<HashMap<String, Integer>>();
		totalDiffCodes = new ArrayList<ArrayList<String>>();
	}

	// readDiff and then get add and remove list
	public HashSet<DiffMsgInfCollect> readDiffFiles(String diffMsg) {
		HashSet<DiffMsgInfCollect> diffs = new HashSet<DiffMsgInfCollect>();
		if (diffMsg == null)
			return diffs;
		InputStream input = new ByteArrayInputStream(diffMsg.getBytes());
		InputStreamReader streamReader = new InputStreamReader(input);
		BufferedReader reader = new BufferedReader(streamReader);
		String line = "";
		String filePath = "";
		DiffMsgInfCollect diff = null;

		try {
			line = reader.readLine();
			while (line != null) {
				diff = new DiffMsgInfCollect();
				while (line != null) {
					if (line.length() > 10 && line.substring(0, 10).equals("diff --git"))
						break;
					line = reader.readLine();
				}
				if (line == null)
					continue;
				int indexOfPath = line.indexOf(" b/");
				if (indexOfPath != -1) {
					indexOfPath += 3;
					filePath = line.substring(indexOfPath);
					diff.setFilePath(filePath);
				}
				// 一些不相关的信息
				line = reader.readLine();
				if (line.startsWith("index ")) {
					line = reader.readLine();
				} else {
					line = reader.readLine();
					line = reader.readLine();
				}
				if (line.startsWith("--- ")) {
					line = reader.readLine();
					if (line.startsWith("+++ "))
						line = reader.readLine();
				}
				while (line != null) {
					if (line.length() > 10 && line.substring(0, 10).equals("diff --git"))
						break;
					// get the code block of this change part,begin with line number and possion;
					ArrayList<String> totalCode = new ArrayList<String>();
					if (line.startsWith("@@")) {
						totalCode.add(line);
					}
					line = reader.readLine();
					while (line != null) {
						if (line.length() > 10 && line.substring(0, 10).equals("diff --git"))
							break;
						if (line.startsWith("@@ "))
							break;
						totalCode.add(line);
						line = reader.readLine();
					}
					diff.totalDiffCodes.add(totalCode);
				}
				if (diff != null && sumMsg(diff) < LIMITPerFile)
					diffs.add(diff);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!shouldCommitBeChecked(diffs)) {
			diffs.clear();
		}
		for (DiffMsgInfCollect d : diffs) {
			d.getChangeSet(d);
		}
		return diffs;
	}
	public HashSet<DiffMsgInfCollect> readDiffMsg(String diffMsg){
		HashSet<DiffMsgInfCollect> diffMsgInfCollects = new HashSet<DiffMsgInfCollect>();
		if (diffMsg == null || diffMsg.length() > 4096)
			return diffMsgInfCollects;
		InputStream input = new ByteArrayInputStream(diffMsg.getBytes());
		InputStreamReader streamReader = new InputStreamReader(input);
		BufferedReader reader = new BufferedReader(streamReader);
		
		String line = "";
		DiffMsgInfCollect diff = null;
		ArrayList<String> code = null;
		try {
			while((line = reader.readLine()) != null) {
				if(line.startsWith("diff --git")) {   //start a new file
					if(code != null && diff != null) {  //上一个文件的代码块
						diff.totalDiffCodes.add(code);
					}
					code = null;
					if(diff != null && this.sumMsg(diff) < LIMITPerFile) {  //前面找到了变更的文件，加入返回列表  
						diffMsgInfCollects.add(diff);
					}
					diff = new DiffMsgInfCollect();
					int indexOfPath = line.indexOf(" b/");   //set file path
					if (indexOfPath != -1) {
						indexOfPath += 3;
						diff.setFilePath(line.substring(indexOfPath));
					}
				}else if(line.startsWith("@@")) {   //start a new code
					if(code != null && diff != null) {  //前面已经找到了这个文件的部分代码块，加入diff
						diff.totalDiffCodes.add(code);
					}
					code = new ArrayList<String>();
					code.add(line);
				}else {
					if(diff != null && code != null) {
						code.add(line);
					}
				}
			}
			if(code != null && diff != null) {
				diff.totalDiffCodes.add(code);
				if(sumMsg(diff) < LIMITPerFile)
					diffMsgInfCollects.add(diff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!shouldCommitBeChecked(diffMsgInfCollects)) {
			diffMsgInfCollects.clear();
		}
		for (DiffMsgInfCollect d : diffMsgInfCollects) {
			d.getChangeSet(d);
		}
		return diffMsgInfCollects;
	}
	private boolean shouldCommitBeChecked(HashSet<DiffMsgInfCollect> diffs) {
		int totalChange = 0;
		for (DiffMsgInfCollect diff : diffs) {
			String path = diff.getFilePath();
			if (path.lastIndexOf(".java") == -1 || path.contains("test")) {
				continue;
			}
			for (ArrayList<String> code : diff.totalDiffCodes) {
				totalChange += code.size();
			}
			if (totalChange > LIMITTotal) {
				return false;
			}
		}

		return true;
	}

	private DiffMsgInfCollect getChangeSet(DiffMsgInfCollect diff) {
		int oldLineNum = 0, newLineNum = 0;
		int addWidth = 0, delWidth = 0, addStart = 0, delStart = 0;
		boolean firstMeetDel = true, firstMeetAdd = true;
		for (ArrayList<String> code : diff.totalDiffCodes) {
			if (code.size() == 0)
				continue;
			if (!code.get(0).startsWith("@@ ")) {
				System.out.println("your code is not regular\n\n");
				System.out.println(code.get(0));
				continue;
			}
			String[] tmp = code.get(0).split(" ");
			oldLineNum = Integer.parseInt(tmp[1].split(",")[0].substring(1));
			newLineNum = Integer.parseInt(tmp[2].split(",")[0].substring(1));
			for (int i = 1; i < code.size(); i++) {
				String line = code.get(i);
				if (line.startsWith("-")) {
					if (firstMeetDel) {
						delStart = oldLineNum;
						delWidth++;
						firstMeetDel = false;
					} else {
						delWidth++;
					}
					oldLineNum++;
				} else if (line.startsWith("+")) {
					if (firstMeetAdd) {
						addStart = newLineNum;
						addWidth++;
						firstMeetAdd = false;
					} else {
						addWidth++;
					}
					newLineNum++;
				} else {
					if (!firstMeetDel || !firstMeetAdd) {
						HashMap<String, Integer> change = new HashMap<String, Integer>();
						change.put(ADD_POSSION, addStart);
						change.put(ADD_WIDTH, addWidth);
						change.put(DEL_POSSION, delStart);
						change.put(DEL_WIDTH, delWidth);
						diff.changeSet.add(change);
						addWidth = delWidth = addStart = delStart = 0;
						firstMeetAdd = firstMeetDel = true;
					}
					oldLineNum++;
					newLineNum++;
				}
			}
		}
		return diff;
	}

	private int sumMsg(DiffMsgInfCollect diff) {
		int sum = 0;
		for (ArrayList<String> code : diff.totalDiffCodes) {
			for (String string : code) {
				if (string.startsWith("+") || string.startsWith("-"))
					sum++;
			}
		}
		return sum;
	}

	@SuppressWarnings("unused")
	private int getIntFromString(String value) {
		int intValue = -1;
		if (value.startsWith("-") || value.startsWith("+")) {
			intValue = Integer.valueOf(value.substring(1));
		} else {
			intValue = Integer.valueOf(value);
		}
		return intValue;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}
}