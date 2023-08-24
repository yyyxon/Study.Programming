package day0818.work;

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
		if(wDAO==null) {
			wDAO = new WorkDAO();
		}
		return wDAO;
	}
	
	public List<WorkVO> searchCarInfo(String maker) throws SQLException {
		List<WorkVO> carInfoList = new ArrayList<WorkVO>();
		WorkVO wVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbConn db = DbConn.getInstance();
		
		try {
			con = db.getConnection("localhost", "scott", "tiger");
			StringBuilder searchCarInfo = new StringBuilder();
			searchCarInfo
			.append(" select cco.country, cma.maker, cmo.model, cmo.car_year, cmo.price, nvl(cmo.car_option, ' ') car_option ")
			.append(" from car_country cco, car_maker cma, car_model cmo 								")
			.append(" where cco.maker = cma.maker and cmo.model = cma.model and cma.maker = ?			");
			
			pstmt = con.prepareStatement(searchCarInfo.toString());
			pstmt.setString(1, maker);
			
			rs = pstmt.executeQuery();
			//String country, String maker, String model, String car_year, int price, String car_option
			while(rs.next()) {
				wVO = new WorkVO(rs.getString("country"), rs.getString("maker"), rs.getString("model"),
						rs.getString("car_year"), rs.getInt("price"), rs.getString("car_option"));
				carInfoList.add(wVO);
			}
			
		}finally {
			db.closeDB(rs, pstmt, con);
		}
		
		return carInfoList;
	}

}
