package day1106;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.dao.DeptDAO;
import kr.co.sist.vo.DeptVO;

public class TestMyBatis {
	
	public void addDept() {
		DeptVO dVO = new DeptVO();
		dVO.setDeptno(92);
		dVO.setDname("밥");
		dVO.setLoc("서울");
		
		DeptDAO dDAO = new DeptDAO();
		
		try {
			dDAO.insertDept(dVO);
			System.out.println("성공");
		}catch(PersistenceException pe) {
			pe.printStackTrace();
			System.out.println("실패");
		}
	}

	public static void main(String[] args) {
		TestMyBatis tmb = new TestMyBatis();
		tmb.addDept();
	}//main

}//class
