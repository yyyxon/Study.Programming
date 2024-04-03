<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="JSTL - if"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	$("#btn").click(function() {
		$("#frm").submit();		
	});
});//ready
</script>

</head>
<body>
<c:if test="${ empty param.name }">
	<strong>이름을 입력하고 버튼을 눌러주세요.</strong>
</c:if>

<c:set var="color" value="red"/>
<c:if test="${ param.gender eq 'm'}">
	<c:set var="color" value="blue"/>
</c:if>

<c:if test="${ not empty param.name }">
	<strong style="color:${color}">${ param.name }님 안녕하세요?</strong>
</c:if>

<form name="frm" id="frm"> <!-- action생략시 내 페이지 요청 -->
	<label>이름</label><input type="text" name="name" class="inputBox" value="농담곰"/> <br>
	<label>성별</label>
	<input type="radio" name="gender" value="m" 
			${ param.gender eq 'm' ? "checked='checked'" : ""}/>남자
	<input type="radio" name="gender" value="f" 
			${ param.gender eq 'f' or empty param.gender ? "checked='checked'" : ""}/>여자
	
	<input type="button" value="전송" class="btn btn-info" id="btn"/>
</form>

<%
	String name = request.getParameter("name");
	if(name != null){
		session.setAttribute("user", name);
	}
%>
<a href="jstl_choose.jsp">이동</a>

</body>
</html>