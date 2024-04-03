<%@page import="kr.co.sist.domain.CpDeptDomain"%>
<%@page import="day1110.ExamDAO2"%>
<%@page import="day1109.ExamDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
<strong>컬럼 여러개에 행 하나 조회</strong>
</div>

<div>
<form action="index.jsp">
<input type="hidden" name="page" value="${ param.page }"/>
사원 번호 : <input type="text" name="empno" class="inputBox">
<input type="submit" value="조회" class="btn btn-info btn-sm"><br>
</form>
</div>

<div>
<c:if test="${ not empty param.empno }">
<%
int empno = Integer.parseInt(request.getParameter("empno"));
CpDeptDomain cdd = ExamDAO2.getInstance().mcsr(empno);
pageContext.setAttribute("cdd", cdd);

if(cdd == null){
	%>
	사원 번호를 확인해주세요.
	<%
}else {

%>
<%= empno %>번 사원의 사원명은 <%= cdd.getEmpName() %>이고, 부서번호는 <c:out value="${ cdd.deptno }"/>번 입니다.
<% } //end else %>
</c:if>

</div>