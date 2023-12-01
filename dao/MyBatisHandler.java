package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisHandler {
	private static MyBatisHandler mbH;
	private SqlSessionFactory ssf;
	
	private MyBatisHandler() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//MyBatisHandler
	
	public static MyBatisHandler getInstance() {
		if(mbH==null) {
			mbH = new MyBatisHandler(); 
		}//end if
		return mbH;
	}//getInstance
	
	private SqlSessionFactory myBatisBuilder(String configFile) {
		if(ssf == null) {
			try {
				Reader reader = Resources.getResourceAsReader(configFile);
				ssf = new SqlSessionFactoryBuilder().build(reader);
				
				if(reader!=null) reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end catch
		}//end if
		
		return ssf;
	}//myBatisBuilder
	
	public SqlSession getMyBatisHandler(String config, boolean autoCommit) {
		SqlSession ss = null;
		ss = myBatisBuilder(config).openSession(autoCommit);
		
		return ss;
	}//getMyBatisHandler
	
	public void closeHandler(SqlSession ss) {
		if(ss!=null) ss.close();
	}
}
