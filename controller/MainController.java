package kr.co.sist.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;
import kr.co.sist.action.MainAction;
import kr.co.sist.action.PrdAction;

/**
 * .do의 모든 요청을 받을 수 있는 Controller
 * @author user
 */
@SuppressWarnings("serial")
public class MainController extends HttpServlet {
	
	private static Map<String, Action> map; 
	
	static { //static 영역 => 개발자가 별도로 호출하지 않아도 자바코드를 실행할 수 있다.
		map = new HashMap<String, Action>();
		map.put("M001", new MainAction()); //메인 화면을 보여주기 위한 액션
		map.put("D001", new PrdAction()); //상품 상세 액션
	}
	
	public void init() {
		//최초 사용자에 의해 한 번만 호출된다.
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		
		if(cmd == null || !map.containsKey(cmd)) { //최초 호출이거나 cmd를 임의로 조작했을 때
			cmd = "M001"; //메인화면으로 이동
		}//end if
		
		Action action = map.get(cmd);
		action.execute(request, response);
		
		movePage(request, response, action.movePage(), action.isForward());
	}//doPost
	
	public void movePage(HttpServletRequest request, HttpServletResponse response, 
			String moveURL, boolean isForward) throws IOException, ServletException{
		
		if(isForward) {
			//forward로 이동
			RequestDispatcher rd = request.getRequestDispatcher(moveURL);
			rd.forward(request, response);
		}else {
			//redirect로 이동
			response.sendRedirect(moveURL);
		}//end else
		
	}

}
