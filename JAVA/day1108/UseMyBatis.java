package day1108;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.vo.DeptVO;

public class UseMyBatis {
	
	public void useInsertDeptno() {
		UseMyBatisDAO umDAO = new UseMyBatisDAO();
		try {
			umDAO.insertDeptno(53);
			System.out.println("추가 성공");
		}catch(PersistenceException pe) {
			System.out.println("추가 실패");
			pe.printStackTrace();
		}//end catch
		
	}//useInsertDeptno

	public void useInsertSeqDeptno() {
		UseMyBatisDAO umDAO = new UseMyBatisDAO();
		try {
			umDAO.insertSeqDeptno();
			System.out.println("추가 성공");
		}catch(PersistenceException pe) {
			System.out.println("추가 실패");
			pe.printStackTrace();
		}//end catch
		
	}//useInsertSeqDeptno

	public void useUpdateDept() {
		UseMyBatisDAO umDAO = new UseMyBatisDAO();
		try {
			DeptVO dVO = new DeptVO();
			dVO.setDeptno(10);
			dVO.setDname("SI");
			dVO.setLoc("서울");
			
			int cnt = umDAO.updateDept(dVO);
			
			if(cnt == 1) {
				System.out.println("성공");
			}
			
		}catch(PersistenceException pe) {
			System.out.println("추가 실패");
			pe.printStackTrace();
		}//end catch
		
	}//useInsertDeptno
	
	public void useDeleteDept() {
		UseMyBatisDAO umDAO = new UseMyBatisDAO();
		try {
			int cnt = umDAO.deleteDept(92);
			
			if(cnt == 1) {
				System.out.println("삭제 성공");
			}
			
		}catch(PersistenceException pe) {
			System.out.println("삭제 실패");
			pe.printStackTrace();
		}//end catch
		
	}//useInsertDeptno
	

	public static void main(String[] args) {
		UseMyBatis umb = new UseMyBatis();
		umb.useDeleteDept();
	}//main
}//class
