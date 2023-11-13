package day1113;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.domain.CarDomain;
import kr.co.sist.domain.CarDomain2;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.domain.JoinDomain;
import kr.co.sist.vo.BoardVO;

public class ExamDAO3 {
	private String configPath;
	private static ExamDAO3 eDAO;
	
	private ExamDAO3() {
		configPath = "kr/co/sist/dao/mybatis-config.xml";
	}
	
	public static ExamDAO3 getInstance() {
		if(eDAO==null) {
			eDAO = new ExamDAO3();
		}
		return eDAO;
	}
	
	public List<CarDomain> selectSubquery(BoardVO bVO) throws PersistenceException{
		List<CarDomain> list = null;
		
		//1.Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		//2.Mapper.xml에서 실행할 SQL문을 찾고 실행
		list = ss.selectList("kr.co.sist.exam3.subQuery",bVO);
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		return list;
	}
	
	public List<EmpDomain> union() throws PersistenceException{
		List<EmpDomain> list = null;
		
		//1.Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		//2.Mapper.xml에서 실행할 SQL문을 찾고 실행
		list = ss.selectList("kr.co.sist.exam3.union");
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		return list;
	}

	public List<JoinDomain> join() throws PersistenceException{
		List<JoinDomain> list = null;
		
		//1.Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		//2.Mapper.xml에서 실행할 SQL문을 찾고 실행
		list = ss.selectList("kr.co.sist.exam3.join");
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		return list;
	}
	
	public List<CarDomain2> subJoin(String maker) throws PersistenceException{
		List<CarDomain2> list = null;
		
		//1.Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		//2.Mapper.xml에서 실행할 SQL문을 찾고 실행
		list = ss.selectList("kr.co.sist.exam3.subJoin", maker);
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		return list;
	}
	
	public List<EmpDomain> dollarSign(String tableName) throws PersistenceException{
		List<EmpDomain> list = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		list = ss.selectList("kr.co.sist.exam3.dollarSign",tableName);
		
		mbh.closeHandler(ss);
		
		return list;
		
	}//dollarSign
	
	public static void main(String args[]) {
		BoardVO bVO = new BoardVO();
		bVO.setStartNum(11);
		bVO.setEndNum(20);
		
		ExamDAO3.getInstance().dollarSign("cp_emp3");
	}

}
