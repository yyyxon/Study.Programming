package day1110;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.domain.CpDeptDomain;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.domain.ZipcodeDomain;

public class ExamDAO2 {
	private static ExamDAO2 eDAO;
	private String configXML;
	
	private ExamDAO2() {
		configXML = "kr/co/sist/dao/mybatis-config.xml";
	}
	
	public static ExamDAO2 getInstance() {
		if(eDAO==null) {
			eDAO = new ExamDAO2();
		}
		return eDAO;
	}//getInstance
	
	/**
	 * 여러 컬럼에 행 하나 조회
	 * @param deptno 부서번호
	 * @return domain 결과값
	 * @throws PersistenceException
	 */
	public CpDeptDomain mcsr(int empno) throws PersistenceException{
		CpDeptDomain cdd = null;
		
		//1.Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2.수행 후 결과 얻기
		cdd = ss.selectOne("kr.co.sist.exam2.mcsr",empno);
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		return cdd;
	}//mcsr

	/**
	 * 단일 컬럼에 여러행 조회
	 * @param deptno
	 * @return
	 * @throws PersistenceException
	 */
	public List<String> scmr(int deptno) throws PersistenceException {
		List<String> list = null;
		
		//1.MyBatisHandler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2.파싱할 노드를 찾고, 쿼리를 수행
		list = ss.selectList("kr.co.sist.exam2.scmr",deptno);
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		return list;
	}//scmr
	
	/**
	 * 연습 문제
	 * @param deptno
	 * @return
	 * @throws PersistenceException
	 */
	public List<Integer> deptEmp(int deptno) throws PersistenceException{
		List<Integer> list = null;
		
		//1.
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2.
		//부적합한 열 유형 1111은 에러는 parameterType 속성은 존재하나 값을 넣지 않을 때 발생하는 error
		//list = ss.selectList("kr.co.sist.exam2.deptEmp"); //값이 들어가지 않으므로 error
		list = ss.selectList("kr.co.sist.exam2.deptEmp",deptno); //값이 들어가므로 정상동작
		
		//3.
		mbh.closeHandler(ss);
		
		return list;
	}//deptEmp
	
	/**
	 * 다중 컬럼에 다중 행 조회
	 * @return
	 * @throws PersistenceException
	 */
	public List<EmpDomain> mcmr() throws PersistenceException{
		List<EmpDomain> list = null;
		
		//1.Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2.파싱할 노드를 찾아 쿼리를 수행
		//parameterType 속성이 없으므로 매개변수 하나인 method를 호출한다.
		list = ss.selectList("kr.co.sist.exam2.mcmr");
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		return list;
	}//mcmr
	
	/**
	 * < 작다
	 * @param sal
	 * @return
	 * @throws PersistenceException
	 */
	public List<EmpDomain> lessThan(int sal) throws PersistenceException{
		List<EmpDomain> list = null;
		
		//1.MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configXML, false);
		
		//2.파싱할 노드를 찾아, 쿼리를 수행
		list = ss.selectList("kr.co.sist.exam2.lessThan", sal);
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		
		return list;
	}//lessThan

	public List<EmpDomain> greaterThan(int sal) throws PersistenceException{
		List<EmpDomain> list = null;
		
		//1.MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configXML, false);
		
		//2.파싱할 노드를 찾아, 쿼리를 수행
		list = ss.selectList("kr.co.sist.exam2.greaterThan", sal);
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		
		return list;
	}//greaterThan
	
	public List<ZipcodeDomain> selectZipode(String dong) throws PersistenceException{
		List<ZipcodeDomain> list = null;
		
		//1.MyBatisHandler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configXML, false);
		
		//2.파싱 후 결과 얻기
		list = ss.selectList("kr.co.sist.exam2.like",dong);
		
		//3.Handler 닫기
		mbh.closeHandler(ss);
		
		return list;
	}
	
	public static void main(String[] args) {
		ExamDAO2 eDAO = ExamDAO2.getInstance();
		System.out.println(eDAO.selectZipode("역삼"));
	}

}
