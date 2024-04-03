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

<style type="text/css">


</style>

<script type="text/javascript">
$(function() {
	
	
});//ready
</script>

</head>
<body>
<c:out value="${ requestScope.uploader }"/>님께서 업로드한
<strong><c:out value="${ requestScope.fileName }"/></strong> 
<c:choose>
<c:when test="${ requestScope.fileResultFlag }">
파일이 성공적으로 업로드 되었습니다.<br>
<img src="http://localhost/mvc_prj/common/images/damgom.jpg"/>
</c:when>
<c:otherwise>
파일의 크기가 <c:out value="${ requestScope.fileSize }"/>이므로 10MByte를 초과하여
업로드에 실패하였습니다.
</c:otherwise>
</c:choose>

</body>
</html>