package day1109;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;

public class ExamDAO {
	
	private static ExamDAO eDAO;
	private ExamDAO() {
		
	}
	
	public static ExamDAO getInstance() {
		if(eDAO == null) {
			eDAO = new ExamDAO();
		}//end if
		
		return eDAO;
	}
	
	public String scsr(int deptno) {
		String dname = "";
		//1.MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2.쿼리문 실행
		dname = ss.selectOne("kr.co.sist.exam.scsr",deptno);
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		return dname;
	}

}
