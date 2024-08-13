package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConn {
	
	private static DbConn dbConn;
	
	private DbConn() {
		
	}//DbConn
	
	public static DbConn getInstance() {
		if(dbConn == null) {
			dbConn = new DbConn();
		}//end if
		return dbConn;
	}//getInstance

	/**
	 * DB연결을 얻는 일
	 * @param ip - DB서버주소
	 * @param id - DBO 아이디
	 * @param pass - 비밀번호
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection(String ip, String id, String pass) throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://" + ip + ":3306/yeondb";
		con = DriverManager.getConnection(url, id, pass);			
		
		return con;
	}
	
	/**
	 * 연결 끊기
	 * @param rs
	 * @param stmt
	 * @param con
	 * @throws SQLException
	 */
	public void closeDB(ResultSet rs, Statement stmt, Connection con) throws SQLException {
		//Statement 클래스는 모든 statement의 부모 클래스이므로
		//어떤 statement 클래스도 받아서 처리할 수 있음
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
		
	}
	
}
