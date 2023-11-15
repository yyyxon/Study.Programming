<%@page import="kr.co.sist.domain.EmpDomain"%>
<%@page import="java.util.List"%>
<%@page import="day1110.ExamDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
컬럼 여러개에 여러 행 조회
</div>
<div>
<%
List<EmpDomain> empList = ExamDAO2.getInstance().mcmr();
pageContext.setAttribute("empList", empList);
%>
<table class="table">
<tr>
	<th>번호</th>
	<th>사원 번호</th>
	<th>사원명</th>
	<th>연봉</th>
	<th>입사일</th>
</tr>

<c:if test="${ empty empList }">
<tr>
	<td colspan="5">사원 정보가 존재하지 않습니다.</td>
</tr>
</c:if>

<c:if test="${ not empty empList }">
<c:forEach var="emp" items="${ empList }" varStatus="i">
<tr>
	<td><c:out value="${ i.count }"/></td>
	<td><c:out value="${ emp.empno }"/></td>
	<td><c:out value="${ emp.ename }"/></td>
	<td><fmt:formatNumber value="${ emp.sal }" pattern="#,###"/></td>
	<td><fmt:formatDate value="${ emp.hiredate }" pattern="yyyy-MM-dd"/></td>
</tr>
</c:forEach>
</c:if>

</table>
</div>