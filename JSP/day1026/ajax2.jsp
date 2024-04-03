<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
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
	$("#btn").click(function() {
		//ajax 사용
		$.ajax({
			url: "html_response.html",
			type: "get",
			dataType: "html",
			error: function(xhr){
				alert("[" + xhr.status + "] 에러 발생");
			},
			success: function(data){
				//dataType 속성에 정의된 데이터형이 매개변수로 입력된다.	
				$("#resultDiv").html(data);
			}
		});//ajax
	});//click
	
	$("#btn2").click(function() {
		$.ajax({
			url: "text_response.txt",
			type: "get",
			dataType: "text",
			error: function(xhr){
				alert("[" + xhr.status + "] 문제 발생");
			},
			success: function(data){
				$("#resultDiv").html("<input type='text' value='div/"+data+"'/>");
				$("#msg").val("input/"+data);
			}
		});//ajax
	});//click
	
	$("#btn3").click(function() {
		$.ajax({
			url: "xml_response.xml",
			type: "get",
			dataType: "xml",
			error: function(xhr) {
				alert("[" + xhr.status + "] 문제 발생");
			},
			success: function(data){
				$("#msg").val($(data).find("msg").text());
			}
		});//ajax
	});//click
	
	$("#btn4").click(function() {
		$.ajax({
			url: "json_response.json",
			type: "get",
			dataType: "json",
			error: function(xhr) {
				console.log("[" + xhr.status + "] 문제 발생");
			},
			success: function(data) {
				$("#msg").val(data.msg);
			}
		});//ajax
	});//click
	
});//ready
</script>

</head>
<body>

<div>
	<input type="button" value="HTML요청" class="btn btn-success" id="btn"/>
	<input type="button" value="TEXT요청" class="btn btn-success" id="btn2"/>
	<input type="button" value="XML요청" class="btn btn-success" id="btn3"/>
	<input type="button" value="JSON요청" class="btn btn-success" id="btn4"/>
</div>
<br>
<div id="resultDiv"></div>
<input type="text" id="msg" name="msg"/>

</body>
</html>