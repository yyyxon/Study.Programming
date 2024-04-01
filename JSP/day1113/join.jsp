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
join으로 조회하기
</div>

<div>

<%
List<JoinDomain> deptEmpList = ExamDAO3.getInstance().join();
pageContext.setAttribute("deptEmpList", deptEmpList);

%>
<table class="table">
<tr>
	<th>번호</th>
	<th>부서번호</th>
	<th>부서명</th>
	<th>사원번호</th>
	<th>사원명</th>
	<th>연봉</th>
</tr>

<c:if test="${ empty deptEmpList }">
<tr>
	<td colspan="6">부서 정보가 존재하지 않습니다.</td>
</tr>
</c:if>

<c:if test="${ not empty deptEmpList }">
<c:forEach var="jd" items="${ deptEmpList }" varStatus="i">
<tr>
	<td><c:out value="${ i.count }"/></td>
	<td><c:out value="${ jd.deptno }"/></td>
	<td><c:out value="${ jd.dname }"/></td>
	<td><c:out value="${ jd.empno }"/></td>
	<td><c:out value="${ jd.ename }"/></td>
	<td><fmt:formatNumber value="${ jd.sal }" pattern="#,###,###"/></td>
</tr>
</c:forEach>
</c:if>
</table>
</div>