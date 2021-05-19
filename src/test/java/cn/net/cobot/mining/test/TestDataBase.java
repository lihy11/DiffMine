package cn.net.cobot.mining.test;

import cn.net.cobot.mining.database.Connection;
import cn.net.cobot.mining.database.ProjectInfoOperation;
import cn.net.cobot.mining.model.ProjectInfo;

public class TestDataBase {
	public static void main(String[] args) {
		Connection connection = new Connection();
		ProjectInfoOperation operation = new ProjectInfoOperation(connection);
		ProjectInfo info = new ProjectInfo();
		info.setLast_commit_checked("test");
		info.setProject_id("test");
		info.setProject_name("test");
		info.setProject_url("test");
		info.setDate("test");
		operation.insertProjectInfo(info);
	}
}
