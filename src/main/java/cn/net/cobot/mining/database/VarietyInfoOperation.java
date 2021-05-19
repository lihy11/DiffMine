package cn.net.cobot.mining.database;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.net.cobot.mining.dao.VarietyInfoDao;
import cn.net.cobot.mining.model.VarietyInfo;

public class VarietyInfoOperation {
	SqlSession session;
	public VarietyInfoOperation(Connection connection) {
		this.session = connection.getSession();
	}
	
	
	public void insertVarietyInfo(VarietyInfo info) {
		
		try {
			VarietyInfoDao changeInfoDao = session.getMapper(VarietyInfoDao.class);
			changeInfoDao.insertChangeInfo(info);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<VarietyInfo> selectAllVarietyInfo() {
		List<VarietyInfo> result = null;
		try {
			VarietyInfoDao changeInfoDao = session.getMapper(VarietyInfoDao.class);
			result = changeInfoDao.selectAllVarietyInfo();;
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
