package day1108;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.vo.DeptVO;

public class UseMyBatisDAO {
	
	public void insertDeptno(int deptno) throws PersistenceException{
		//1.MyBatis Handler 얻기
		SqlSession handler = MyBatisHandler.getInstace().getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2.쿼리문을 찾아서 실행 (<insert id = "아이디");
		//메소드명 중요하지 않음 (아이디를 찾아가는 것이므로)
		//int cnt = handler.delete("kr.co.sist.dept.insertCpDeptno", deptno);
		int cnt = handler.insert("kr.co.sist.dept.insertCpDeptno", deptno);
		if(cnt == 1) {
			handler.commit();
		}
		if(handler != null) handler.close();
	}
	
	public void insertSeqDeptno() throws PersistenceException{
		//1.MyBatis Handler 얻기
		SqlSession handler = MyBatisHandler.getInstace().getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2.쿼리문을 찾아서 실행 (<insert id = "아이디");
		int cnt = handler.insert("kr.co.sist.dept.insertSeqCpDept");
		if(cnt == 1) {
			handler.commit();
		}
		
		if(handler != null) handler.close();
	}
	
	public int updateDept(DeptVO dVO) throws PersistenceException{
		int cnt = 0;
		//1.MyBatis Handler 얻기
		SqlSession handler = MyBatisHandler.getInstace().getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2.쿼리문을 찾아서 실행
		cnt = handler.update("kr.co.sist.dept.updateCpDept", dVO);
		if(cnt == 1) {
			handler.commit();
		}
		
		if(handler != null) handler.close();
		
		return cnt;
	}
	
	public int deleteDept(int deptno) throws PersistenceException{
		int cnt = 0;
		//1.MyBatis Handler 얻기
		SqlSession handler = MyBatisHandler.getInstace().getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2.쿼리문을 찾아서 실행
		cnt = handler.delete("kr.co.sist.dept.deleteCpDept", deptno);
		if(cnt == 1) {
			handler.commit();
		}
		
		if(handler != null) handler.close();
		
		return cnt;
	}
}
