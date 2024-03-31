<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test jsp</title>
</head>
<body>
나는 jsp! 요청하면 html로 변경되어 응답하지 <br>
요청을 받고 jsp를 찾아서 java source code로 변경한 후 
컴파일 해서 HTML로 변환하고 클라이언트에게 응답해주는 프로그램을 WAS라고 해 <br>
<marquee>${ param.name }님 안녕하세요?</marquee>
readonly 주소1 : ${ param.addr1 } <br>
disabled 주소2 : ${ param.addr2 }
</body>
</html>