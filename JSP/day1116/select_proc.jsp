<%@page import="kr.co.sist.domain.DeptEmpDomain"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="day1116.ExamDAO6"%>
<%@page import="kr.co.sist.domain.EmpDomain"%>
<%@page import="java.util.List"%>
<%@page import="day1110.ExamDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
Procedure를 사용한 조회
</div>

<div>
<form action="index.jsp">
<input type="hidden" name="page" value="${ param.page }"/>
부서 번호 : <input type="text" name="deptno" class="inputBox">
<input type="submit" value="조회" class="btn btn-info btn-sm"><br>
</form>
</div>

<div>
<c:if test="${ not empty param.deptno }">

<%
int deptno = Integer.parseInt(request.getParameter("deptno"));
Map<String,Object> map = new HashMap<String,Object>();
map.put("deptno",deptno);

List<DeptEmpDomain> list = ExamDAO6.getInstance().selectProcedure(map);
pageContext.setAttribute("empList", list);
%>

<table class="table">
<thead>
<tr>
<th>번호</th><th>부서번호</th><th>부서명</th><th>위치</th>
<th>사원번호</th><th>사원명</th><th>연봉</th><th>입사일</th>
</tr>
</thead>

<tbody>
<c:if test="${ empty empList }">
<tr>
<td colspan="8"><c:out value="${ param.deptno }"/>번 부서는 존재하지 않습니다.</td>
</c:if>

<c:if test="${ not empty empList }">
<c:forEach var="emp" items="${ empList }" varStatus="i">
<tr>
<td><c:out value="${ i.count }"/></td>
<td><c:out value="${ emp.deptno }"/></td>
<td><c:out value="${ emp.dname }"/></td>
<td><c:out value="${ emp.loc }"/></td>
<td><c:out value="${ emp.empno }"/></td>
<td><c:out value="${ emp.ename }"/></td>
<td><c:out value="${ emp.sal }"/></td>
<td><fmt:formatDate value="${ emp.hiredate }" pattern="yyyy-MM-dd"/></td>
</tr>
</c:forEach>
</c:if>

</tbody>
</table>

</c:if>
</div>