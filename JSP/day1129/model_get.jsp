<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://localhost/mvc_prj/common/main/favicon.png"/>
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

세션에 값 얻기<br>
<c:out value="${ sessionScope.name }"/> <br>
<c:out value="${ sessionScope.addr }"/> <br>
<c:out value="${ sessionScope.age }"/> <br>

request에 값 얻기<br>
<c:out value="${ requestScope.name }"/> <br>
<c:out value="${ requestScope.addr }"/> <br>
<c:out value="${ requestScope.age }"/> <br>

<a href="../index.html">메인 화면</a>

</body>
</html>