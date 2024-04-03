<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="한국어 페이지"%>
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
<jsp:useBean id="fVO" class="day1013.ForwardVO" scope="page"/>
<jsp:setProperty name="fVO" property="*"/>
이 페이지에 오신 것을 환영합니다. <br>
이름 : <jsp:getProperty name="fVO" property="name"/>
나이 : <jsp:getProperty name="fVO" property="age"/>
지역 : <jsp:getProperty name="fVO" property="area"/>
<a href="javascript:history.back()">뒤로</a>
</body> 
</html>