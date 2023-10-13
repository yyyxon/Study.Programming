<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
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
<%
//쿠키는 여러개가 심어질 수 있기 때문에 Cookie의 배열로 얻어진다.
Cookie[] cookies = request.getCookies();
boolean flag = false;

if(cookies!=null){ //쿠키가 존재하면
		String cookieName = "", cookieValue = "";
	for(Cookie cookie : cookies){
		 cookieName = cookie.getName();
		 cookieValue = cookie.getValue();
		 if(!"JSESSIONID".equals(cookieName)){
		 	//쿠키 이름이 JSESSIONID가 아니라면 쿠키가 존재하는 것
			out.print("쿠키명 : " + cookieName + ", 쿠키값 : " + cookieValue + " "); 
		 	flag = true; //쿠키가 존재하므로 true로 변경
		 }
	}//end for
}//end if

if(flag){ //쿠키 있음 %>
	<br>
	<a href="remove_cookie.jsp"><input type="button" value="쿠키 삭제" class="btn btn-outline-danger"></a>
<% }else { //쿠키 없음 %>
	쿠키가 존재하지 않습니다. <br>
	<a href="add_cookie.jsp"><input type="button" value="쿠키 심기" class="btn btn-outline-success"></a>
<% } %>

</body>
</html>