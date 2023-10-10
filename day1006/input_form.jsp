<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
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
	//유효성 검증
	$("#getBtn").click(function() {
		$("#getFrm").submit();
	});
	
	$("#pstBtn").click(function() {
		$("#pstFrm").submit();	
	});
});//ready
</script>

</head>
<body>
<!-- GET -->
<div style="border: 1px; width: 500px; padding: 10px">
<h2>GET방식</h2>
<form name="getFrm" id="getFrm" action="use_parameter.jsp">
<label>text</label>
<input type="text" name="text" class="inputBox" value="텍스트text"/><br>

<label>password</label>
<input type="password" name="pass" class="inputBox" value="패스워드pass"/><br>

<label>hidden</label>
<input type="hidden" name="hid" value="히든태그"/><br>

<!-- radio는 한 개만 선택되므로 배열이 아님 -->
<label>radio</label>
<input type="radio" name="gender" value="m"/>남자
<input type="radio" name="gender" checked="checked" value="f"/>여자<br>

<!-- checkbox는 한 개인 경우 배열로 처리되지 않는다. -->
<label>checkbox</label>
<input type="checkbox" name="check" value="save"/>저장<br>

<label>select</label>
<select name="sel">
<% for(int i=1; i<13; i++) {%>
	<option value="<%= i %>월"><%= i %>월</option>
<%} %>
</select><br>

<label>textarea</label><br>
<textarea style="width: 400px; height: 80px" class="inputBox" name="ta">
오늘은 금요일입니다.
</textarea><br>

<input type="button" value="GET요청" class="btn btn-success" id="getBtn"/>
</form>
</div>

<!-- POST -->
<div style="border: 1px; width: 500px; padding: 10px; margin-top: 20px">
<h2>POST방식</h2>
<form name="pstFrm" id="pstFrm" action="http://localhost/jsp_prj/day1010/use_parameter2.jsp" method="post">
<label>text</label>
<input type="text" name="text" class="inputBox"/><br>

<label>password</label>
<input type="password" name="pass" class="inputBox"/><br>

<label>hidden</label>
<input type="hidden" name="hid" value="히든태그"/><br>

<!-- radio는 한 개만 선택되므로 배열이 아님 -->
<label>radio</label>
<input type="radio" name="gender" value="m"/>남자
<input type="radio" name="gender" checked="checked" value="f"/>여자<br>

<!-- checkbox는 한 개인 경우 배열로 처리되지 않는다. -->
<label>checkbox</label>
<input type="checkbox" name="check" value="save" checked="checked"/>저장<br>

<label>select</label>
<select name="sel">
<% for(int i=1; i<13; i++) {%>
	<option value="<%= i %>월"><%= i %>월</option>
<%} %>
</select><br>

<label>textarea</label><br>
<textarea style="width: 400px; height: 80px" class="inputBox" name="ta">
오늘은 금요일입니다.
</textarea><br>

<input type="button" value="POST요청" class="btn btn-warning" id="pstBtn"/>
</form>
</div>

</body>
</html>