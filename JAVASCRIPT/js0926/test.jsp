<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> JSP </title>
</head>
<body>
<strong>Back-end Page</strong><br>
<span><%= request.getParameter("name") %>님께서 입력한 정보</span> <br>
<div>
	<%= request.getParameter("note") %>
</div>
</body>
</html>