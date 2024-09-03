package day1109;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import kr.co.sist.dao.EmpDAO;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.vo.EmpVO;

public class UseEmpDAO {
	
	public void searchEmp() {
		String data = JOptionPane
				.showInputDialog("사원번호와 부서번호를 입력해주세요.\n예) 사원번호, 부서번호","7521,30");
		String[] tempData = data.split(",");
		if(tempData.length != 2) {
			JOptionPane.showMessageDialog(null, "입력 형식이 올바르지 않습니다.");
			return;
		}//end if
		
		//매개변수로 사용하는 VO
		EmpVO eVO = new EmpVO(Integer.parseInt(tempData[0]),Integer.parseInt(tempData[1]));
		
		EmpDAO eDAO = new EmpDAO();
		
		//결과값을 반환받는 VO(Domain)
		EmpDomain ed = eDAO.selectOneEmp(eVO);
		
		if(ed == null) {
			JOptionPane.showMessageDialog(null, eVO.getEmpno() + "번 사원은 존재하지 않습니다.");
			return;
		}//end if
		
		StringBuilder viewData = new StringBuilder();
		viewData.append("사원 번호 : ").append(ed.getEmpno()).append("\t");
		viewData.append("부서 번호 : ").append(ed.getDeptno()).append("\n");
		viewData.append("사원명 : ").append(ed.getEname()).append("\t");
		viewData.append("직무 : ").append(ed.getJob()).append("\n");
		viewData.append("연봉 : ").append(ed.getSal()).append("\n");
		viewData.append("입사일 : ").append(ed.getHiredate()).append("\n");
		
		JOptionPane.showMessageDialog(null, new JTextArea(viewData.toString(), 5, 80));
		
	}//searchEmp
	
	public void searchDeptEmp() {
		int deptno = 20;
		
		EmpDAO eDAO = new EmpDAO();
		List<EmpDomain> list = eDAO.selectDeptEmp(deptno);
		
		System.out.println(deptno + "번 부서정보 조회 결과");
		
		if(list.isEmpty()) {
			System.out.println("조회된 데이터가 없습니다.");
			return;
		}//end if
		
		for(EmpDomain ed : list) {
			System.out.println(ed.getEmpno() + "\t" + ed.getEname() + "\t" + ed.getDeptno() +
							   ed.getJob() + "\t" + ed.getSal() + "\t" + ed.getHiredate());
		}
	}//searchDeptEmp
	
	public static void main(String[] args) {
		UseEmpDAO ueDAO = new UseEmpDAO();
		ueDAO.searchDeptEmp();
		
	}

}
