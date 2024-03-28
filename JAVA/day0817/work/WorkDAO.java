package day0817.work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConn;

public class WorkDAO {
	
	private static WorkDAO wDAO;
	
	private WorkDAO() {
	}
	
	public static WorkDAO getInstance() {
		if(wDAO == null) {
			wDAO = new WorkDAO();
		}
		return wDAO;
	}

	public List<String> selectTableName() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		//1.드라이버 로딩
		DbConn dc = DbConn.getInstance();
		
		try {
			//2.커넥션 객체 얻기
			con = dc.getConnection("localhost", "scott", "tiger");
			pstmt = con.prepareStatement("select tname from tab");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString("tname"));
			}
		}finally {
			dc.closeDB(rs, pstmt, con);
		}
		
		return list;
	}//selectTableName
	
	public List<WorkVO> searchTableInfo(String tableName) throws SQLException {
		WorkVO wVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		List<WorkVO> list = new ArrayList<WorkVO>();
		//1.드라이버 로딩
		DbConn dc = DbConn.getInstance();
		
		try {
			//2.커넥션 객체 얻기
			con = dc.getConnection("localhost", "scott", "tiger");
			
			//3.쿼리 생성 객체 얻기
			StringBuilder selectTableInfo = new StringBuilder();
			selectTableInfo
			.append("	select column_name, data_type, nvl(data_precision,data_length) data_precision, ")
			.append("nullable, data_default")
			.append("	from user_tab_cols")
			.append("	where table_name = ?");
			
			pstmt = con.prepareStatement(selectTableInfo.toString());
			
			//4.바인드 변수 값 설정
			pstmt.setString(1, tableName);
			
			//5.실행 후 결과 얻기
			//preparedStatement에서 제공하는 method
			rs = pstmt.executeQuery(); 
			
			//Statement에서 제공하는 method : 문법에는 문제가 없으나 실행 중에 문제가 발생하게된다.
			//rs = pstmt.executeQuery(selectTableInfo.toString()); 
			while(rs.next()) {
				wVO = new WorkVO(rs.getString("column_name"), rs.getString("data_type"),
						rs.getInt("data_precision"), rs.getString("nullable"),
						rs.getString("data_default"));
				list.add(wVO);
			}
		}finally {
			dc.closeDB(rs, pstmt, con);
		}
		
		return list;
	}//searchTableInfo
}
