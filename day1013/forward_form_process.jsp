<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="forward action태그 사용"%>

<%
request.setCharacterEncoding("UTF-8"); //area 한글처리(forward로 이동하는 페이지에서의 한글 처리)
String serverName = request.getServerName();
String uri = "kor.jsp";
String area = "국내"; //접속 지역을 변수에 저장 => web parameter로 만들어서 이동하는 페이지로 전달

if(!serverName.equals("localhost") && !serverName.equals("127.0.0.1")) {
	uri = "eng.jsp";
	area = "국외";
}//end if
%>

<%-- parameter가 없었을 때 <jsp:forward page="<%= uri %>"/> --%>
<!-- request.setAttribute도 가능 -->
<!-- 페이지로 이동할 때 값이 같이 전달됨 -->
<jsp:forward page="<%= uri %>">
	<jsp:param name="area" value="<%= area %>"/>
</jsp:forward>