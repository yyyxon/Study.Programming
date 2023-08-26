package day0821;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.co.sist.dao.DbConn;

public class InjectionTestDAO {
	
	private static InjectionTestDAO itDAO;
	
	private InjectionTestDAO() {
		
	}
	
	public static InjectionTestDAO getInstance() {
		if(itDAO == null) {
			itDAO = new InjectionTestDAO();
		}
		return itDAO;
	}//getInstance
	
	public LoginResultVO useStatementLogin(LoginVO lVO) throws SQLException{
		LoginResultVO lrVO = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		//1.드라이버 로딩
		DbConn db = DbConn.getInstance();
		
		try {
			//2.커넥션 객체 얻기
			con = db.getConnection("localhost", "scott", "tiger");
			
			//3.쿼리 생성 객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리 실행 후 결과 얻기
			StringBuilder selectLogin = new StringBuilder();
			selectLogin
			.append("	select name, input_date ")
			.append("	from test_login ")
			.append("	where id = '").append(lVO.getId()).append("' and pass = '")
			.append(lVO.getPassword()).append("'");

			rs = stmt.executeQuery(selectLogin.toString());
			
			if(rs.next()) {
				lrVO = new LoginResultVO(rs.getString("name"),rs.getDate("input_date"));
			}//end if
			
		}finally {
			//5.연결 해제
			db.closeDB(rs, stmt, con);
		}//end finally
		
		return lrVO;
	}//useStatementLogin
	
	public LoginResultVO usePreparedStatementLogin(LoginVO lVO) throws SQLException{
		LoginResultVO lrVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1.드라이버 로딩
		DbConn db = DbConn.getInstance();
		
		try {
			//2.커넥션 객체 얻기
			con = db.getConnection("localhost", "scott", "tiger");
			
			//3.쿼리 생성 객체 얻기
			StringBuilder selectLogin = new StringBuilder();
			selectLogin
			.append("	select name, input_date 	")
			.append("	from test_login 			")
			.append("	where id = ? and pass = ?	");
			pstmt = con.prepareStatement(selectLogin.toString());
			
			//4.바인드 변수 설정
			pstmt.setString(1,lVO.getId());
			pstmt.setString(2,lVO.getPassword());
			
			//5.쿼리 실행 후 결과 얻기
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				lrVO = new LoginResultVO(rs.getString("name"),rs.getDate("input_date"));
			}//end if
			
		}finally {
			//6.연결 해제
			db.closeDB(rs, pstmt, con);
		}//end finally
		
		return lrVO;
	}//usePreparedStatementLogin
	
//	public static void main(String[] args) {
//		try {
//			System.out.println(InjectionTestDAO.getInstance().useStatementLogin(new LoginVO("hong","1234")));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

}
