package day0821;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

import kr.co.sist.dao.DbConn;

/**
 * Procedure를 사용한 부서 사원 정보 조회
 * @author user
 */
public class UseProcedureSelectEmp {
	
	public UseProcedureSelectEmp(int deptno) throws SQLException {
		
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		//1.드라이버 로딩
		DbConn db = DbConn.getInstance();
		
		try {
			//2.커넥션 객체 얻기
			con = db.getConnection("localhost", "scott", "tiger");
			
			//3.쿼리 생성 객체 얻기
			cstmt = con.prepareCall(" {call select_dept_emp (?,?) } ");
			
			//4.바인드 변수 설정
			//IN
			cstmt.setInt(1, deptno);
			//OUT
			cstmt.registerOutParameter(2, Types.REF_CURSOR);
			
			//5.쿼리 실행
			cstmt.execute();
			
			//6.결과 얻기
			rs = (ResultSet)cstmt.getObject(2);
			
			System.out.println(deptno + "번 부서 정보 조회");
			while(rs.next()) {
				System.out.println(rs.getInt("deptno") + " / " + rs.getString("dname") + " / " + 
								   rs.getString("loc") + " / " + rs.getInt("empno") + " / " +
								   rs.getString("ename") + " / " + rs.getInt("sal"));
			}
			
			
		}finally {
			//7.연결해제
			db.closeDB(rs, cstmt, con);
		}//end finally
	}//UseProcedureSelectEmp

	public static void main(String[] args) {
		try {
			String inputDetptno = JOptionPane.showInputDialog("부서번호를 입력해주세요.");
			new UseProcedureSelectEmp(Integer.parseInt(inputDetptno));
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
