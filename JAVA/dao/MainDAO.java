package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.domain.PrdDomain;

public class MainDAO {
	private static MainDAO mDAO;
	
	private MainDAO() {
	}//MainDAO
	
	public static MainDAO getInstance() {
		if(mDAO == null) {
			mDAO = new MainDAO();
		}//end if
		return mDAO;
	}//getInstance
	
	
	public List<PrdDomain> selectAllPrd() throws PersistenceException {
		List<PrdDomain> list = null;
		
		//1.MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2.사용하고 결과 얻기
		list = ss.selectList("mainPrd");
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		return list;
		
	}
	
	public static void main(String[] args) {
		MainDAO.getInstance().selectAllPrd();
	}

}
