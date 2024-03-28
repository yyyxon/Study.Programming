package day1114;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.vo.BoardVO;

public class ExamDAO4 {
	
	private static ExamDAO4 eDAO;
	private String configPath;
	
	private ExamDAO4() {
		configPath = "kr/co/sist/dao/mybatis-config.xml";
	}
	
	public static ExamDAO4 getInstance() {
		if(eDAO == null) {
			eDAO = new ExamDAO4();
		}//end if
		return eDAO;
	}//getInstance
	
	public List<EmpDomain> dynamicWhere(int deptno) throws PersistenceException{
		List<EmpDomain> list = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		list = ss.selectList("kr.co.sist.exam4.dynamicWhere", deptno);
		
		mbh.closeHandler(ss);
		
		return list;
	}//dynamicWhere
	
	
	/**
	 * total count
	 * @param bVO
	 * @return
	 * @throws PersistenceException
	 */
	public int dynamicIf(BoardVO bVO) throws PersistenceException{
		int cnt = 0;
		
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		cnt = ss.selectOne("kr.co.sist.exam4.dynamicIf", bVO);
		
		mbh.closeHandler(ss);
		
		return cnt;
	}
	
	public List<EmpDomain> dynamicChoose(int tempNo) throws PersistenceException{
		List<EmpDomain> list = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		list = ss.selectList("kr.co.sist.exam4.dynamicChoose", tempNo);
		
		mbh.closeHandler(ss);
		
		return list;
	}

	public List<EmpDomain> dynamicForeach(Map<String, Object> map) throws PersistenceException{
		List<EmpDomain> list = null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstace();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		list = ss.selectList("kr.co.sist.exam4.dynamicForeach", map);
		
		mbh.closeHandler(ss);
		
		return list;
	}
	
	public static void main(String[] args) {
		BoardVO bVO = new BoardVO();
		bVO.setKeyword("간");
		bVO.setFieldName("content");
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		list.add("SALESMAN");
		list.add("MANAGER");
		list.add("ANALYST");
		list.add("PRESIDENT");
		
		map.put("deptno", 30);
		map.put("job_list", list);
		
		ExamDAO4.getInstance().dynamicForeach(map);
		
	}

}
