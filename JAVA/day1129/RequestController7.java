package kr.co.sist.controller.day1129;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

@Controller
public class RequestController7 {
	/**
	 * session에 값 설정
	 * @param session
	 * @return
	 */
	@RequestMapping("/day1129/use_session.do")
//	public String setSession(HttpSession session) {
	public String setSession(HttpServletRequest request) {
		//request를 사용하는 경우 : 접속자의 정보를 사용해야할 때
//		HttpSession session = request.getSession();
//		session.setAttribute("name", "농담곰");
//		session.setAttribute("age", "10");
		//WebUtil을 사용하면 세션에 값을 손쉽게 넣을 수 있다.
		WebUtils.setSessionAttribute(request, "name", "신짱구");
		WebUtils.setSessionAttribute(request, "age", "5");
		
		return "redirect:../index.html";
	}
	
	/**
	 * session에 할당된 값 얻기
	 * @param session
	 * @return
	 */
	@RequestMapping("/day1129/use_session2.do")
//	public String getSession(HttpSession session) {
	public String getSession(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		System.out.println("이름 : " + session.getAttribute("name"));
//		System.out.println("나이 : " + session.getAttribute("age"));
		
		System.out.println(WebUtils.getSessionAttribute(request, "name")); 
		System.out.println(WebUtils.getSessionAttribute(request, "age")); 
		
		return "day1129/session_get";
	}

	/**
	 * session에 할당된 값 삭제
	 * @param session
	 * @return
	 */
	@RequestMapping("/day1129/use_session3.do")
	public String removeSession(HttpSession session) {
		session.removeAttribute("name");
		session.removeAttribute("age");
		session.invalidate();
		return "day1129/session_get";
	}
}
