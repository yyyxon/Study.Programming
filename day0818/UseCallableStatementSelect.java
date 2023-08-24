package day0818;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.dao.DbConn;
import oracle.jdbc.internal.OracleTypes;

public class UseCallableStatementSelect {
	
	public UseCallableStatementSelect() throws SQLException {
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		//1.
		DbConn db = DbConn.getInstance();
		
		try {
			//2.커넥션 객체 얻기
			con = db.getConnection("localhost", "scott", "tiger");
			
			//3.쿼리 생성 객체 얻기
			cstmt = con.prepareCall(" { call select_all_emp(?) }");
			
			//4.바인드 변수에 값 넣기
			//out
			cstmt.registerOutParameter(1, Types.REF_CURSOR);
			//cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			//5.쿼리문 실행 후 결과 얻기
			cstmt.execute();
			rs = (ResultSet)cstmt.getObject(1); //executeQuery 아님! -> 인덱스를 넣을 수 없음
			
			while(rs.next()) {
				System.out.print(rs.getInt("empno") + " ");
				System.out.print(rs.getString("ename") + " ");
				System.out.print(rs.getInt("sal") + " ");
				System.out.print(rs.getString("hiredate") + "\n");
			}
			
		}finally {
			//6.
			db.closeDB(rs, cstmt, con);
		}
		
	}

	public static void main(String[] args) {
		try {
			new UseCallableStatementSelect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
