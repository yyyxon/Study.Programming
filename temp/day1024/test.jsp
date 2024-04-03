<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<% 
	Map<String, String> map = System.getenv(); 
	Set<String> keys = map.keySet();
	for(String key : keys){
%>
	<li><%= key %> : <%= map.get(key) %></li>
<%	
	}//end for
%>
</ul>

</body>
</html>