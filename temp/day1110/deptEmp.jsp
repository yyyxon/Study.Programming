<%@page import="java.util.List"%>
<%@page import="kr.co.sist.domain.CpDeptDomain"%>
<%@page import="day1110.ExamDAO2"%>
<%@page import="day1109.ExamDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<strong>부서별 사원번호 조회</strong>
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
List<Integer> empnoList = ExamDAO2.getInstance().deptEmp(deptno);
pageContext.setAttribute("empnoList", empnoList);

if(empnoList == null){
	%>
	부서 번호 입력이 잘못되었습니다.
	<%
}else {

%>
<c:if test="${ empty empnoList }">
<c:out value="${ param.deptno }"/>번 부서는 사원이 존재하지 않습니다.
</c:if>

<c:if test="${ not empty empnoList }">
<select>
<option>---사원번호 선택---</option>
<c:forEach var="empno" items="${ empnoList }">
	<option value="${ empno }">${ empno }</option>
</c:forEach>
</select>
</c:if>

<% } //end else %>
</c:if>

</div>