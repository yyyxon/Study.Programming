<%@page import="day1013.TestUseBeanVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="usebean 액션 태그 사용"%>
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
<!-- useBean은 클래스를 객체화한다. -->
<jsp:useBean id="tubVO" class="day1013.TestUseBeanVO" scope="page"/>
<!-- 생성된 객체에 값을 설정 -->
<!-- property - method명(소문자로) / name - 객체명 -->
<jsp:setProperty name="tubVO" property="name" value="농담곰"/>
<jsp:setProperty name="tubVO" property="age" value="12"/>
<!-- 객체에 저장된 값을 확인 -->
이름 : <jsp:getProperty name="tubVO" property="name"/> <br>
나이 : <jsp:getProperty name="tubVO" property="age"/> <br>

<!-- 아래의 scriptlet을 사용한 것과 같다. -->
<%
	TestUseBeanVO tVO = new TestUseBeanVO();
	tVO.setName("농담곰2");
	tVO.setAge(15);
%>

이름 : <%= tVO.getName() %> <br>
나이 : <%= tVO.getAge() %> <br>

<!-- useBean액션 태그의 id는 객체명이고 scriptlet에서 객체로 사용할 수 있다. -->
<%
tubVO.setName("테스트");
tubVO.setAge(30);
%>

이름 : <%= tubVO.getName() %> <br>
나이 : <%= tubVO.getAge() %> <br>



</body>
</html>