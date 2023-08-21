package kr.co.sist.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.sist.dao.DbConn;
import kr.co.sist.statement.StudentVO;

public class PreparedStatementDAO {
	private static PreparedStatementDAO pstmtDAO;
	
	private PreparedStatementDAO() {
	}
	
	public static PreparedStatementDAO getInstance() {
		if(pstmtDAO == null) {
			pstmtDAO = new PreparedStatementDAO();
		}//end if
		return pstmtDAO;
	}//getInstance
	
	public void insertStudent(StudentVO stuVO) throws SQLException{
		//1.드라이버 로딩
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConn db = DbConn.getInstance();
		
		try {
			//2.커넥션 객체 얻기
			con = db.getConnection("localhost", "scott", "tiger");
			
			//3.쿼리문 생성 객체 얻기
			//input_date는 default 설정을 해놨다면 작성하지 않아도 됨
			String insertStudent = "insert into student(num, name, age, email, input_date) values (?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(insertStudent);
			//4.바인드 변수 값 설정
			//바인드 변수는 1부터 시작
			pstmt.setInt(1, stuVO.getNum());
			pstmt.setString(2, stuVO.getName());
			pstmt.setInt(3, stuVO.getAge());
			pstmt.setString(4, stuVO.getEmail());
			
			//5.쿼리문 수행 후 결과 얻기
			//매개변수 넣지 않기~! 매개변수 넣으면 부모클래스 메소드 호출됨
			pstmt.executeUpdate();
		}finally {
			//6.연결 해제
			db.closeDB(null, pstmt, con);
		}		
	}//insertStudent
	
	/**
	 * 학생번호, 나이, 이메일을 입력받아 번호에 해당하는 레코드를 변경
	 * @param stuVO
	 * @return 변경된 레코드의 수
	 * @throws SQLException
	 */
	public int updateStudent(StudentVO stuVO) throws SQLException {
		int rowCnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConn db = null;
		
		try {
			//1.드라이버 로딩
			db = DbConn.getInstance();
			
			//2.커넥션 객체 얻기(로딩된 드라이버를 사용하여 DB연결 얻기)
			con = db.getConnection("localhost", "scott", "tiger");
			
			//3.쿼리문 생성 객체 얻기(Connection에 쿼리문을 넣어 쿼리문 생성 객체 얻기)
			StringBuilder updateStudent = new StringBuilder();
			updateStudent
			.append("	update student			")
			.append("	set age = ?, email = ?	")
			.append("	where num = ?			");
			
			pstmt = con.prepareStatement(updateStudent.toString());
			
			//4.바인드 변수에 값 설정
			pstmt.setInt(1, stuVO.getAge());
			pstmt.setString(2, stuVO.getEmail());
			pstmt.setInt(3, stuVO.getNum());
			
			//5.쿼리문 실행 후 결과 얻기
			rowCnt = pstmt.executeUpdate();	
		}finally {
			//6.연결 해제
			db.closeDB(null, pstmt, con);
		}		
		return rowCnt;
	}//updateStudent
	
	/**
	 * 학생 번호를 입력받아 학생 레코드를 삭제
	 * @param stuNum
	 * @throws SQLException
	 */
	public int deleteStudent(int stuNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConn dc = null;
		int rowCnt = 0;
		try {
			//1.드라이버 로딩
			dc = DbConn.getInstance();
			//2.커넥션 객체 얻기
			con = dc.getConnection("127.0.0.1", "scott", "tiger");
			//3.쿼리 생성 객체 얻기
			String deleteStudent = "delete from student where num = ?";
			pstmt = con.prepareStatement(deleteStudent);
			//4.바인드 변수 설정
			pstmt.setInt(1, stuNum);
			//5.쿼리문 실행 후 결과 얻기	
			rowCnt = pstmt.executeUpdate();
		}finally {
			//6.연결 해제
			dc.closeDB(null, pstmt, con);
		}
		return rowCnt;
	}//deleteStudent
	
	public StudentVO selectOneStudent(int stuNum) throws SQLException{
		StudentVO stuVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1.드라이버 로딩
		DbConn db = DbConn.getInstance();
		
		try {
			//2.커넥션 객체 얻기
			con = db.getConnection("localhost", "scott", "tiger");
			//3.쿼리문 생성 객체 얻기
			StringBuilder selectStudent = new StringBuilder();
			selectStudent
			.append("	select name, age, email, input_date		")
			.append("	from student 							")
			.append("	where num = ?							");
			pstmt = con.prepareStatement(selectStudent.toString());
			//4.바인드 변수 설정
			pstmt.setInt(1, stuNum);
			//5.쿼리문 실행 후 결과 얻기
			rs = pstmt.executeQuery();
			if(rs.next()) {//검색된 레코드가 존재한다면 검색된 값으로 VO 생성
				//setter 메소드 사용 : 어떤 값이 어떤 변수에 들어가는지 명확하게 알 수 있다.
				//생성자 사용 : 명확하게 알 수 없지만 코드가 짧다.
				stuVO = new StudentVO();
				stuVO.setNum(stuNum);
				stuVO.setName(rs.getString("name"));
				stuVO.setAge(rs.getInt("age"));
				stuVO.setEmail(rs.getString("email"));
				stuVO.setInput_date(rs.getDate("input_date"));
			}
		}finally {
			db.closeDB(rs, pstmt, con);
		}
		return stuVO;
	}
	
	public List<StudentVO> selectAllStudent() throws SQLException {
		List<StudentVO> list = new ArrayList<StudentVO>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		//1.드라이버 로딩
		DbConn db = DbConn.getInstance();
		try {
			//2.커넥션 객체 얻기
			con = db.getConnection("127.0.0.1", "scott", "tiger");
			//3.쿼리 생성 객체 얻기
			String selectAllStudent = 
					"select num,name,age,email,input_date from student";
			pstmt = con.prepareStatement(selectAllStudent);
			//4.바인드 변수 값 설정하기
			//5.쿼리 실행 후 결과 얻기
			rs = pstmt.executeQuery();
			StudentVO stuVO = null;
			while(rs.next()) { //다음 레코드가 존재하면 실행
				stuVO = new StudentVO(rs.getInt("num"),rs.getString("name"),
						rs.getInt("age"),rs.getString("email"),rs.getDate("input_date"));
				list.add(stuVO);
			}
		}finally {
			//6.연결해제
			db.closeDB(rs, pstmt, con);
		}
		return list;
	}
	
//	public static void main(String[] args) {
//		StudentVO stu = new StudentVO(5, null, 26, "kim26@test.com", null);
//		try {
//			//getInstance().insertStudent(stu);
//			//int cnt = getInstance().updateStudent(stu);
//			int cnt = getInstance().deleteStudent(6);
//			if(cnt == 0) {
//				System.out.println("학생 번호를 확인해주세요.");
//			}else {
//				System.out.println("삭제 성공");								
//			}
//		} catch (SQLException e) {
//			System.out.println("삭제 실패");
//			e.printStackTrace();
//		}
		
//		try {
//			System.out.println(getInstance().selectAllStudent());
//		} catch (SQLException e) {
//		}
//	}

}//class
