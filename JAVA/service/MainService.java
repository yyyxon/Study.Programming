package kr.co.sist.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.dao.MainDAO;
import kr.co.sist.domain.PrdDomain;

public class MainService {
	private static MainService ms;
	private MainService() {
		
	}//MainService
	
	public static MainService getInstance() {
		if(ms==null) {
			ms = new MainService();
		}//end if
		return ms;
	}//getInstance
	
	public List<PrdDomain> searchPrd() {
		List<PrdDomain> list = null;
		
		MainDAO mDAO = MainDAO.getInstance();
		
		try {
			list = mDAO.selectAllPrd();
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}

}
