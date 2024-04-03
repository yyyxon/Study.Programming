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


</style>

<script type="text/javascript">
$(function() {
	
	
});//ready
</script>

</head>
<body>
<%
Object o = session.getAttribute("num");
int num = 0;
if(o !=null){
	num = Integer.parseInt(o.toString());
	num++;
}//end if
session.setAttribute("num",num);
%>
<div style="margin-top: 50px">
<button type="button" class="btn btn-primary position-relative">
요청방식: <%=request.getMethod() %>
  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
    ${ num }+
    <span class="visually-hidden">요청방식</span>
  </span>
</button>
</div>

</body>
</html>