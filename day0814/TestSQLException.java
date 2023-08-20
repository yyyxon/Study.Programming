package day0814;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSQLException {
	
	public TestSQLException() throws SQLException {
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2.커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		Connection con = DriverManager.getConnection(url, id, pass);
		Statement stmt = null;
		
		try {
			//3.쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			//4.쿼리문 수행 후 결과 얻기
			//자바에서 쿼리만들 때 세미콜론 넣지않기~
			int empno = 4323;
			int sal = 555555;
			String ename = "장용석";
			String sql = 
					"insert into cp_emp3(empno, ename, sal, hiredate) values(" 
					 + empno + ", '" + ename + "', " + sal + ", sysdate)";
			int rowCnt = stmt.executeUpdate(sql); //쿼리문을 실행하고, 실행된 튜플 수 얻기
			System.out.println(rowCnt + "건 추가되었습니다.");
		}finally {
			//5.연결 끊기
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		}
	}

	public static void main(String[] args) {
		try {
			new TestSQLException();
		} catch (SQLException e) {
			e.printStackTrace();
			switch(e.getErrorCode()) {
				case 1 : System.out.println("사원번호가 중복되었습니다."); break;
				case 12899 : System.out.println("사원명에 대한 값이 너무 큽니다."); break;
				case 1438 : System.out.println("연봉에 입력된 값이 너무 큽니다."); break;
			}
		}	
	}//main
}//class
