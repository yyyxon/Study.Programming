<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<strong>array</strong>
<%
	String[] names = {"김주민","차준식","홍지성","정민교","김다영"};
	//1. scope 객체에 값 할당
	pageContext.setAttribute("namesArr", names);
%>

<!-- 2. 사용 -->
<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>first</th>
			<th>last</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="name" items="${namesArr}" varStatus="i">
			<%-- <c:set var="i" value="${ i+1 }"/> --%>
			<tr>
				<%-- <td>${ i }</td> --%>
				<td>
					<c:out value="${ i.index }"/> / <!-- index는 0번 부터 -->
					<c:out value="${ i.count }"/>   <!-- count는 1번 부터 -->
				</td>
				<td><c:out value="${name}"/></td>
				<td><c:out value="${ i.first }"/></td>
				<td><c:out value="${ i.last }"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<strong>list</strong>
<%
	//1.list 생성
	List<String> list = new ArrayList<String>();
	list.add("장용석");
	list.add("오호수");
	list.add("서효민");
	list.add("김선경");
	list.add("박서현");
	
	//2.scope객체에 할당
	pageContext.setAttribute("namesList", list);	
%>
<!-- 3.사용 -->
<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>first</th>
			<th>last</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="name" items="${namesList}" varStatus="i">
			<%-- <c:set var="i" value="${ i+1 }"/> --%>
			<tr>
				<%-- <td>${ i }</td> --%>
				<td>
					<c:out value="${ i.index }"/> / <!-- index는 0번 부터 -->
					<c:out value="${ i.count }"/>   <!-- count는 1번 부터 -->
				</td>
				<td><c:out value="${name}"/></td>
				<td><c:out value="${ i.first }"/></td>
				<td><c:out value="${ i.last }"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>