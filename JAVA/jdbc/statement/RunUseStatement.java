package kr.co.sist.statement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class RunUseStatement {

	public void useCreateStudentTable() {
		UseStatementDAO usDAO = new UseStatementDAO();
		try {
			usDAO.createStudentTable(); //테이블 생성
			usDAO.createStudentTableIndex(); //인덱스 생성
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//useCreateStudentTable
	
	public void useInsertStudent() {
		UseStatementDAO usDAO = new UseStatementDAO();
		StudentVO sVO = new StudentVO(3, "박상준", 25, "park@test.com", null);
		try {
			usDAO.insertStudent(sVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//useInsertStudent
	
	public void useUpdateStudent() {
		UseStatementDAO usDAO = new UseStatementDAO();
		StudentVO sVO = new StudentVO(2, "", 0, "kang1@daum.net", null);
		try {
			int cnt = usDAO.updateStudent(sVO);
			if(cnt == 0) {
				System.out.println("학생의 번호를 확인해주세요.");
			}else {
				System.out.println("학생의 정보가 " + cnt + "건 변경되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//useUpdateStudent
	
	public void useDeleteStudent() {
		UseStatementDAO usDAO = new UseStatementDAO();
		//StudentVO sVO = new StudentVO(3, "", 0, "", null);
		int num = 3;
		try {
			int cnt = usDAO.deleteStudent(num);
			if(cnt == 0) {
				System.out.println("학생의 번호를 확인해주세요.");
			}else {
				System.out.println("학생의 정보가 " + cnt + "건 삭제되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//useDeleteStudent
	
	public void useSelectOneStudent() {
		UseStatementDAO usDAO = new UseStatementDAO();
		try {
			int num = 1;
			StudentVO sVO = usDAO.selectOneStudent(num);
			if(sVO == null) {
				//학생번호가 잘못된 경우 null이 반환 됨
				System.out.println(num + "번 학생은 존재하지 않습니다.");
				return; //early return
			}//end if
			int birth = Calendar.getInstance().get(Calendar.YEAR) - sVO.getAge() + 1;
			System.out.println("[검색된 학생 정보]");
			System.out.println("번호  : " + sVO.getNum());
			System.out.println("이름  : " + sVO.getName());
			System.out.println("나이  : " + sVO.getAge() + "(" + birth + ")");
			System.out.println("연도  : " + birth);
			System.out.println("이메일 : " + sVO.getEmail());
			System.out.println("입력일 : " + sVO.getInput_date());
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//useSelectOneStudent
	
	public void useSelectAllStudent() {
		UseStatementDAO usDAO = new UseStatementDAO();
		try {
			List<StudentVO> list = usDAO.selectStudent();
			if(list.isEmpty()) {
				System.out.println("학생 정보가 존재하지 않습니다.");
				return; //early return
			}else {
				for(StudentVO sVO : list) {
					System.out.println(sVO.getNum() + " / " + sVO.getName() + " / " + 
				sVO.getAge() + " / " + sVO.getEmail() + "\t/ " + sVO.getInput_date());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//useSelectAllStudent
	
	public static void main(String[] args) {
		RunUseStatement rus = new RunUseStatement();
		//rus.useCreateStudentTable();
		//rus.useInsertStudent();
		//rus.useUpdateStudent();
		//rus.useDeleteStudent();
		//rus.useSelectOneStudent();
		rus.useSelectAllStudent();
	}//main

}//class
