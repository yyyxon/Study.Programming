<%@page import="java.util.List"%>
<%@page import="kr.co.sist.domain.CpDeptDomain"%>
<%@page import="day1110.ExamDAO2"%>
<%@page import="day1109.ExamDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<strong>컬럼 하나에 행 여러개 조회</strong>
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
List<String> enameList = ExamDAO2.getInstance().scmr(deptno);
pageContext.setAttribute("enameList", enameList);

if(enameList == null){
	%>
	부서 번호 입력이 잘못되었습니다.
	<%
}else {

%>
<c:if test="${ empty enameList }">
<c:out value="${ param.deptno }"/>번 부서는 사원이 존재하지 않습니다.
</c:if>

<c:if test="${ not empty enameList }">
<%= deptno %>번 부서의 사원은
<c:forEach var="ename" items="${ enameList }">
	<c:out value="${ ename }"/>
</c:forEach>
으로 총 <%= enameList.size() %>명 입니다.
</c:if>

<% } //end else %>
</c:if>

</div>