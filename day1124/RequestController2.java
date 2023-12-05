package kr.co.sist.controller.day1124;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestController2 {
	
	@GetMapping("/req.do")
	public String responseJSP() {
		return "day1124/req2"; //WEB-INF/views/day1124/req2.jsp가 응답
	}

	@GetMapping("/day1124/req.do")
	public String responseJSP2() {
		return "day1124/sub/req3"; //WEB-INF/views/day1124/sub/req3.jsp가 응답
	}
	
	@GetMapping("/param_frm.do")
	public String webParameterFrm() {
		return "day1124/param_frm"; //WEB-INF/views/day1124/param_frm.jsp가 응답
	}

	@GetMapping("/use_req.do")
	public String webParameterFrm(HttpServletRequest request) {
		//파라미터로 HttpServletRequest를 받는 것은 권장x
		String name = request.getParameter("name"); 
		System.out.println("이름이 유일 " + name);
		
		//name 속성이 중복
		String[] age = request.getParameterValues("age");
		if(age != null) {
			for(String i : age) {
				System.out.println(i);
			}//end for
		}//end if
		
		return "day1124/param_frm"; //WEB-INF/views/day1124/param_frm.jsp가 응답
	}
	
}
