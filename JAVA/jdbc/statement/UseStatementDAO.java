package kr.co.sist.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			Class.forName("com.mysql.cj.jdbc.Driver");
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
			Class.forName("com.mysql.cj.jdbc.Driver");
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
	
	public int deleteStudent(int num) throws SQLException{
		Connection con = null;
		Statement stmt = null;
		DbConnection dc = new DbConnection();
		int rowCnt;
		//1.드라이버 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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
			.append("	where num =").append(num);
			
			rowCnt = stmt.executeUpdate(deleteStudent.toString());
		}finally {
			//5.연결 해제
			dc.closeDB(null, stmt, con);
		}
		
		return rowCnt;
	}
	
	//특정 학생 한 명 조회
	public StudentVO selectOneStudent(int stuNum) throws SQLException{
		StudentVO stuVO = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//1.드라이버 로딩
		DbConnection dc = new DbConnection();
		
		try {
			//2.커넥션 얻기
			con = dc.getConn();
			
			//3.쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리문 수행 후 결과 얻기
			StringBuilder selectStudent = new StringBuilder();
			selectStudent
			.append("select name, age, email, input_date from student where num=")
			.append(stuNum);
			rs = stmt.executeQuery(selectStudent.toString());
			if(rs.next()) { //조회 결과는 0개 또는 1개가 발생
				//조회된 레코드가 존재하면 레코드의 컬럼값으로 VO를 생성한다.
				stuVO = new StudentVO(stuNum, rs.getString("name"), rs.getInt("age"), 
						rs.getString("email"), rs.getDate("input_date"));
			}
		}finally {
			//5.연결 끊기
			dc.closeDB(rs, stmt, con);
		}
		return stuVO;
	}
	
	/**
	 * 모든 학생 조회
	 * @return
	 * @throws SQLException
	 */
	public List<StudentVO> selectStudent() throws SQLException {
		List<StudentVO> list = new ArrayList<StudentVO>();
		//1.드라이버 로딩
		DbConnection dc = new DbConnection();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//2.커넥션 객체 얻기
			con = dc.getConn();
			
			//3.쿼리 생성 객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리 실행 후 결과 얻기
			String selectAllStudent = "select /*+ index (student pk_student)*/ "
					+ "num, name, age, email, input_date from student";
			//num,name,age,email,input_date -> 컬럼명 클릭후 ctrl+c -> ctrl+v -> ctrl+shift+y	
			rs = stmt.executeQuery(selectAllStudent);
			
			StudentVO sVO = null;
			while(rs.next()) {
				//조회 결과를 사용하여 VO를 생성
				sVO = new StudentVO(rs.getInt("num"), rs.getString("name"), rs.getInt("age"),
						rs.getString("email"), rs.getDate("input_date"));
				list.add(sVO);
				//같은 이름의 VO객체를 관리하기 위해 list에 추가
				//list를 사용하지 않으면 VO객체에는 가장 마지막 레코드의 값만 들어감
			}//end while
			
		}finally {
			//5.연결 해제
			dc.closeDB(rs, stmt, con);
		}
		
		return list;
	}
	
	public List<String> selectTableName() throws SQLException {
		List<String> list = new ArrayList<String>();
		//1.드라이버 로딩
		DbConnection dc = new DbConnection();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//2.커넥션 객체 얻기
			con = dc.getConn();
			
			//3.쿼리 생성 객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리 실행 후 결과 얻기
			String selectTableName = "select tname from tab";
			rs = stmt.executeQuery(selectTableName);
			while(rs.next()) {
				//조회 결과를 사용하여 VO를 생성
				list.add(rs.getString("tname"));
				//같은 이름의 VO객체를 관리하기 위해 list에 추가
				//list를 사용하지 않으면 VO객체에는 가장 마지막 레코드의 값만 들어감
			}//end while
			
		}finally {
			//5.연결 해제
			dc.closeDB(rs, stmt, con);
		}
		
		return list;
	}
	
}//class
