package day1115;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.domain.WebMemberDomain;
import kr.co.sist.vo.WebMemberVO;

public class ExamDAO5 {
	private static ExamDAO5 eDAO;
	private String configPath;
	
	private ExamDAO5() {
		configPath = "kr/co/sist/dao/mybatis-config.xml";
	}//ExamDAO5
	
	public static ExamDAO5 getInstance() {
		if(eDAO == null) {
			eDAO = new ExamDAO5();
		}
		return eDAO;
	}//getInstance

	public List<String> selectAllId() throws PersistenceException{
		List<String> list = null;
		
		//1.
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		//2.
		list = ss.selectList("kr.co.sist.exam5.selectWebMemberId");
		
		//3.
		mbh.closeHandler(ss);
		
		return list;
	}//selectAllId
	
	public WebMemberDomain selectOneMember(String id) throws PersistenceException{
		WebMemberDomain wmd = null;
		
		//1.
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		//2.
		wmd = ss.selectOne("kr.co.sist.exam5.selectOneMember", id);
		
		//3.
		mbh.closeHandler(ss);
		
		return wmd;
	}
	
	public int updateWebMember(WebMemberVO wmVO) throws PersistenceException{
		int cnt = 0;
		
		//1.
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		//2.
		cnt = ss.update("kr.co.sist.exam5.dynamicSet", wmVO);
		
		if(cnt == 1) {
			ss.commit();
		}
		
		//3.
		mbh.closeHandler(ss);
		
		return cnt;
	}
	
	public static void main(String[] args) {
		ExamDAO5 eDAO = ExamDAO5.getInstance();
		eDAO.selectOneMember("cha");
	}
	
}//class
