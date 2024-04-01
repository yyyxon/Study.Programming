<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="day1017.CpDeptVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="DBCP 사용"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://192.168.10.136/html_prj/common/main/favicon.png"/>
<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- jQeury CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">


</style>

<script type="text/javascript">
$(function() {
	
	
});//ready

function updateDept(deptno){
	confirm(deptno + "번 부서 정보를 수정하시겠습니까?");
}

</script>

</head>
<body>
<c:catch var="e">
<%
//1.JNDI 사용객체 생성
//serverl.xml에 DBCP가 설정되어있으므로 드라이버 로딩하지 않아도 됨
Context ctx = new InitialContext();

//2.JNDI 객체를 사용하여 DBCP에 DataSource 얻기
//java:comp/env/+jdbc/이름 -> 이름은 server.xml에 설정한 resource 이름
DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbcp");

//3.Connection 얻기
Connection con = ds.getConnection();

//4.쿼리문 수행객체 얻기
PreparedStatement pstmt = con.prepareStatement("select * from dept");

//5.바인드 변수에 값 할당

//6.쿼리문 수행 후 결과 얻기
ResultSet rs = pstmt.executeQuery();
CpDeptVO cdVO = null;

List<CpDeptVO> list = new ArrayList<CpDeptVO>();
while(rs.next()){
	cdVO = new CpDeptVO(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
	list.add(cdVO);
}

pageContext.setAttribute("deptList", list);
%>
DataSource : <%= ds %> <br>
Connection : <%= con %>
<%
rs.close();
pstmt.close();
con.close();
%>

<table class="table">
<thead>
	<tr>
		<th>번호</th>
		<th>부서번호</th>
		<th>부서명</th>
		<th>위치</th>
	</tr>
</thead>
<tbody>
	<c:if test="${ empty deptList }">
		<tr>
			<td colspan="4">부서정보가 존재하지 않습니다.</td>
		</tr>
	</c:if>
	
	<c:forEach var="dept" items="${ deptList }" varStatus="i">
		<tr>
			<td><c:out value="${ i.count }"/></td>
			<td><c:out value="${ dept.deptno }"/></td>
			<td><c:out value="${ dept.dname }"/></td>
			<td><c:out value="${ dept.loc }"/></td>
			<td><input type="button" value="수정" class="btn btn-success"
				onclick="updateDept('${ dept.deptno }')"/>
		</tr>
	</c:forEach>
</tbody>

</table>


</c:catch>
<c:if test="${ not empty e }">
	<c:out value="${ e }"/>
</c:if>
</body>
</html>