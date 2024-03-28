package day0821.work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConn;

public class Work0821DAO {
	
	private static Work0821DAO wDAO;
	
	private Work0821DAO() {
	}
	
	public static Work0821DAO getInstance() {
		if(wDAO == null) {
			wDAO = new Work0821DAO();
		}
		return wDAO;
	}
	
	public List<Integer> selectEmpnos() throws SQLException {
		List<Integer> empnoList = new ArrayList<Integer>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		DbConn db = DbConn.getInstance();

		try {
			con = db.getConnection("localhost", "scott", "tiger");
			pstmt = con.prepareStatement("select empno from emp");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				empnoList.add(rs.getInt("empno"));
			}
		}finally {
			db.closeDB(rs, pstmt, con);
		}
		
		return empnoList;
	}//selectEmpnos

	public Work0821VO selectEmpInfo(int empno) throws SQLException {
		Work0821VO wVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("localhost", "scott", "tiger");
			StringBuilder selectEmpInfo = new StringBuilder();
			selectEmpInfo
			.append("	select ename, hiredate, job, sal			")
			.append("	from emp									")
			.append("	where empno = ?								");
			
			pstmt = con.prepareStatement(selectEmpInfo.toString());
			pstmt.setInt(1, empno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				wVO = new Work0821VO(empno,rs.getString("ename"),rs.getDate("hiredate"),
								rs.getString("job"),rs.getInt("sal"));
			}//end if
		}finally {
			db.closeDB(rs, pstmt, con);
		}	
		
		return wVO;
	}//selectEmpInfo
	
}
