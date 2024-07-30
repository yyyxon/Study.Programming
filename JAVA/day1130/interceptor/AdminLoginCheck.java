package kr.co.sist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

public class AdminLoginCheck implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Object objId = WebUtils.getSessionAttribute(request, "adminId");
		boolean nextFlag = objId!=null; //세션이 있다면 true, 없다면 false
		
		if(!nextFlag) { //세션이 없는 경우
//			response.sendRedirect("http://localhost/interceptor_prj/admin/login_frm.do");
			response.sendRedirect("http://localhost/interceptor_prj/index.do");
		}//end if
		
		return nextFlag; //true면 다음으로 진행, false면 중지
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	
	
}
