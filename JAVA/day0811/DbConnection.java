package kr.co.sist.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB작업에 공통 코드를 정의
 * - Connection 얻기
 * - 연결 끊기
 * @author user
 */
public class DbConnection {
	
	public Connection getConn() throws SQLException{
		Connection con = null;
		
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		//2.커넥션 얻기
		con = DriverManager.getConnection(url,id,pass);
		
		//3.연결 끊기
		
		return con;
	}
	
	public void closeDB(ResultSet rs, Statement stmt, Connection con) throws SQLException{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
	}
	
}
