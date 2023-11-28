package day1123;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet annotaion이 있다면 DD에
//<servlet>, <servlet-mapping>을 작성하지 않아도 된다.
//Servlet2.5 이상부터 지원
@SuppressWarnings("serial")
@WebServlet("/use_context_param")
public class UseContextParam extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.ServletContext 얻기
		ServletContext sc = getServletContext();
		
		//2.값 얻기
		String protocol = sc.getInitParameter("protocol");
		String serverName = sc.getInitParameter("serverName");
		String servletPath = sc.getInitParameter("servletPath");
		String commonCss = sc.getInitParameter("commonCss");
		
		System.out.println(protocol);
		System.out.println(serverName);
		System.out.println(servletPath);
		System.out.println(commonCss);
	
	}
	
}
