package cn.net.cobot.mining.database;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Connection {
	SqlSession session;
	
	public SqlSession getSession() {
		if (session != null)
			return session;
		SqlSession session = null; 
	    try { 
	        Reader reader = Resources.getResourceAsReader("configuration.xml"); 
	        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader) ; 
	        session = factory.openSession() ;
	    } catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	    this.session = session;
		return session;
	}
	
	public void releaseSession() {
		if(session != null)
			session.close();
	}
}
