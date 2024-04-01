<%@page import="java.net.URL"%>
<%@page import="org.jdom2.Attribute"%>
<%@page import="java.util.List"%>
<%@page import="org.jdom2.Element"%>
<%@page import="java.io.File"%>
<%@page import="org.jdom2.Document"%>
<%@page import="org.jdom2.input.SAXBuilder"%>
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
<table class="table">
<thead>
	<tr>
		<th>번호</th>
		<th>성별</th>
		<th>나이</th>
		<th>이름</th>
	</tr>
</thead>

<tbody>
<c:catch var="e">
<%
	//1.Builder 생성
	SAXBuilder sb = new SAXBuilder();
	
	//2.문서 객체 얻기
	Document doc = sb.build(new URL("http://localhost/jsp_prj/xml1101/attr.xml"));
	
	//3.최상위 부모 노드 얻기
	Element rootNode = doc.getRootElement();
	
	//4.자식 노드들 얻기
	List<Element> personNodes = rootNode.getChildren("person");
	
	//5.반복 parsing
	Element personNode = null;
	Element nameNode = null;
	Attribute ageAttr = null;
	String gender = "";
	String lastName = "";
	String firstName = "";
	
	for(int i = 0; i<personNodes.size(); i++){
		personNode = personNodes.get(i);
		
		gender = personNode.getAttributeValue("gender");
		ageAttr = personNode.getAttribute("age");
		
		//lastName 속성은 person 노드의 자식 노드인 name 노드가 가지고 있음
		nameNode = personNode.getChild("name");
		lastName = nameNode.getAttributeValue("lastName");
		firstName = nameNode.getText();
	%>
			<tr>
				<td><%= i+1 %></td>
				<td><%= gender %></td>
				<td><%= ageAttr.getValue() %></td>
				<td><%= lastName %>/<%= firstName %></td>
			</tr>
	<%
	}

%>
</c:catch>
<c:if test="${ not empty e }">
<tr>
	<td colspan="4">문제 발생</td>
</tr>
</c:if>
</tbody>
</table>

</body>
</html>