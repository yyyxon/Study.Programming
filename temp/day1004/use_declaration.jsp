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
	//scriptlet은 _jspService method안에 코드가 생성되므로 method를 정의할 수 없다.
	/* 
	public void test() {
	
	} 
	*/
%>

<%! //method를 정의할 때는 <%! 
	//class field에 코드가 생성된다.
	int i; //instance 변수 
		   //접속자가 요청을 하면 객체가 생성되므로, 개발자는 객체화를 하지 않고 사용하면된다.
	
	public void test() {
		System.out.println("하이루");
	}
	
	public String getMsg() {
		String msg = "오늘 지하 식당 점심은 맛이 없었어";
		return msg;
	}
%>

<% 
	test();
	int j = 0; //지역변수, 초기화하지 않고 사용하면 error
%>

인스턴스 변수 : <%= i %> <br>
지역 변수 : <%= j %>
<%= getMsg() %> <br>

<%
	String[] names = {"김주민","김선경","박상준","홍찬영","홍지성"};
%>

<%!
public String createRadio(int cnt, int nameInd, int checkedInd) {
	StringBuilder radio = new StringBuilder();
	for(int i=0; i<cnt+1; i++) {
		radio.append("<input type='radio' name='score").append(nameInd).append("'")
		.append("value='").append(i).append("'").append(i == checkedInd? " checked='checked'":"")
		.append("/>").append(i).append("\n");
	}
	return radio.toString();
}
%>

<table class="table table-hover">
	<tr>
		<th>이름</th>
		<th>점수</th>
	</tr>
	<%for(int i=0; i<names.length; i++) {%>
	<tr>
		<td> <%= names[i] %></td>
		<td>
			<%= createRadio(10, i, 0) %> 
<%-- 		<%for(int k=0; k<11; k++) {%>
				<input type="radio" name="score<%= i %>" value="<%= k %>"/><%= k%>
			<%} %> --%>
		</td>
	</tr>
	<%} %>
</table>

</body>
</html>