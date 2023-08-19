package kr.co.sist.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DAO : Data Access Object
 * DBMS 작업 중 쿼리문에 관한 업무를 정의하는 클래스
 * @author user
 */
public class UseStatementDAO {

	public void createStudentTable() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		DbConnection dc = new DbConnection();
		
		//1.드라이버 로딩
		try {
			//2.커넥션 객체 얻기
			con = dc.getConn();
			
			//3.쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리문 수행 후 결과 얻기	
			StringBuilder createStudent = new StringBuilder();
			createStudent
			.append("	create table student(							")
			.append("	num number(5),									")
			.append("	name varchar2(30) not null,						")
			.append("	age number(3) check (age BETWEEN 20 and 39),	")
			.append("	email varchar2(50),								")
			.append("	input_date date,								")
			.append("	constraint pk_student primary key(num)			")
			.append("	)												");
			
			//테이블이 생성되더라도 false가 나온다.
			/*boolean flag = */stmt.execute(createStudent.toString());
			System.out.println("테이블 생성 완료");
		}finally {
			//5.연결 끊기
			dc.closeDB(null, stmt, con);
		}
		
	}//createStudentTable
	
	public void createStudentTableIndex() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		DbConnection dc = new DbConnection();
		
		//1.드라이버 로딩
		try {
			//2.커넥션 객체 얻기
			con = dc.getConn();
			
			//3.쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리문 수행 후 결과 얻기	
			String createStudent = "create index ind_date_student ON student(input_date)";
			
			//테이블이 생성되더라도 false가 나온다.
			/*boolean flag = */stmt.execute(createStudent);
			System.out.println("인덱스 생성 완료");
		}finally {
			//5.연결 끊기
			dc.closeDB(null, stmt, con);
		}
		
	}//createStudentTable
	
	public void insertStudent(StudentVO sVO) throws SQLException{
		Connection con = null;
		Statement stmt = null;
		DbConnection dc = new DbConnection();
		//1.드라이버 연결
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//2.커넥션 객체 얻기
			con = dc.getConn();
			
			//3.쿼리 생성 객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리 수행 후 결과 얻기
			StringBuilder insertStudent = new StringBuilder();
			insertStudent
			.append("insert into student(num, name, age, email, input_date)")
			.append("values (").append(sVO.getNum()).append(", '")
			.append(sVO.getName()).append("', ").append(sVO.getAge())
			.append(", '").append(sVO.getEmail()).append("', sysdate)");
			
			int rowCnt = stmt.executeUpdate(insertStudent.toString());
			System.out.println(rowCnt + "건 추가되었습니다.");
			
		}finally {
			//5.연결 해제
			dc.closeDB(null, stmt, con);
		}
		
	}
	
	//2번 학생의 이메일을 kang@test.com에서 kang1@daum.net으로 변경
	public int updateStudent(StudentVO sVO) throws SQLException{
		Connection con = null;
		Statement stmt = null;
		DbConnection dc = new DbConnection();
		int rowCnt;
		//1.드라이버 연결
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//2.커넥션 객체 얻기
			con = dc.getConn();
			
			//3.쿼리 생성 객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리 수행 후 결과 얻기
			StringBuilder updateStudent = new StringBuilder();
			updateStudent
			.append("	update student	")
			.append("	set email ='").append(sVO.getEmail()).append("'")
			.append("	where num =").append(sVO.getNum());
			
			rowCnt = stmt.executeUpdate(updateStudent.toString());
			
		}finally {
			//5.연결 해제
			dc.closeDB(null, stmt, con);
		}
		
		return rowCnt;
	}
	
	public int deleteStudent(StudentVO sVO) throws SQLException{
		Connection con = null;
		Statement stmt = null;
		DbConnection dc = new DbConnection();
		int rowCnt;
		//1.드라이버 연결
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//2.커넥션 객체 얻기
			con = dc.getConn();
			
			//3.쿼리 생성 객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리 수행 후 결과 얻기
			StringBuilder deleteStudent = new StringBuilder();
			deleteStudent
			.append("	delete	")
			.append("	from student")
			.append("	where num =").append(sVO.getNum());
			
			rowCnt = stmt.executeUpdate(deleteStudent.toString());
		}finally {
			//5.연결 해제
			dc.closeDB(null, stmt, con);
		}
		
		return rowCnt;
	}
	
}//class
