package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sist.dao.mapper.EmpMapper;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.vo.EmpVO;

@Service
public class EmpService {
	
	@Autowired
	private EmpMapper em;
	
	@Transactional
	public int addEmp(EmpVO eVO) {
		int cnt = 0;
		cnt = em.insertEmp(eVO);
		
		return cnt;
	}
	
	@Transactional
	public int removeEmp(int empno) {
		int cnt = 0;
		cnt = em.deleteEmp(empno);
		
		return cnt;
	}
	
	@Transactional
	public int editEmp(EmpVO eVO) {
		int cnt = 0;
		cnt = em.updateEmp(eVO);
		
		return cnt;
	}

	public EmpDomain detailEmp(int empno) {
		EmpDomain ed = null;
		ed = em.selectEmp(empno);
		
		return ed;
	}
	

}
