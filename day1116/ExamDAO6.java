package day1116;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.domain.DeptEmpDomain;
import kr.co.sist.vo.InsertProcedureVO;

public class ExamDAO6 {
	private static ExamDAO6 eDAO;
	private String configPath;
	
	private ExamDAO6() {
		configPath = "kr/co/sist/dao/mybatis-config.xml";
	}
	
	public static ExamDAO6 getInstance() {
		if(eDAO==null) {
			eDAO = new ExamDAO6();
		}
		return eDAO;
	}
	
	public void insertProcedure(InsertProcedureVO ipVO) throws PersistenceException{
		//1.
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		//2.
		ss.selectOne("kr.co.sist.exam6.insert_proc", ipVO);
		
		//3.
		mbh.closeHandler(ss);
	}
	
	public List<DeptEmpDomain> selectProcedure(Map<String, Object> map) throws PersistenceException{
		List<DeptEmpDomain> list = new ArrayList<DeptEmpDomain>();
		
		//1.
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		//2.
		ss.selectOne("kr.co.sist.exam6.select_proc", map);
		
		//3.
		mbh.closeHandler(ss);
		
		List<Map<String,Object>> tempList = (List<Map<String,Object>>)map.get("selectData");
		
//		Date date = null;
//		Timestamp ts = null;
		DeptEmpDomain ded = null;
		
		for(Map<String,Object> resultMap : tempList) {
//			ts = (Timestamp)resultMap.get("HIREDATE");
//			date = new Date(ts.getTime());
			ded = new DeptEmpDomain();
			ded.setDeptno(((BigDecimal)resultMap.get("DEPTNO")).intValue());
			ded.setDname((String)resultMap.get("DNAME"));
			ded.setLoc((String)resultMap.get("LOC"));
			
			if(resultMap.get("ENAME") != null) {
				ded.setEname((String)resultMap.get("ENAME"));
				ded.setEmpno(((BigDecimal)resultMap.get("EMPNO")).intValue());
				ded.setSal(((BigDecimal)resultMap.get("SAL")).intValue());
				ded.setHiredate(new Date(((Timestamp)resultMap.get("HIREDATE")).getTime()));
			}
			
			list.add(ded);
		}
		
		return list;
	}

	public List<DeptEmpDomain> selectAllProcedure() throws PersistenceException{
		List<DeptEmpDomain> list = new ArrayList<DeptEmpDomain>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		//1.
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		//2.
		ss.selectOne("kr.co.sist.exam6.select_all_proc", map);
		
		//3.
		mbh.closeHandler(ss);
		
		List<Map<String,Object>> tempList = (List<Map<String,Object>>)map.get("selectAllData");
		
		DeptEmpDomain ded = null;
		
		for(Map<String,Object> resultMap : tempList) {
			ded = new DeptEmpDomain();
			if(resultMap.get("ENAME") != null) {
				ded.setEname((String)resultMap.get("ENAME"));
				ded.setEmpno(((BigDecimal)resultMap.get("EMPNO")).intValue());
				ded.setSal(((BigDecimal)resultMap.get("SAL")).intValue());
				ded.setHiredate(new Date(((Timestamp)resultMap.get("HIREDATE")).getTime()));
			}
			
			list.add(ded);
		}
		
		return list;
	}
	
//	public static void main(String[] args) {
//		ExamDAO6 eDAO = ExamDAO6.getInstance();
//
//		
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("deptno", 10);
//		System.out.println(eDAO.selectProcedure(map));
//	}

}
