<%@page import="day1004.TestVO"%>
<%@page import="day1004.TestDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
td {
	text-align: center;
	font-weight: bold;
}

td:hover {
	background-color: #e6e6e6;
	cursor: pointer;
}

#numTitle {
	width: 80px;
}

#imgTitle {
	width: 120px;
}

#infoTitle {
	width: 400px;
}
</style>

<script type="text/javascript">
$(function() {
	
	
});//ready

function result(i, j){
	alert(i*j);
	let output = "<strong>" + i + " * " + j + " = " + i*j + "</strong>";
	$("#div").html(output);
}

</script>

</head>
<body>
<%
	//scriptlet : method 내의 java code 정의할 때 사용
	String msg = "다음주 월요일도 쉰다.^ㅇ^";
%>
<mark><%= msg %></mark>
<%-- 위 scriptlet에서 사용한 변수를 아래에서도 사용할 수 있다. -> 한 파일에 들어가므로 --%>
<%
	msg = "이번주는 이틀만 더...";
%>

<div>
<marquee scrollamount="20"><%= msg %></marquee>
</div>

<%
for(int i=1; i < 7; i++){
%>
<h<%= i %>>안녕하세요</h<%=i %>>
<%
}
%>

<!-- 1~100까지 옵션을 가지고 있는 select -->
<select>
	<% for(int i=1; i<101; i++) { %>
	<option><%= i %></option>
	<%} %>
</select>
<br>

<%

Calendar cal = Calendar.getInstance();
int nowYear = cal.get(Calendar.YEAR);
int nowMonth = cal.get(Calendar.MONTH)+1;
int lastDay = cal.getActualMaximum(Calendar.DATE)+1;

%>

<select>
	<option>---년---</option>
	<% for(int i=-2; i<3; i++) { %>
		<option<%= nowYear+i == 2023 ? " selected='selected'": "" %>>
		<%= nowYear+i %></option>
	<%} %>
</select>

<select>
	<option>---월---</option>
	<% for(int i=1; i<13; i++) { %>
		<option<%= i==nowMonth? " selected='selected'" : "" %>><%= i %></option>
	<%} %>
</select>

<select>
	<option>---일---</option>
	<% for(int i=1; i<lastDay; i++) { %>
		<option<%= i==cal.get(Calendar.DAY_OF_MONTH) ? " selected='selected'" : "" %>>
		<%= i %></option>
	<%} %>
</select>

<div style="width:800px">
<div id="div"></div>
	<table class="table table-bordered border-primary">
		<% for(int i=1; i<10; i++)  { %>
		<tr>
			<% for(int j=2; j<10; j++) { %>
				<td onclick="result(<%= i %>, <%= j %>)"><%=j + "x" + i%></td>
			<%} %>
		</tr>
		<%} %>
	</table>
</div>

<div style="width: 600px">
	<table class="table table-hover">
		<thead>
			<tr>
				<th id="numTitle">번호</th>
				<th id="imgTitle">이미지</th>
				<th id="infoTitle">설명</th>
			</tr>
		</thead>
		<tbody>
			<!-- selectURL() method를 호출하여 번호, 이미지, 설명
				이미지를 클릭하면 해당 site로 이동하도록 link 설정 -->
			<%
				TestDAO tDAO = new TestDAO();
				List<TestVO> list = tDAO.selectURL();
				TestVO tVO = null;
				for(int i = 0; i <list.size(); i++) {
					tVO = list.get(i);
			%>
			<tr>
				<td><%= i+1 %></td>
				<td><a href="http://<%= tVO.getUrl() %>">
				<img src="http://localhost/jsp_prj/common/images/<%= tVO.getImg() %>"
						 style="width:80px"/></a></td>
				<td><%= tVO.getInfo() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</div>

</body>
</html>