<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="JSTL - for"%>
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
<c:forEach var="i" begin="1" end="10" step="1">
	<c:out value="${ i }"/>
</c:forEach>
<br>

<select>
	<c:forEach var="i" begin="1" end="100" step="1">
		<option value="${ i }">${ i }</option>
	</c:forEach>
</select>
<br>

<%
	Calendar c = Calendar.getInstance();
	int year = c.get(Calendar.YEAR);
	/* EL에서는 변수를 사용할 수 없으므로 scope객체에 저장 */
	pageContext.setAttribute("nowYear", year);
%>

<!-- 현재년도부터 20년 후까지 연도를 출력 -->
<!-- 2033년이 선택되어 보여질 수 있게 코딩 -->
<select>
	<c:forEach var="year" begin="${ nowYear }" end="${ nowYear+20 }" step="1">
		<option value="${ year }"${ year eq 2033 ? " selected='selected'" : "" }>
			<c:out value="${ year }"/>
		</option>
	</c:forEach>
</select>

</body>
</html>