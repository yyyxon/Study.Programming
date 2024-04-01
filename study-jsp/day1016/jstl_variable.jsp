<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="JSTL 사용 - 변수"%>
<!-- 1.지시자 선언 -->
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
<!-- 변수의 선언 -->
<c:set var="year" value="2023"/>

<!-- 출력 : 입력된 값이 그대로 출력된다. -->
<c:out value="year"/>

<!-- EL을 사용하여 변수의 값을 출력할 수 있다. -->
<!-- EL은 set으로 선언된 변수에 대해 접근이 가능하다.-->
<c:out value="${ year }"/> / ${ year } <br>

<!-- c:out은 브라우저에 출력할 때 사용 -->
<!-- 아래는 되긴하나 잘못된 사용의 예 -->
<input type="text" name="birth" value="<c:out value="${year}"/>"/><br>

<!-- EL은 속성 값으로 출력할 때 사용 -->
<input type="text" name="birth" value="${year}"/><br>


<!-- ////// -->
<c:set var="name" value="농담곰"/>
<c:set var="age" value="25"/>

이름 : <c:out value="${ name }"/>님<br>
나이 : <c:out value="${ age }"/>살<br>

<!-- 변수 삭제 -->
<c:remove var="name"/>
-- 삭제 이후 -- <br>
이름 : <c:out value="${ name }"/>님<br>
나이 : <c:out value="${ age }"/>살<br>

</body>
</html>