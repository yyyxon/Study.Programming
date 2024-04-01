<%@page import="java.util.List"%>
<%@page import="org.jdom2.Element"%>
<%@page import="java.io.File"%>
<%@page import="org.jdom2.Document"%>
<%@page import="org.jdom2.input.SAXBuilder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="XML Parsing"%>
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
<table class="table">
<c:catch var="e">
<%
	//1.Builder 생성
	SAXBuilder sb = new SAXBuilder();
	
	//2.XML 문서에 접근하여 객체로 얻기
	Document doc = sb.build(new File("E:/dev/workspace/jsp_prj/src/main/webapp/xml1101/data.xml"));
	
	//3.최상위 부모 노드 얻기
	Element msgsNode = doc.getRootElement();
	
	//4.자식 노드들 얻기
	List<Element> someNodes = msgsNode.getChildren("msg");
	
	//5.자식 노드를 반복
	for(Element someNode : someNodes){
	//6.Parsing
	//if("msg".equals(someNode.getName())){	
%>
	<tr>
	<td><%= someNode.getName() %> / <%= someNode.getText() %>
	</td>
	</tr>
	<%
		//}
	}
%>

</c:catch>
<c:if test="${ not empty e }">
<tr>
	<td>문제발생 ${ e }</td>
</tr>
</c:if>

</table>
</body>
</html>