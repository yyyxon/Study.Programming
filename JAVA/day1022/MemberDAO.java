package kr.co.sist.member.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.member.vo.WebMemberLangVO;
import kr.co.sist.member.vo.WebMemberVO;

public class MemberDAO {
	
		private static MemberDAO mDAO;
		
		private MemberDAO() {
			
		}
		
		public static MemberDAO getInstance() {
			if( mDAO==null ) {
				mDAO=new MemberDAO();
			}//end if
			return mDAO;
		}//getInstance

		public boolean selectId(String id) throws SQLException {
			boolean resultId=false;
			
			DbConnection db=DbConnection.getInstance();
			
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
			//1. JNDI 사용객체 생성
			//2. DataSource얻기
			//3. Connection 얻기
				con=db.getConn("jdbc/dbcp");
			//4. 쿼리문 생성객체 얻기
				String selectId="select id from web_member where id=?";
				pstmt=con.prepareStatement(selectId);
			//5. 바인드 변수에 값 설정
				pstmt.setString(1, id);
			//6. 쿼리문 수행 후 결과 얻기
				rs=pstmt.executeQuery();
				resultId=rs.next(); //조회결과가 있으면 true, 없으면 false
				
			}finally {
			//7. 연결끊기
				db.dbClose(rs, pstmt, con);
			}//end finally	
			
			return resultId;
			
		}//selectID
		
		/**
		 * 회원가입
		 * @param wmVO
		 * @throws SQLException
		 */
		public void insertMember(WebMemberVO wmVO) throws SQLException {
			
			DbConnection db=DbConnection.getInstance();
			
			Connection con=null;
			PreparedStatement pstmt=null;
			
			try {
			//1. JNDI 사용객체 생성
			//2. DataSource 얻기
			//3. Connection 얻기
				con=db.getConn("jdbc/dbcp");
			//4. 쿼리문 생성객체 얻기
				StringBuilder insertWebMember=new StringBuilder();
				insertWebMember
				.append("insert into web_member")
				.append(" (id, pass, name, birth, tel, email, gender, zipcode, addr1, addr2, info,ip) ")
				.append("values(?,?,?,?,?,?,?,?,?,?,?,?)");
				
				pstmt=con.prepareStatement(insertWebMember.toString());
			//5. 바인드 변수에 값 설정
				pstmt.setString(1, wmVO.getId());
				pstmt.setString(2, wmVO.getPassword());
				pstmt.setString(3, wmVO.getName());
				pstmt.setString(4, wmVO.getBirthday());
				pstmt.setString(5, wmVO.getCell());
				pstmt.setString(6, wmVO.getEmail());
				pstmt.setString(7, wmVO.getGender());
				pstmt.setString(8, wmVO.getZipcode());
				pstmt.setString(9, wmVO.getAddr0());
				pstmt.setString(10, wmVO.getAddr1());
				pstmt.setString(11, wmVO.getInfo());
				pstmt.setString(12, wmVO.getIp());
				
			//6. 쿼리 수행 후 결과 얻기
				pstmt.executeUpdate();
			}finally {
			//7. 연결 끊기
				db.dbClose(null, pstmt, con);
			} //end finally
		}//insertMember
	
		public void insertLang(WebMemberLangVO wmlVO) throws SQLException {
		
			DbConnection db=DbConnection.getInstance();
			
			Connection con=null;
			PreparedStatement pstmt=null;
			
			try {
			//1. JNDI 사용객체 생성
			//2. DataSource 얻기
			//3. Connection 얻기
				con=db.getConn("jdbc/dbcp");
			//4. 쿼리문 생성객체 얻기
				String insertLang="insert into lang(id,lang) values(?,?)";
				pstmt=con.prepareStatement(insertLang);
			//5. 바인드변수에 값 설정
				pstmt.setString(1, wmlVO.getId() );
				pstmt.setString(2, wmlVO.getLang() );
			//6. 쿼리수행 후 결과 얻기
				pstmt.executeUpdate();
			}finally {
			//7. 연결 끊기
				db.dbClose(null, pstmt, con);
			}//end finally
				
		}//insertLang
		
		/**
		 * id에 해당하는 회원 정보를 반환
		 * @param id - 조회할 회원 아이디
		 * @return 회원 정보
		 * @throws SQLException
		 */
		public WebMemberVO selectMember(String id) throws SQLException{
			WebMemberVO wmVO = null;

			DbConnection db = DbConnection.getInstance();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				//3.Connection 얻기
				con = db.getConn("jdbc/dbcp");
				//4.쿼리문 생성 객체 얻기
				StringBuilder selectMember = new StringBuilder();
				selectMember
				.append("	select NAME, BIRTH, TEL, EMAIL, GENDER, ZIPCODE, ADDR1, ADDR2, INFO, INPUT_DATE, IP	")
				.append("	from web_member	")
				.append("	where id=?		");
				pstmt = con.prepareStatement(selectMember.toString());
				
				//5.바인드 변수 값 설정
				pstmt.setString(1, id);
				
				//6.쿼리 실행 후 결과 얻기
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					//컬럼명은 대소문자 구분X
					wmVO = new WebMemberVO();
					wmVO.setId(id);
					wmVO.setName(rs.getString("name"));
					wmVO.setBirthday(rs.getString("birth"));
					wmVO.setCell(rs.getString("tel"));
					wmVO.setGender(rs.getString("gender"));
					wmVO.setZipcode(rs.getString("zipcode"));
					wmVO.setEmail(rs.getString("email"));
					wmVO.setAddr0(rs.getString("addr1"));
					wmVO.setAddr1(rs.getString("addr2"));
					wmVO.setInputDate(rs.getDate("input_date"));
					wmVO.setIp(rs.getString("ip"));
					
					BufferedReader br = null;
					StringBuilder info = new StringBuilder(""); //기본값 empty
					
					try {
						//CLOB 데이터를 읽을 대는 STREAM 사용
						Clob clob = rs.getClob("info");
						if(clob != null) {
							br = new BufferedReader(rs.getClob("info").getCharacterStream());
							String temp = ""; //한 줄 읽음
							while((temp = br.readLine()) != null) { //읽어온 게 있다면 실행
								info.append(temp); //한 줄씩 저장
							}
							
							if(br!=null) br.close();
						}
					}catch(IOException ie) {
						ie.printStackTrace();
					}//end catch
					
					wmVO.setInfo(info.toString());
				}
				
			}finally {
				db.dbClose(rs, pstmt, con);
			}
			
			return wmVO;
		}
		
		public List<String> selectLang(String id) throws SQLException{
			List<String> list = new ArrayList<String>();

			DbConnection db = DbConnection.getInstance();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = db.getConn("jdbc/dbcp");
				
				
			}finally {
				db.dbClose(rs, pstmt, con);
			}
			
			return list;
		}
		
}//class
