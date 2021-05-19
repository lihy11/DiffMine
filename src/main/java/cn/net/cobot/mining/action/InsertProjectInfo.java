package cn.net.cobot.mining.action;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.tools.ant.taskdefs.Exit;

import cn.net.cobot.mining.database.Connection;
import cn.net.cobot.mining.database.ProjectInfoOperation;
import cn.net.cobot.mining.model.ProjectInfo;

public class InsertProjectInfo {
	
	public static void main(String[] args) {
		InsertProjectInfo insert = new InsertProjectInfo();
		if(args.length < 1)
			System.exit(-1);
		try {
			insert.insertProjectInfoByTxt(args);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void insertProjectInfoByCsv(String[] args) throws Exception {
		String csvPathString = args[0];
		BufferedReader reader = new BufferedReader(new FileReader(csvPathString));
		String line = "";
		Connection databaseConnection = new Connection();
		ProjectInfoOperation projectInfoOperation = new ProjectInfoOperation(databaseConnection);
		while((line = reader.readLine()) != null) {
			System.out.println(line);
			String[] tmp = line.split(",");
			ProjectInfo projectInfo = new ProjectInfo();
			projectInfo.setProject_id(tmp[0]);
			projectInfo.setProject_name(tmp[1]);
			projectInfo.setProject_url(tmp[2]);
			if(tmp.length > 3 && !tmp[3].contains("Java"))
				continue;
			projectInfo.setLast_commit_checked("");
			projectInfoOperation.insertProjectInfo(projectInfo);
		}
		reader.close();
		databaseConnection.releaseSession();
	}
	public void insertProjectInfoByTxt(String[] args) throws Exception{
		String path = args[0];
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = "";
		Connection databaseConnection = new Connection();
		ProjectInfoOperation projectInfoOperation = new ProjectInfoOperation(databaseConnection);
		int i = 0;
		while((line = reader.readLine()) != null) {
			System.out.println(i++);
			ProjectInfo projectInfo = new ProjectInfo();
			String id = line.substring(0, line.indexOf(":"));
			id = String.valueOf(Integer.parseInt(id) -1);
			projectInfo.setProject_id(id);
			String[] tmp = line.substring(line.indexOf(":") + 1).split("#");
			projectInfo.setProject_url(tmp[0]);
			
			String nameString = tmp[0].substring(tmp[0].lastIndexOf("/")+1);
			projectInfo.setProject_name(nameString);
			projectInfo.setLast_commit_checked("");
			projectInfoOperation.insertProjectInfo(projectInfo);
		}
		reader.close();
		databaseConnection.releaseSession();
	}
}
