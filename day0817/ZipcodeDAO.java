package day0817;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConn;

public class ZipcodeDAO {
	
	private static ZipcodeDAO zipDAO;
	
	private ZipcodeDAO() {
		
	}
	
	public static ZipcodeDAO getInstance() {
		if(zipDAO == null) {
			zipDAO = new ZipcodeDAO();
		}
		return zipDAO;
	}//getInstance
	
	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException{
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		
		//1.드라이버 로딩
		DbConn db = DbConn.getInstance();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			//2.커넥션 객체 얻기
			con = db.getConnection("127.0.0.1", "scott", "tiger");
			
			//3.쿼리 생성 객체 얻기
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode
			.append("	select zipcode, sido, gugun, dong, nvl(bunji,' ') bunji	")
			.append("	from zipcode											")
			.append("	where dong like ? || '%'								")
			.append("	order by sido, gugun									");
			pstmt = con.prepareStatement(selectZipcode.toString());
			
			//4.바인드 변수 값 설정
			pstmt.setString(1, dong);
			
			//5.실행 후 결과 얻기
			rs = pstmt.executeQuery();
			ZipcodeVO zipcodeVO = null;
			while(rs.next()) {
				zipcodeVO = new ZipcodeVO(rs.getString("zipcode"), 
						rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("bunji"));
				list.add(zipcodeVO);
			}
			
		}finally {
			//6.연결 해제
			db.closeDB(rs, pstmt, con);
		}
		
		return list;
	}//selectZipcode

}//class
