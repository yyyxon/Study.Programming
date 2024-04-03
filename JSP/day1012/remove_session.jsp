<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="세션의 값을 삭제"%>
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
</script>

</head>
<body>
<%
//세션의 값 삭제(브라우저에 할당된 세션(키)은 살아있고 세션 안의 값만 삭제)
//invalidate = 세션 자체를 삭제, remove = 세션의 값 삭제
session.removeAttribute("name");
session.invalidate(); //브라우저에 할당된 세션 자체가 무효화된다. -> 값 얻기 불가

%>

<%-- 
remove한 후에는 값을 얻는 행동을 할 수 있지만(세션은 있지만 값이 없음 - null) 
invalidate된 이후에는 값을 얻는 행동을 할 수 없다.(세션 자체가 없음)
삭제된 이후의 값 : <%= session.getAttribute("name") %>
<%= session.getAttribute("age") %> 
--%>
세션 값이 삭제되었습니다. <br>
<a href="set_session.jsp"><input type="button" value="값 설정" class="btn btn-outline-success"></a>
<a href="get_session.jsp"><input type="button" value="값 얻기" class="btn btn-outline-primary"></a>
</body>
</html>