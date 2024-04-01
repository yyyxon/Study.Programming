<%@page import="java.util.Date"%>
<%@page import="day1017.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	List<ProductVO> list = new ArrayList<ProductVO>();
	list.add(new ProductVO("item_1.png","베스트 후드티","올 가을을 책임질 왕따숩 후드티",52000,12223,new Date()));
	list.add(new ProductVO("item_2.png","하객룩 원피스","이쁜 원피스 내가 입으면 왜?",594000,31212,new Date()));
	
	pageContext.setAttribute("prdList", list);
%>

<c:forEach var="prd" items="${ prdList }">
<div class="card" style="width: 18rem; float:left; margin-left: 10px">
  <a href="buy.jsp?prdNum=${ prdNum }">
  	<img src="images/${ prd.img }" class="card-img-top" alt="${ prd.prdName }"></a>
  <div class="card-body">
    <h5 class="card-title"><c:out value="${ prd.prdName }"/></h5>
    <p class="card-text"><c:out value="${ prd.info }"/></p>
    <p class="card-text"><c:out value="${ prd.price }"/></p>
    <p class="card-text">\<fmt:formatNumber value="${ prd.price }" pattern="#,###,###"/></p>
    <p class="card-text"><fmt:formatDate value="${ prd.inputDate }" pattern="yyyy-MM-dd"/></p>
    <a href="buy.jsp?prdNum=${ prdNum }" class="btn btn-primary">Buy</a>
  </div>
</div>
</c:forEach>

</body>
</html>