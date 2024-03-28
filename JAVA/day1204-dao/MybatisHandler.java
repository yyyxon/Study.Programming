package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisHandler {

	private static MybatisHandler mbH;
	private static SqlSessionFactory ssf;

	private MybatisHandler() {
		org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
	}// MybatisHandler

	public static MybatisHandler getInstance() {
		if (mbH == null) {
			mbH = new MybatisHandler();
		} // end if
		return mbH;
	}// getInstance

	private SqlSessionFactory myBatisBuilder(String configFile) {
		if (ssf == null) {
			try {
				Reader reader = Resources.getResourceAsReader(configFile);
				ssf=new SqlSessionFactoryBuilder().build(reader);
				if(reader != null) { reader.close(); }//end if
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		} // end if
		return ssf;
	}// myBatisBuilder
	
	public SqlSession getMyBatisHandler(boolean autoCommit) {
		SqlSession ss=null;
		ss=myBatisBuilder("kr/co/sist/dao/mybatis-config.xml").openSession(autoCommit);
		
		return ss;
	}//getMyBatisHandler
	
	public void closeHandler(SqlSession ss) {
		if( ss != null) { ss.close(); }
	}//closeHandler
	
	public static void main(String[]  args) {
		MybatisHandler mbh=MybatisHandler.getInstance();
		System.out.println(mbh.getMyBatisHandler(false));
	}//main

}// class
