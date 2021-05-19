package cn.net.cobot.mining.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import cn.net.cobot.mining.database.Connection;
import cn.net.cobot.mining.database.ProjectInfoOperation;
import cn.net.cobot.mining.model.ProjectInfo;

public class RunAnalyze {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("需要如下参数");
			System.out.println("java -jar test.jar responstory_path action workspace libpath threadNum threadCount");
			System.out.println("action = P or V or S, 分别代表插入projectinfo， 插入变更信息， 分析变更信息获得结果");
			System.exit(-1);
		}
		boolean DEBUG = false;
		RunAnalyze run = new RunAnalyze();
		if(DEBUG)
			run.debugRUn(args);
		switch (args[1]) {
		case "-V":
			run.insertVarietyInfo(args);
			break;
		case "-S":
			run.insertVarietyInfoSingleThread(args);
			break;
		case "-C":
			try {
				run.insertProjectInfo(args);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	private void insertProjectInfo(String[] args) throws Exception {
		InsertProjectInfo insert = new InsertProjectInfo();
		insert.insertProjectInfoByCsv(args);
	}

	private void insertVarietyInfoSingleThread(String[] args) {
		Connection databaseConnection = new Connection();
		ProjectInfoOperation projectInfoOperation = new ProjectInfoOperation(databaseConnection);

		ArrayList<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
		projectInfos.addAll(projectInfoOperation.selectAllProjectInfo());

		String repostoryPath = args[0];
		String workspace = args[2];
		String libPath = args[3];
		int threadNumber = Integer.parseInt(args[4]);
		int threadCount = Integer.parseInt(args[5]);
		ArrayList<String> libList = getFiles(libPath);
		
		InsertVarietyInfo insert = new InsertVarietyInfo();
		insert.libJars = libList;
		insert.databaseConnection = databaseConnection;
		insert.repostoryPath = repostoryPath;
		insert.workspace = workspace + File.separator + args[4];
		for(int i = 0; i < projectInfos.size(); i ++) {
			if(i % threadCount == threadNumber) {
				insert.projects.add(projectInfos.get(i));
			}
		}
		insert.run();
		
	}
	private void insertVarietyInfo(String[] args) {
		Connection databaseConnection = new Connection();
		ProjectInfoOperation projectInfoOperation = new ProjectInfoOperation(databaseConnection);

		ArrayList<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
		projectInfos.addAll(projectInfoOperation.selectAllProjectInfo());

		String repostoryPath = args[0];
		String workspace = args[2];
		String libPath = args[3];
		int threadCount = Integer.parseInt(args[4]);
		ArrayList<String> libList = getFiles(libPath);
		/* create threads */
		List<InsertVarietyInfo> threads = new ArrayList<InsertVarietyInfo>();
		for(int i = 0; i < threadCount; i ++) {
			InsertVarietyInfo t = new InsertVarietyInfo();
			t.libJars = libList;
			t.databaseConnection = databaseConnection;
			t.repostoryPath = repostoryPath;
			t.workspace = workspace + File.separator + String.valueOf(i);
			threads.add(t);
		}
		
		/* split projects to run*/
		for(int i = 0; i < projectInfos.size(); i ++) {
			threads.get(i%threadCount).projects.add(projectInfos.get(i));
		}
		for(int i = 0; i < threadCount; i ++) {
			threads.get(i).start();;
		}
		for(int i = 0; i < threadCount; i ++) {
			try {
				threads.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
		}
//		databaseConnection.releaseSession();
		
	}
	private void debugRUn(String[] args) {
		Connection databaseConnection = new Connection();
		ProjectInfoOperation projectInfoOperation = new ProjectInfoOperation(databaseConnection);

		ArrayList<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
		projectInfos.addAll(projectInfoOperation.selectAllProjectInfo());

		String repostoryPath = args[0];
		String workspace = args[2];
		String libPath = args[3];
		ArrayList<String> libList = getFiles(libPath);
		
		InsertVarietyInfo t = new InsertVarietyInfo();
		t.libJars = libList;
		t.databaseConnection = databaseConnection;
		t.repostoryPath = repostoryPath;
		t.workspace = workspace + File.separator + String.valueOf(5);
		t.projects = projectInfos;
		
		t.run();
	}
	ArrayList<String> getFiles(String dirPath){
		ArrayList<String> files = new ArrayList<String>();
		for(String name : (new File(dirPath)).list()) {
			String aPath = dirPath + File.separator + name;
			if((new File(aPath)).isDirectory())
				files.addAll(getFiles(aPath));
			else if(aPath.endsWith(".jar"))
				files.add(aPath);
		}
		return files;
	}

}
