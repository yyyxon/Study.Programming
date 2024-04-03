<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="day1013.ForwardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="JSTL에서 VO의 사용"%>
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

<!-- scriptlet 사용 -->
<%
	//1.객체 생성
	ForwardVO fVO = new ForwardVO("농담곰","서울시",10);

	//2.scope객체 할당
	pageContext.setAttribute("fVO", fVO);
%>

<!-- 3.사용 : get을 제외한 method명을 소문자로 기술하고, method 기호()를 붙이지 않는다. -->
<ul>
	<li>이름 : <strong><c:out value="${fVO.name }"/></strong></li>
	<li>지역 : <strong><c:out value="${fVO.area }"/></strong></li>
	<li>나이 : <strong><c:out value="${fVO.age }"/></strong></li>
</ul>



<!-- useBean action tag사용 -->
<jsp:useBean id="fVO2" class="day1013.ForwardVO" scope="page"/>
<jsp:setProperty name="fVO2" property="name" value="농담곰"/> <!-- property : set을 제외한 method명 소문자로 -->
<jsp:setProperty name="fVO2" property="area" value="서울시"/> 
<jsp:setProperty name="fVO2" property="age" value="5"/> 

<ul>
	<li>이름 : <strong><c:out value="${fVO2.name }"/></strong></li>
	<li>지역 : <strong><c:out value="${fVO2.area }"/></strong></li>
	<li>나이 : <strong><c:out value="${fVO2.age }"/></strong></li>
</ul>

<!-- List와 함께 사용 -->
<%
	//1.list 생성
	List<ForwardVO> list = new ArrayList<ForwardVO>();
	list.add(new ForwardVO("농담곰","인천시",25));
	list.add(new ForwardVO("이슬이","서울시",26));
	list.add(new ForwardVO("비실이","서울시",24));
	list.add(new ForwardVO("노진구","수원시",27));
	
	//2.scope객체에 할당
	pageContext.setAttribute("data", list);
%>

<!-- 사용 -->
<table class="table" style="width:500px">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>거주지</th>
			<th>나이</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="member" items="${data}" varStatus="i">
			<tr>
				<td><c:out value="${ i.count }"/></td>   <!-- count는 1번 부터 -->
				<td><c:out value="${ member.name }"/></td>
				<td><c:out value="${ member.area }"/></td>
				<td><c:out value="${ member.age }"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>