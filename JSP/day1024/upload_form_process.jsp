<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%-- 
enctype = "multipart/form-data" 이므로 request 내장개게로 web parameter를 받을 수 없다.
<%= request.getParameter("uploader") %> 
--%>

<%
	try{
	//1.업로드될 파일이 저장된 폴더의 경로를 얻기
	File saveDir = new File("E:/dev/workspace/jsp_prj/src/main/webapp/upload");
	
	//2.파일의 최대 크기 설정(5MByte)
	int maxSize = 1024*1024*30;
	
	//3.파일 업로드 컴포넌트를 생성한다. (파일 업로드가 진행된다)
	MultipartRequest mr = new MultipartRequest(request,
											   saveDir.getAbsolutePath(),
											   maxSize,
											   "UTF-8",
											   new DefaultFileRenamePolicy());
	//4.파라미터 받기 (MultipartRequest 객체를 사용하여 파일 업로드를 받는다.)
	String uploader = mr.getParameter("uploader");
	String age = mr.getParameter("age");
	
	//5.업로드 파일명 받기 (<input type="file"/>)
	String originFile = mr.getOriginalFileName("upFile"); //파일 원래 이름
	String newFile = mr.getFilesystemName("upFile"); //파일 이름 중복시 부여되는 이름
	
	boolean flag = false;
	if(newFile != null){
		//업로드한 파일의 pull path 가져옴
		File tempFile = new File(saveDir.getAbsolutePath() + "/" + newFile);
		//업로드 용량 초과시 파일 삭제
		int limitSize = 1024*1024*5;
		if(tempFile.length() > limitSize) {
			tempFile.delete();
			flag = true;
		}//end if
	}
	
	if(!flag){
	%> 
	<strong>업로드 성공</strong><br>
	업로더 : <%= uploader %><br>
	나이 : <%= age %><br>
	파일명 : <%= newFile%> (<%= originFile %>)<br>
	
	<%} else { //업로드 실패시 %> 
	
	<%= originFile %>은 5Mbyte를 초과하였습니다. <br>
	5Mbyte이내의 파일만 업로드 가능합니다.<br>
	
	<%} %>
	<a href="javascript:history.back()">뒤로</a>
	
	<%
	}catch(IOException ie){
		ie.printStackTrace();
		out.println("파일 업로드 처리 중 문제 발생");
	}
%>
</body>
</html>