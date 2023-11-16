<%@page import="day1113.ExamService"%>
<%@page import="kr.co.sist.domain.CarDomain2"%>
<%@page import="kr.co.sist.domain.JoinDomain"%>
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
subquery join으로 조회하기
</div>

<a href="index.jsp?page=day1113/subquery_join&country=국산">국산</a>
<a href="index.jsp?page=day1113/subquery_join&country=수입">수입</a>

<div>

<%
String country = request.getParameter("country");
if(country == null){
	country = "국산";
}
//List<CarDomain2> carList = ExamDAO3.getInstance().subJoin(country);
ExamService es = new ExamService();
List<CarDomain2> carList = es.useSubqueryJoin(country);
pageContext.setAttribute("carList", carList);

%>
<table class="table">
<tr>
	<th>번호</th>
	<th>모델명/제조사</th>
	<th>가격</th>
	<th>연식</th>
	<th>옵션</th>
	<th>입력일</th>
</tr>

<c:if test="${ empty carList }">
<tr>
	<td colspan="6">차량 정보가 존재하지 않습니다.</td>
</tr>
</c:if>

<c:if test="${ not empty carList }">
<c:forEach var="cd" items="${ carList }" varStatus="i">
<%
String option = "";

for(int i=0; i<carList.size(); i++){
	if(carList.get(0).getCar_option().length() > 18){
		option = carList.get(0).getCar_option().substring(0, 19);
		option.concat("...");
	}
}

%>
<tr>
	<td><c:out value="${ i.count }"/></td>
	<td><c:out value="${ cd.model }"/></td>
	<td><c:out value="${ cd.price }"/></td>
	<td><c:out value="${ cd.car_year }"/></td>
	<td><c:out value="${ cd.car_option }"/></td>
	<td><fmt:formatDate value="${ cd.hiredate }" pattern="yyyy-MM-dd EEEE"/></td>
</tr>
</c:forEach>
</c:if>
</table>
</div>