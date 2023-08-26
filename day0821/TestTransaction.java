package day0821;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.dao.DbConn;

/**
 * Transaction 처리
 * @author user
 */
public class TestTransaction {

	private Connection con;
	
	public int insertTest() throws SQLException {
		int cnt = 0;
		DbConn db = DbConn.getInstance();
		PreparedStatement pstmt = null;
		con = db.getConnection("localhost", "scott", "tiger");
		con.setAutoCommit(false); //auto commit 해제
		
		String name = "홍찬영2";
		String addr = "서울시강남구역삼동한독";
		
		/////transaction1/////
		String sql = "insert into transaction1(name,addr) values(?,?)";
		//쿼리 생성 객체 얻기
		pstmt = con.prepareStatement(sql);
		//바인드 변수 설정
		pstmt.setString(1, name);
		pstmt.setString(2, addr);
		//쿼리문 실행 후 결과 얻기
		int cnt1 = pstmt.executeUpdate();
		//PreparedStatement 연결 해제
		pstmt.close();
		
		
		/////transaction2/////
		sql = "insert into transaction2(name,addr) values(?,?)";
		//쿼리 생성 객체 얻기
		pstmt = con.prepareStatement(sql);
		//바인드 변수 설정
		pstmt.setString(1, name);
		pstmt.setString(2, addr);
		//쿼리문 실행 후 결과 얻기
		int cnt2 = pstmt.executeUpdate();
		//PreparedStatement 연결 해제
		pstmt.close();
		
		
		//Connection 되는 순간 commit됨! 실패해도 커밋되므로 finally 작성X
//		if(cnt1 == 1 && cnt2 == 1) {
//			con.commit();
//		}
		
		cnt = cnt1+cnt2;
		
		return cnt;
	}//insertTest
	
	public void useInsertTest() {
		try {
			int cnt = insertTest();
			if(cnt == 2) {
				System.out.println("추가 성공");
				con.commit();
			}//end if
		} catch (SQLException e) {
			//insert는 성공하면 행 수 반환, 실패하면 예외처리 됨
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}//useInsertTest
	
	
	public static void main(String[] args) {
		TestTransaction tt = new TestTransaction();
		tt.useInsertTest();
		
	}//main

}//class
