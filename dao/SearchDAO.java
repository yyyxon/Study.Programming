package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.domain.PrdDomain;

public class SearchDAO {
	
	private static SearchDAO sDAO;
	
	private SearchDAO() {
		
	}
	
	public static SearchDAO getInstance() {
		if(sDAO == null) {
			sDAO = new SearchDAO();
		}
		return sDAO;
	}
	
	public PrdDomain selectOnePrd(int prdCode) throws PersistenceException{
		PrdDomain pd = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		pd = ss.selectOne("kr.co.sist.main.detailPrd", prdCode);
		
		mbh.closeHandler(ss);
		
		return pd;
	}

}
