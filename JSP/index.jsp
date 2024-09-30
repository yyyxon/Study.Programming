<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://localhost/html_prj/common/main/favicon.png"/>
<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- jQeury CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">


</style>

<script type="text/javascript">
$(function() {
	
	
});//ready
</script>

</head>
<body>

<table class="table">
<tr>
<td><a href="index.jsp?page=day1109/scsr">컬럼 하나, 행 하나 조회</a></td>
<td><a href="index.jsp?page=day1110/mcsr">컬럼 여러개, 행 하나 조회</a></td>
<td><a href="index.jsp?page=day1110/scmr">컬럼 하나, 행 여러개 조회</a></td>
<td><a href="index.jsp?page=day1110/deptEmp">부서별 사원 번호 조회(연습문제)</a></td>
<td><a href="index.jsp?page=day1110/mcmr">컬럼 여러개 여러행 조회</a></td>
</tr>
<tr>
<td><a href="index.jsp?page=day1110/lessthan"> &lt; 사용하여 조회 </a></td>
<td><a href="index.jsp?page=day1110/greaterthan"> &gt; 사용하여 조회 </a></td>
<td colspan="3"><a href="index.jsp?page=day1110/like"> like 사용하여 조회 </a></td>
</tr>
<tr>
<td><a href="index.jsp?page=day1113/subquery">subquery의 조회</a></td>
<td><a href="index.jsp?page=day1113/union">union의 조회</a></td>
<td><a href="index.jsp?page=day1113/join">join의 조회</a></td>
<td><a href="index.jsp?page=day1113/subquery_join">subquery join의 조회</a></td>
<td><a href="index.jsp?page=day1113/dollar_sign">$ 조회</a></td>
</tr>
<tr>
<td><a href="index.jsp?page=day1114/dynamic_where">dynamic where</a></td>
<td><a href="index.jsp?page=day1114/dynamic_if">dynamic if</a></td>
<td><a href="index.jsp?page=day1114/dynamic_choose">dynamic choose</a></td>
<td colspan="2"><a href="index.jsp?page=day1114/dynamic_foreach">dynamic foreach</a></td>
</tr>
<tr>
<td colspan="5"><a href="day1115/member_list.jsp">dynamic set</a></td>
</tr>
<tr>
<td><a href="index.jsp?page=day1116/insert_proc">insert procedure</a>
<td><a href="index.jsp?page=day1116/select_proc">select procedure</a>
<td colspan="3"><a href="index.jsp?page=day1116/select_all_proc">select all procedure</a>
</tr>
</table>

<c:if test="${ not empty param.page }">
<jsp:include page="${ param.page }.jsp"/>
</c:if>

</body>
</html>