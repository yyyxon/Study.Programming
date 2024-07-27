package day1103;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.member.vo.DeptVO;

public class UseMyBatisFramework {
	
	public void selectDeptno() {
		//1.스트림을 사용하여 설정 파일과 연결
		try {
			Reader reader = Resources.getResourceAsReader("day1103/mybatis-config.xml");
			
			//2.MyBatis Framework 생성
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
			
			if(reader!=null) reader.close();
			
			//3.MyBatis Framework Handler를 얻기 (데이터베이스와 연결)
			SqlSession ss = ssf.openSession();
			
			//4.Handler 사용
			List<DeptVO> list = ss.selectList("kr.co.sist.dept.dao.selectAllDept");
			for(DeptVO dVO : list) {
				System.out.println(dVO.getDeptno() + " / " + dVO.getDname() + " / " + dVO.getLoc());
			}//end for
			
			//5.연결 끊기
			ss.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//selectDeptno
	
	public static void main(String[] args) {
		new UseMyBatisFramework().selectDeptno();
	}

}
