<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://192.168.10.136/mvc_prj/common/main/favicon.png"/>
<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- jQeury CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Vue.js CDN -->
<!-- 개발버전, 도움되는 콘솔 경고를 포함. -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<style type="text/css">


</style>

<script type="text/javascript">
$(function() {
	
	
});//ready
</script>
<script type="text/javascript">
/* ready */
window.onload = function(){
	new Vue({
		el: "#output",
		data: {
			msg : "오늘은 비오는 목요일! 안녕 Vue.js"
		}
	});
}

</script>

</head>
<body>

<div id="output">
	<strong>{{ msg }}</strong>
</div>

<!-- <script type="text/javascript">
new Vue({
	el: "#output",
	data: {
		msg : "오늘은 비오는 목요일! 안녕 Vue.js"
	}
});
</script> -->

</body>
</html>