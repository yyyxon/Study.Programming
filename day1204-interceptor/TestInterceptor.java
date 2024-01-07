package kr.co.sist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

public class TestInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("-----preHandler-----");
		String name = request.getParameter("name");
		System.out.println("parameter : " + name);
		
		//session 값 얻기
		Object obj = WebUtils.getSessionAttribute(request, "name");
		String sessionName = "";
		if(obj != null) {
			sessionName=(String)obj;
		}//end if
		System.out.println("session : " + sessionName);
		System.out.println(WebUtils.getSessionAttribute(request, "age"));
		System.out.println(WebUtils.getSessionAttribute(request, "addr"));
		
		//false시 이후의 method는 실행하지 않음
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("-----postHandler-----");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("-----afterCompletion-----");
	}
	
}
