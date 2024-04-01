<%@page import="day1113.ExamDAO3"%>
<%@page import="kr.co.sist.domain.EmpDomain"%>
<%@page import="java.util.List"%>
<%@page import="day1110.ExamDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
$의 조회
</div>

<div>
<form action="index.jsp">
<input type="hidden" name="page" value="${ param.page }"/>
<input type="radio" name="type" value="1"${ param.type eq "1" ?" checked='checked'" : '' }> 본사
<input type="radio" name="type" value="2"${ param.type eq "2" ?" checked='checked'" : '' }> 지사
<input type="submit" value="조회" class="btn btn-info btn-sm"><br>
</form>
</div>

<div>
<c:if test="${ not empty param.type }">

<%
String type = request.getParameter("type");
String tableName = "cp_emp3";
if(type == null || "1".equals(type)){
	tableName = "emp";
}

List<EmpDomain> empList = ExamDAO3.getInstance().dollarSign(tableName);
pageContext.setAttribute("empList", empList);
%>
<table class="table">
<tr>
	<th>번호</th>
	<th>사원 번호</th>
	<th>사원명</th>
	<th>연봉</th>
	<th>직무</th>
	<th>부서번호</th>
	<th>입사일</th>
</tr>

<c:if test="${ empty empList }">
<tr>
	<td colspan="7">사원 정보가 존재하지 않습니다.</td>
</tr>
</c:if>

<c:if test="${ not empty empList }">
<c:forEach var="emp" items="${ empList }" varStatus="i">
<tr>
	<td><c:out value="${ i.count }"/></td>
	<td><c:out value="${ emp.empno }"/></td>
	<td><c:out value="${ emp.ename }"/></td>
	<td><fmt:formatNumber value="${ emp.sal }" pattern="#,###"/></td>
	<td><c:out value="${ emp.job }"/></td>
	<td><c:out value="${ emp.deptno }"/></td>
	<td><fmt:formatDate value="${ emp.hiredate }" pattern="yyyy-MM-dd EEEE"/></td>
</tr>
</c:forEach>
</c:if>
</table>

</c:if>
</div>