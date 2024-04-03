<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="usebean 액션태그의 scope 속성"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://192.168.10.136/html_prj/common/main/favicon.png"/>
<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- jQeury CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">


</style>

<script type="text/javascript">
$(function() {
	
	
});//ready
</script>

</head>
<body>
<!-- jsp 액션태그를 사용했을 때의 장점 : 형식이 일관되어 보인다. -->

<!-- scope="page" 요청할 때마다 객체가 생성된다. 이 페이지에서만 값이 사용된다. -->

<!-- scope="request" 요청할 때마다 객체가 생성된다. 
	 생성된 객체는 forward로 이동한 페이지에서 사용할 수 있다. -->
	 
<!-- scope="session" 접속자마다(웹 브라우저마다) 하나의 객체가 생성되고 유지된다.
	 모든 페이지에서 사용할 수 있다. (링크로 이동해도 객체가 유지됨) -->
	 
<!-- scope="application" 최초 접속자에 의해 하나의 객체가 생성되고 유지된다.
	 모든 접속자는 하나의 객체를 사용한다.
	 모든 페이지에서 사용할 수 있다. -->
	 
<jsp:useBean id="cVO" class="day1013.CounterVO" scope="session"/>
<jsp:setProperty name="cVO" property="cnt" value="1"/>

<div style="margin-top: 10px">
<button type="button" class="btn btn-primary position-relative">
  당신은 이 페이지에 <jsp:getProperty name="cVO" property="cnt"/>번 째 방문자 입니다.
  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
    	<jsp:getProperty name="cVO" property="cnt"/>
    	<span class="visually-hidden">unread messages</span>
  </span>
</button>
</div>

<div>
당신은
<%
	String num = String.valueOf(cVO.getCnt());
	
	for(int i=0; i<num.length(); i++){
%>
	<img src="../common/images/num_<%= num.charAt(i) %>.png">
<%
}
%>
번째 방문자 입니다.<br>
당신은 <%= cVO.getCnt() %>번째 방문자 입니다.
</div>

<a href="test_scope_session.jsp">세션사용</a>

<%
//forward 이동
//RequestDispatcher rd = request.getRequestDispatcher("test_scope_request.jsp");
//rd.forward(request,response);
%>

</body>
</html>