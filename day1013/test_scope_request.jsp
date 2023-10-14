<%@page import="day1013.CounterVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="usebean에서 scope이 request로 설정되고 forward로 이동한 페이지"%>
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
//이전 페이지에서 scope="request"라면 request.setAttribute("id",객체)가 호출되는 것이므로
//이동한 페이지에서는 request.getAttribute("id");를 사용하여 저장된 객체를 받는다.
CounterVO cVO = (CounterVO)request.getAttribute("cVO");
%>

forward로 이동한 페이지 : <%= cVO.getCnt() %>

</body>
</html>