<%@page import="day1004.TestVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="데이터 처리 페이지 - 화면을 만들지 않는다.(view를 하지않음)"%>

<%
	//데이터 처리
	List<TestVO> list = new ArrayList<TestVO>();
	list.add(new TestVO("sist_long.png","쌍용교육센터","http://sist.co.kr"));
	list.add(new TestVO("daum.png","다음","http://daum.net"));
	list.add(new TestVO("bootstrap.png","부트스트랩","https://getbootstrap.com"));
	
	String name = "승연";
	//0.처리된 데이터를 뷰페이지로 보내기 위해 scope 객체에 설정한다.
	//여러 속성을 설정할 수 있다.
	request.setAttribute("data", list);
	request.setAttribute("name", name);
	
	//1.이동할 페이지 설정
	RequestDispatcher rd = request.getRequestDispatcher("forward_b.jsp");
	//2.이동
	rd.forward(request,response);
%>