package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.dao.DbConn;

public class UseClob {
	
	public UseClob() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1.드라이버 로딩
		DbConn db = DbConn.getInstance();
		
		try {
			//2.커넥션 객체 얻기
			con = db.getConnection("localhost", "scott", "tiger");
			//3.쿼리 생성 객체 얻기
			StringBuilder selectClob = new StringBuilder();
			selectClob
			.append("	select subject, content, writer	")
			.append("	from test_clob");
			pstmt = con.prepareStatement(selectClob.toString());
			//4.바인드 변수 값 설정
			//5.쿼리문 실행 후 결과 얻기
			rs = pstmt.executeQuery();
			
			String content = "";
			String subject = "";
			BufferedReader br = null;
			StringBuilder contentData = new StringBuilder();
			
			while(rs.next()) {
				subject = rs.getString("subject");
				System.out.println("제목 : " + subject);
				//clob : getString으로 값을 얻을 수 있으나 Linux에서는 동작하지 않는다.
				//content = rs.getString("content");
				try {
					br = new BufferedReader(rs.getClob("content").getCharacterStream());
					while((content = br.readLine()) != null) {
						contentData.append(content).append("\n");
					}
					if(br!=null) br.close();
				}catch(IOException ie) {
					ie.printStackTrace();
				}
				System.out.println("내용 : " + contentData);
				contentData.delete(0, contentData.length());
			}
		}finally {
			//6.연결 해제
			db.closeDB(rs, pstmt, con);
		}
	}//UseClob

	public static void main(String[] args) {
		try {
			new UseClob();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main

}//class
