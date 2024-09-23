<%@page import="day1109.ExamDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<strong>컬럼 하나에 행 하나 조회</strong>
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
String dname = ExamDAO.getInstance().scsr(deptno);

if(dname == null || "".equals("dname")){
	%>
	부서번호를 확인해주세요.
	<%
}else {

%>
<%= deptno %>번 부서의 부서명은 <%= dname %> 입니다.
<% } //end else %>
</c:if>

</div>