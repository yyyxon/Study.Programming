<%@page import="day1113.ExamDAO3"%>
<%@page import="kr.co.sist.domain.CarDomain"%>
<%@page import="kr.co.sist.domain.EmpDomain"%>
<%@page import="java.util.List"%>
<%@page import="day1110.ExamDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
subquery로 조회하기
</div>
<jsp:useBean id="bVO" class="kr.co.sist.vo.BoardVO" scope="page"/>

<div>

<%
String tempPage = request.getParameter("currentPage");
int currentPage = 0;
if(tempPage != null){
	currentPage = Integer.parseInt(tempPage);
}
bVO.setStartNum(1);
bVO.setEndNum(10);

List<CarDomain> carList = ExamDAO3.getInstance().selectSubquery(bVO);
pageContext.setAttribute("carList", carList);
%>
<table class="table">
<tr>
	<th>번호</th>
	<th>이미지</th>
	<th>모델명</th>
	<th>옵션</th>
	<th>배기량</th>
	<th>가격</th>
	<th>입력일</th>
</tr>

<c:if test="${ empty carList }">
<tr>
	<td colspan="7">차량 정보가 존재하지 않습니다.</td>
</tr>
</c:if>

<c:if test="${ not empty carList }">
<c:forEach var="cd" items="${ carList }" varStatus="i">
<tr>
	<td><c:out value="${ i.count }"/></td>
	<td><img src="http://localhost/myBatis_prj/day1113/car_img/${ cd.car_img }" style="width:50px"/></td>
	<td><c:out value="${ cd.model }"/></td>
	<td><c:out value="${ cd.car_option }"/></td>
	<td><c:out value="${ cd.cc }"/></td>
	<td><fmt:formatNumber value="${ cd.price }" pattern="#,###,###"/></td>
	<td><fmt:formatDate value="${ cd.hiredate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
</tr>
</c:forEach>
</c:if>
</table>
</div>