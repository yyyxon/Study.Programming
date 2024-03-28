package day1117;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

public class ParamProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답방식 (MIME-Types) 설정
		response.setContentType("text/html;charset=UTF-8");
		
		//출력 스트림 얻기
		PrintWriter out = response.getWriter();
		
		//파라미터 받기
		//POST방식의 한글 처리
		request.setCharacterEncoding("UTF-8");
		//HTML Form Control의 name속성이 유일할 때
		String name = request.getParameter("name");
		
		//HTML Form Control의 name속성이 중복일 때
		String[] age = request.getParameterValues("age");
		
		if("농담곰".equals(name)) {
			name = "반장 : " + name;
		}else if("흰둥이".equals(name) || "신짱아".equals(name) || "신짱구".equals(name) || "봉미선".equals(name)) {
			name = "조장 : " + name;
		}else {
			name = "평민 : " + name;
		}
		
		//처리한 결과를 scope 객체에 할당(위치 상관 없이 페이지 이동전에만 할당하면 된다.)
		request.setAttribute("name", name);
		
		//1.이동할 페이지 설정
		RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
		
		//2.이동
		rd.forward(request, response);

//		out.print("이름 : ");
//		out.print(name);
//		out.print("<br>");
//		out.print("나이 : ");
//		for(int i=0; i<age.length; i++) {
//			out.print(age[i]);
//			out.print(" ");
//		}
//		
//		out.println("을 입력하셨습니다.<br>");
//		out.println("오늘은 금요일 입니다.<br>");
		
	}

}
