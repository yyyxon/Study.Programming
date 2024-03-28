package day0817;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import kr.co.sist.dao.DbConn;

public class UseResultSetMetaData {
	
	public UseResultSetMetaData() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		DbConn db = null;
		
		try {
			//1.드라이버 로딩
			db = DbConn.getInstance();
			//2.커넥션 객체 얻기
			con = db.getConnection("127.0.0.1", "scott", "tiger");
			//3.쿼리 생성 객체 얻기
			pstmt = con.prepareStatement("select * from emp");
			//4.바인드 변수 값 설정
			//5.쿼리문 실행 후 결과 얻기
			rs = pstmt.executeQuery();
			//6.R.S.M.D 얻기
			rsmd = rs.getMetaData();
//			System.out.println("컬럼의 개수 : " + rsmd.getColumnCount());
//			System.out.println("처음 컬럼명 : " + rsmd.getColumnName(1)); //1부터 시작
//			System.out.println("처음 컬럼명 : " + rsmd.getColumnLabel(1)); //name과 같음
//			System.out.println("처음 데이터형 : " + rsmd.getColumnTypeName(1));
//			System.out.println("처음 데이터형 크기 : " + rsmd.getPrecision(1));
//			System.out.println("널 허용 : " + rsmd.isNullable(1)); //0은 not null, 1은 is null
			
			for(int i = 1; i < rsmd.getColumnCount()+1; i++) {
				System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnTypeName(i) + 
						"(" + rsmd.getPrecision(i) + ")" + (rsmd.isNullable(i)==0 ? "not null" : ""));
			}
		}finally{
			//7.연결 해제
			db.closeDB(rs, pstmt, con);
		}
	}//UseResultSetMetaData

	public static void main(String[] args) {
		try {
			new UseResultSetMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
