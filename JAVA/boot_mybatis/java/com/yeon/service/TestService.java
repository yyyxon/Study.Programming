package kr.co.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.dao.mapper.TestMapper;
import kr.co.sist.domain.EmpDomain;

@Service
//@Transactional //트랜잭션 처리 후 결과에 따라서 알아서 롤백 또는 커밋 됨(insert,delete,update)
public class TestService {
	
	@Autowired
	private TestMapper tm;
	
	public List<EmpDomain> selectAllEmp() {
		return tm.selectAllEmp();
	}

}
