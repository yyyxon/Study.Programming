package kr.co.sist.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.dao.SearchDAO;
import kr.co.sist.domain.PrdDomain;

public class PrdService {
	
	private static PrdService ps;
	private PrdService() {
		
	}
	
	public static PrdService getInstance() {
		if(ps == null) {
			ps = new PrdService();
		}
		return ps;
	}//getInstance
	
	public PrdDomain searchPrdDetail(int prdCode) {
		PrdDomain pd = null;
		
		SearchDAO sDAO = SearchDAO.getInstance();
		try {
			pd = sDAO.selectOnePrd(prdCode);
			
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return pd;
	}//searchPrdDetail

}
