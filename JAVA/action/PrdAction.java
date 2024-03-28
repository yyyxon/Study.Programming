package kr.co.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.domain.PrdDomain;
import kr.co.sist.service.PrdService;

public class PrdAction implements Action{
	private String moveURL;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramPrdCode = request.getParameter("code"); //파라미터 받기
		int prdCode = 0;
		//파라미터의 유효성 검증
		if(paramPrdCode != null || !"".equals(paramPrdCode)) {
			prdCode = Integer.parseInt(paramPrdCode);
		}//end if
		
		//XxxService 사용 - 업무 처리 구현하는 클래스
		PrdService ps = PrdService.getInstance();
		PrdDomain pd = ps.searchPrdDetail(prdCode);
		
		//업무 처리 결과를 받아서 scope 객체에 설정
		request.setAttribute("detailData", pd);
		moveURL = "prd/prd_detail.jsp";
		forwardFlag = true;
		
	}//execute

	@Override
	public String movePage() {
		return moveURL;
	}

	@Override
	public boolean isForward() {
		return forwardFlag;
	}

}
