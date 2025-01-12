package day0816.work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.sist.dao.DbConn;

public class Work0816DAO {
	private static Work0816DAO workDAO;
	
	private Work0816DAO() {
		
	}
	
	public static Work0816DAO getInstance() {
		if(workDAO == null) {
			workDAO = new Work0816DAO();
		}//end if
		return workDAO;
	}//getInstance
	
	public void insertUser(Work0816VO wVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("localhost", "yeon", "0908");
			String insertUser = "insert into work_user(num,name,img,age) values(?,?,?,?)";
			pstmt = con.prepareStatement(insertUser);
			StringBuilder imgPath = new StringBuilder();
			imgPath.append("E:/dev/workspace/jdbc_prj/src/kr/co/sist/work/img/img")
			.append(wVO.getImg())
			.append(".png");
			pstmt.setInt(1, wVO.getNum());
			pstmt.setString(2, wVO.getName());
			pstmt.setString(3, imgPath.toString());
			pstmt.setInt(4, wVO.getAge());
			
			pstmt.executeUpdate();
		}finally {
			db.closeDB(null, pstmt, con);
		}
		
	}
	
	public Work0816VO selectUser(int num) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		DbConn db = DbConn.getInstance();
		Work0816VO wVO = null;
		ResultSet rs = null;
		
		try {
			con = db.getConnection("localhost", "yeon", "0908");
			String selectUser = "select num, name, img, age from work_user where num = ?";
			pstmt = con.prepareStatement(selectUser);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				wVO = new Work0816VO(rs.getInt("num"), rs.getString("name"), 
						rs.getString("img"), rs.getInt("age"));
			}
		}finally {
			db.closeDB(rs, pstmt, con);
		}
		
		return wVO;
	}

	
}
