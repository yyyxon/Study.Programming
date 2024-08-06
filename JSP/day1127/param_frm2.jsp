<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://localhost/mvc_prj/common/main/favicon.png"/>
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

<form name="frm" id="frm" action="use_request_param.do">
이름 <input type="text" name="name" class="inputBox"/> <br>
나이 <input type="text" name="age" class="inputBox"/> <br>
취미 <input type="checkbox" name="hobby" value="독서" class="inputBox"/>독서
<input type="checkbox" name="hobby" value="게임" class="inputBox"/>게임 
<input type="checkbox" name="hobby" value="운동" class="inputBox"/>운동 
<input type="checkbox" name="hobby" value="음주" class="inputBox"/>음주 <br>
<input type="submit" value="전송" class="btn btn-info btn-sm"/>
</form>

</body>
</html>