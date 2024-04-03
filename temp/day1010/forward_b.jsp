<%@page import="day1004.TestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="데이터를 받아서 보여주는 일"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getAttribute("name") %>님 어서오고</title>
<link rel="icon" href="http://192.168.10.136/html_prj/common/main/favicon.png"/>
<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- jQeury CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Carousel -->
<link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">


</style>

<script type="text/javascript">
$(function() {
	
	
});//ready
</script>

</head>
<body>
<%
	//request.setAttribute가 Object를 받으므로 해당 데이터 타입으로 캐스팅하여 사용함
	List<TestVO> list = (List<TestVO>)request.getAttribute("data");
%>


    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
      <div class="carousel-inner">
 		<% 
 		int i=0;
 		
 		for(TestVO tVO : list){ %>
        <div class="carousel-item <%= i==0 ? "active" : "" %>">
          <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" 
          width="800" height="400" xmlns="http://www.w3.org/2000/svg" role="img" 
          aria-label="Placeholder: Third slide" preserveAspectRatio="xMidYMid slice" 
          focusable="false"><title>Placeholder</title>
          <rect width="100%" height="100%" fill="#555"></rect>
          <text x="50%" y="50%" fill="#333" dy=".3em">
          <a href="<%= tVO.getUrl() %>"><%= tVO.getInfo() %></a></text></svg>
        </div>
        <%
        	i++;
        } %>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
</body>
</html>