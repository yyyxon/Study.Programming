<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
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
	
	
});//ready
</script>

</head>
<body>

<%
String csvData = "java,Oracle,JDBC,HTML.CSS.JavaScript,jQuery";
pageContext.setAttribute("data", csvData);
%>

<select>
	<c:forTokens var="subject" items="${ data }" delims=",.">
		<option value="${subject}"><c:out value="${ subject }"/></option>
	</c:forTokens>
</select>
<br>

<c:forTokens var="subject" items="${ data }" delims=",.">
	<input type="checkbox" name="subject" value="${subject}"><c:out value="${ subject }"/></option>
</c:forTokens>
<br>

<c:forTokens var="subject" items="${ data }" delims=",.">
	<input type="radio" name="subject" value="${subject}"><c:out value="${ subject }"/></option>
</c:forTokens>

</body>
</html>