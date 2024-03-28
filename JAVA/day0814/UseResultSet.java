package day0814;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import kr.co.sist.statement.DbConnection;

public class UseResultSet {

	public UseResultSet() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		DbConnection db = new DbConnection();
		
		try {
			//1.드라이버 로딩
			//2.커넥션 객체 얻기
			con = db.getConn();
			
			//3.쿼리 생성 객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리 실행 후 결과 얻기
			String select = "select empno, ename, hiredate, 2023.08 temp, to_char(hiredate,'mm-dd-yyyy') hire from emp";
			rs = stmt.executeQuery(select);
			
			//조회 결과가 있다면 반복하여 모두 가져온다.
			int empno = 0;
			String ename = "";
			Date date = null;
			Double temp = 0.0;
			String hire = "";
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); 
			while(rs.next()) {
				//컬럼 인덱스를 매개변수로 사용 -> 인덱스는 어떤 컬럼의 값을 얻는지 알 수 없다.
				//empno = rs.getInt(1); //오라클 인덱스는 1부터 시작
				empno = rs.getInt("empno"); //컬럼명은 어떤 컬럼의 값을 얻는지 알 수 있다.
				ename = rs.getString("ename");
				date = rs.getDate("hiredate"); //내가 원하는 날짜 형식으로 출력
				temp = rs.getDouble("temp");
				hire = rs.getString("hire");
				
				System.out.println(empno + " / " + ename + " / " + sdf.format(date) + " / " + temp + " / " + hire);
			}
			
		}finally {
			//5.연결 해제
			db.closeDB(rs, stmt, con);
		}//end finally
	}//UseResultSet
	
	public static void main(String[] args) {
		try {
			new UseResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
