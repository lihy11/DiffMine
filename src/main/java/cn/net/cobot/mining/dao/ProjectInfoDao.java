package cn.net.cobot.mining.dao;

import java.util.List;

import cn.net.cobot.mining.model.ProjectInfo;

public interface ProjectInfoDao {

	/**
	 * 插入新的project info
	 * @param projectInfo
	 */
	public void insertProjectInfo(ProjectInfo projectInfo);
	
	/**
	 * 获取全部的project info
	 * @return
	 */
	public List<ProjectInfo> selectAllProjectInfo();
	
	public ProjectInfo selectProjectInfoByUrl();

	public void updateProjectInfo(ProjectInfo projectInfo);
}
