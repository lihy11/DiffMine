package cn.net.cobot.mining.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.net.cobot.mining.database.Connection;
import cn.net.cobot.mining.database.ProjectInfoOperation;
import cn.net.cobot.mining.model.ProjectInfo;

public class InsertVarietyInfo extends Thread{

	List<ProjectInfo> projects = new ArrayList<ProjectInfo>();
	String repostoryPath = "";
	String workspace = "";
	ArrayList<String> libJars = new ArrayList<String>();
	Connection databaseConnection = null;
	
	@Override
	public void run() {
		
		int count = 0;
		for (ProjectInfo projectInfo : this.projects) {
			count ++;
			String srcPath = "";
			int dir = Integer.parseInt(projectInfo.getProject_id());
			dir = (dir - (dir%10000)) / 10000;
			srcPath =  this.repostoryPath + File.separator + String.valueOf(dir) + 
					File.separator + projectInfo.getProject_id()
					+ "-" + projectInfo.getProject_name();
		
			File srcFile = new File(srcPath);
			if(!srcFile.exists())
				continue;
			String projPath = this.workspace + File.separator + projectInfo.getProject_name();
			
			FindMethodVariety findMethodVariety = new FindMethodVariety();
			findMethodVariety.libList = this.libJars;
			ProjectInfoOperation projectInfoOperation = new ProjectInfoOperation(databaseConnection);
			//  copy项目文件夹到工作目录下
			try {
				Runtime.getRuntime().exec("cp -r " + srcPath + " " + projPath).waitFor();
				String commitID = findMethodVariety.findMethodVarietyOfProject(projPath, projectInfo, databaseConnection);
				if(commitID != null) {
					projectInfo.setLast_commit_checked(commitID);
					projectInfoOperation.updateProjectInfo(projectInfo);
					System.out.println("thread : " + String.valueOf(this.getId()) + "  :  " + 
							String.valueOf(count) + " / " + String.valueOf(projects.size()));
				}
				Runtime.getRuntime().exec("rm -rf " + projPath).waitFor();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
