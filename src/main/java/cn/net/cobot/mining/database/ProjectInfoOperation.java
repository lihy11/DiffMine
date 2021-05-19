package cn.net.cobot.mining.database;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.net.cobot.mining.dao.ProjectInfoDao;
import cn.net.cobot.mining.model.ProjectInfo;

public class ProjectInfoOperation {
	SqlSession session ;
	ProjectInfoDao projectInfoDao;
	
	public ProjectInfoOperation(Connection connection) {
		this.session = connection.getSession();
		this.projectInfoDao = session.getMapper(ProjectInfoDao.class);
	}
	
	public void insertProjectInfo(ProjectInfo info) {
		
		try {
			projectInfoDao.insertProjectInfo(info);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateProjectInfo(ProjectInfo projectInfo) {
		try {
			projectInfoDao.updateProjectInfo(projectInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ProjectInfo> selectAllProjectInfo(){
		List<ProjectInfo> projectInfos = null;
		
		try {
			projectInfos = projectInfoDao.selectAllProjectInfo();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return projectInfos;
	}
}
