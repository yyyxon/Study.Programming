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
	$("#btn").click(function() {
			$.ajax({
				url : "create_json.do",
				type : "GET",
				dataType : "JSON",
				error: function(xhr){
					alert(xhr.status);
				},
				success: function(jsonObj){
					var output = "<table class='table'><tr><th>품번</th><th>제품명</th><th>가격</th></tr>";
					if(jsonObj.dataLength == 0){
						output += "<tr><td colspan='3'>제품이 없습니다.</td></tr>";
					}//end if
					
					$.each(jsonObj.data, function(i, jsonTemp){
						output += "<tr>";
						output += "<td>" + jsonTemp.prdNum + "</td>";
						output += "<td>" + jsonTemp.prdName + "</td>"; 
						output += "<td>" + jsonTemp.price + "</td>"; 
						output += "</tr>";
					});
					
					output += "</table>";
					
					$("#output").html(output);
					
				}
			});
	});//click
});//ready
</script>

</head>
<body>

<div>
	<input type="button" value="클릭" class="btn btn-info btn-sm" id="btn"/>
</div>
<div id="output"></div>

</body>
</html>