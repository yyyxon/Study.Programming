package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.sist.service.MainService;

public class MainAction implements Action{
	
	private String movePage;
	private boolean isForwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name"); //파라미터 받기
		HttpSession session = request.getSession(); //관계유지(scope)
		session.setAttribute("sesName", name);
		
		MainService ms = MainService.getInstance();
		request.setAttribute("data", ms.searchPrd()); //view페이지로 데이터 전송(scope)
		
		movePage = "main/main.jsp";
		isForwardFlag = true;
	}

	@Override
	public String movePage() {
		// TODO Auto-generated method stub
		return movePage;
	}

	@Override
	public boolean isForward() {
		return isForwardFlag;
	}

}
