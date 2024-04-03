<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="세션에 설정된 값 얻기"%>
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
label {
	margin-top: 10px;
}

</style>

<script type="text/javascript">
$(function() {
	
	
});//ready
</script>

</head>
<body>
<%
/* 	String name = session.getAttribute("name").toString(); */
	String name = (String)session.getAttribute("name");

/* 	int age = ((Integer)session.getAttribute("age")).intValue(); */
	int age = (int)session.getAttribute("age");

	List<String> list = (List<String>)session.getAttribute("hobby");
%>

<label>이름</label> <input type="text" value="<%= name %>" class="inputBox"/><br>
<label>나이</label> <input type="text" value="<%= age %>" class="inputBox"/><br>
<label>취미</label>
<% for(String hobby : list){ %>
<input type="checkbox" name="hobby" value="<%= hobby %>"><%= hobby %>
<%	} %>

<br>
<a href="set_session.jsp"><input type="button" value="값 설정" class="btn btn-outline-success"></a>
<a href="remove_session.jsp"><input type="button" value="값 삭제" class="btn btn-outline-danger"></a>

</body>
</html>