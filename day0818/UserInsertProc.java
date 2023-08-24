package day0818;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.dao.DbConn;

public class UserInsertProc {
	
	public UserInsertProc(CpDeptVO cdVO) throws SQLException {
		Connection con = null;
		CallableStatement cstmt = null;
		//1.드라이버 로딩
		DbConn db = DbConn.getInstance();		
		try {
			//2.커넥션 객체 얻기
			con = db.getConnection("localhost", "scott", "tiger");
			
			//3.쿼리 생성 객체 얻기
			cstmt = con.prepareCall("{ call insert_proc(?,?,?,?,?) }");	
			
			//4.바인드 변수에 값 설정
			//in parameter
			cstmt.setInt(1, cdVO.getDeptno());
			cstmt.setString(2, cdVO.getDname());
			cstmt.setString(3, cdVO.getLoc());
			
			//out parameter
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			
			//5.쿼리문 실행 후 결과 얻기
			cstmt.execute();
			
			//6.registerOutParameter에 할당된 값 가져오기
			int cnt = cstmt.getInt(4);
			String msg = cstmt.getString(5);
			
			System.out.println(cnt + "건 추가 / " + msg);
			
		}finally {
			//7.연결해제
			db.closeDB(null, cstmt, con);
		}
	}

	public static void main(String[] args) {
		try {
			CpDeptVO cdVO = new CpDeptVO(2, "SI", "서울");
			new UserInsertProc(cdVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
