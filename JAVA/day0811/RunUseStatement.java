package kr.co.sist.statement;

import java.sql.SQLException;

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
		StudentVO sVO = new StudentVO(3, "", 0, "", null);
		try {
			int cnt = usDAO.deleteStudent(sVO);
			if(cnt == 0) {
				System.out.println("학생의 번호를 확인해주세요.");
			}else {
				System.out.println("학생의 정보가 " + cnt + "건 삭제되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}
	
	public static void main(String[] args) {
		RunUseStatement rus = new RunUseStatement();
		//rus.useCreateStudentTable();
		//rus.useInsertStudent();
		rus.useUpdateStudent();
		//rus.useDeleteStudent();
	}//main

}//class
