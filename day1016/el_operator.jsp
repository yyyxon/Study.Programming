<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="EL에서 제공하는 연산자 사용"
		 isELIgnored="false"
%> <!-- EL은 보안에 취약하므로 EL을 사용하지 않는 페이지에서는 true로 하는 것이 좋다. -->
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

<strong>산술 연산자</strong> <br>
10+16 = ${ 10+16 } <br>
10%2 = ${ 10%2 } (${10 mod 2})<br> <!-- % : mod -->

<strong>관계 연산자</strong> <br>
10 > 2 = ${ 10>2 } (${10 gt 2 })<br> <!-- > : gt -->
10 &lt; 2 = ${ 10<2 } (${10 lt 2 })<br> <!-- < : lt -->
10 >= 2 = ${ 10>=2 } (${10 ge 2 })<br> <!-- >= : ge -->
10 &lt;= 2 = ${ 10<=2 } (${10 le 2 })<br> <!-- <= : le -->
10 == 2 = ${ 10==2 } (${10 eq 2 })<br> <!-- == : eq -->
10 != 2 = ${ 10!=2 } <%-- (${10 ne 2 }) --%><br> <!-- != : ne -->

<strong>논리 연산자</strong> <br>
10 > 5 &amp;&amp; 5 &lt; 10 = ${10>5 && 5<10} (${10 gt 5 and 5 lt 10})<br>
10 > 5 || 5 > 10 = ${10>5 || 5>10} (${10 gt 5 or 5 gt 10})<br>

<strong>삼항 연산자</strong> <br>
10 = ${10%2 == 0 ? "짝수" : "홀수"} <br> <!-- EL은 문자가 없으므로 문자열을 ", '로 표현할 수 있다. -->
10 = ${10%2 == 0 ? '짝수' : '홀수'} <br> <!-- EL은 문자가 없으므로 문자열을 ", '로 표현할 수 있다. -->
10 = ${10 mod 2 eq 0 ? '짝수' : '홀수'} <br>

<strong>null은 출력하지 않는다.</strong> <br>
EL parameter : [ ${ param.name } ] <br>
request 내장객체 : [ <%= request.getParameter("name") %> ] <br>

<strong>empty 비교할 때 사용</strong> <br>
[ ${ empty param.name } ] <br> <!-- null이거나 비었으면 true -->
[ ${ empty param.name ? "아래의 링크를 클릭해주세요." : param.name} ] <br> <!-- null이거나 비었으면 true -->

<br>
<!-- 현재 페이지에 파라미터명이 name이면서 값이 tk로 query string을 가진 URL을 href에 작성 -->
<a href="http://192.168.10.136/jsp_prj/day1016/el_operator.jsp?name=tk">name 요청</a> 
<a href="http://192.168.10.136/jsp_prj/day1016/el_operator.jsp">그냥 요청</a> 


</body>
</html>