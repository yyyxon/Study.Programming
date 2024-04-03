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
			url: "msg1.jsp",
			type: "GET",
			async: "true", //비동기
			dataType: "text",
			error: function(xhr){ //callback function
				alert("서버에서 문제가 발생하였습니다." + xhr.status + " / " + xhr.statusText);
			},
			success: function(data){
				$("#msgDiv").html("<marquee>"+data+"</marquee>");
			}
		});
	});
	
});//ready
</script>

</head>
<body>

<div>
	<input type="button" value="클릭" class="btn btn-success" id="btn"/>
</div>

<div id="msgDiv"></div>

</body>
</html>