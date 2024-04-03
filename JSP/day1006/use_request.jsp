<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="request 내장 객체의 사용"%>
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
	$("#btnGet").click(function() {
		$("#getFrm").submit();
	});
	
	$("#btnPost").click(function() {
		$("#postFrm").submit();
	});
});//ready
</script>

</head>
<body>
<%
	String[] blockIp={"133","139","146","143","149"};
	String connectIp = request.getRemoteAddr();
	boolean flag = false;
	for(int i=0; i<blockIp.length; i++){
		if(connectIp.endsWith(blockIp[i])){
			flag=true;
			break;
		}//end if
	}//end for
	
	if(flag){
		response.sendRedirect("https://www.police.go.kr/index.do");
		return;
	}
%>

<h2>request 내장 객체 사용</h2>
<ul class="list-group">
  <li class="list-group-item">요청 방식 : <%= request.getMethod() %></li>
   <li class="list-group-item">요청 URL : <%= request.getRequestURL() %></li>
   <li class="list-group-item">요청 protocol : <%= request.getProtocol() %></li>
   <li class="list-group-item">요청 서버명 : <%= request.getServerName() %></li>
   <li class="list-group-item">요청 서버포트 : <%= request.getServerPort() %></li>
   <li class="list-group-item">요청 URI : <%= request.getRequestURI() %></li>
   <li class="list-group-item">요청 파일(자원)경로 얻기 : <%= request.getServletPath() %></li>
   <li class="list-group-item">접속자의 IP : <%= request.getRemoteAddr() %></li>
   <li class="list-group-item">접속자의 포트 : <%= request.getRemotePort() %></li>
   <li class="list-group-item">Query String : <%= request.getQueryString() %></li>
   <li class="list-group-item">web parameter : 이름이 유일한 <%= request.getParameter("name") %></li>
   <li class="list-group-item">web parameter : 이름이 중복된 
   <% 
   //이름이 같다면 배열로 처리한다.
   String[] age = request.getParameterValues("age");
   //이름이 없는 경우 NullPointerException이 발생
   if(age!=null){
   		for(int i=0; i<age.length; i++){
   %>
   <%= age[i] %>&nbsp;
   <%
   		}
   }
   %>   
</ul>

<!-- 현재 페이지를 요청하고 싶다면 페이지명 도는 action 속성을 empty인 상태로 작성 -->
<form method="get" action="" id="getFrm">
	<input type="hidden" name="name" value="jiseong.hong"/>
	<input type="hidden" name="age" value="25"/>
	<input type="button" value="GET방식 요청" class="btn btn-dark" id="btnGet"/>
</form>

<form method="post" action="" id="postFrm">
	<input type="hidden" name="name" value="jiseong.hong"/>
	<input type="hidden" name="age" value="25"/>
	<input type="button" value="POST방식 요청" class="btn btn-warning" id="btnPost"/>
</form>
	
<!-- <a>태그를 사용하여 name이 kim 나이가 26인 값을 use_request.jsp에 요청하는 URL을 만들어보세요. -->	
<a href="http://192.168.10.136/jsp_prj/day1006/use_request.jsp?name=kim&age=26&age=30">링크</a>
</body>
</html>