package cn.net.cobot.mining.dao;

import java.util.List;

import cn.net.cobot.mining.model.VarietyInfo;

public interface VarietyInfoDao {
	
	
	/**
	 * 插入一个新的变更信息
	 * @param changeInfo
	 */
	public void insertChangeInfo(VarietyInfo changeInfo);
	
	public List<VarietyInfo> selectAllVarietyInfo();
}
