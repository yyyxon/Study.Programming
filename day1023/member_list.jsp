<%@page import="kr.co.sist.util.BoardUtil"%>
<%@page import="kr.co.sist.member.vo.BoardUtilVO"%>
<%@page import="kr.co.sist.util.cipher.DataDecrypt"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.member.vo.WebMemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.member.vo.BoardRangeVO"%>
<%@page import="kr.co.sist.member.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${ empty sesId }">
	<!-- 로그인 하지 않았으면 로그인창으로 보냄 -->
	<c:redirect url="login_frm.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지네이션</title>
<link rel="icon" href="http://192.168.10.136/html_prj/common/main/favicon.png"/>
<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- jQeury CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">

</style>

<script type="text/javascript">
$(function() {
	$("#btn").click(function() {
		$("#frm").submit();
	});
	
	$("#btnSearch").click(function() {
		chkNull();
	});//click
	
	$("#keyword").keyup(function(evt) {
		if(evt.which == 13){
			chkNull();
		}//end if
	});//keyup
	
});//ready

function memberDetail(id){
	$("#id").val(id);
	$("#hidFrm").submit();
}

function chkNull() {
	var keyword = $("#keyword").val();
	if(keyword.trim() == ""){
		alert("검색 키워드를 입력해주세요.");
		return;
	}//end if
	
	//글자 수 제한
	
	//모두 통과했으면 submit
	$("#frmSearch").submit();
}

</script>

</head>
<body>

<%
	BoardDAO bDAO = BoardDAO.getInstance();
	BoardRangeVO brVO = new BoardRangeVO();
	String field = request.getParameter("field");
	String keyword = request.getParameter("keyword");
	
	/* 페이지가 최초 호출 시에는 field나 keyword가 없다. 
	검색을 하지 않는 경우에도 값이 없다. */
	brVO.setField(field);
	brVO.setKeyword(keyword);
	
	//1.총 레코드의 수 
	int totalCount = bDAO.totalCount(brVO);
	
	//2.한 화면에 보여줄 게시물의 수
	int pageScale = 10;
	
	//3.총 페이지 수
	int totalPage = totalCount/pageScale;
	
	//총 레코드 수 나누기 한 화면에 보여줄 게시물의 수를 했을 때
	//나머지가 있다면(0이 아니라면) 한 화면에 보여줄 게시물의 수를 초과한 것이므로
	//총 페이지 수를 하나 늘림
/* 	if(totalCount % pageScale != 0){
		totalPage++;	
	} */

	//Math 사용 - 올림
	totalPage = (int)Math.ceil(totalCount/(double)pageScale);
	
	//4.현재 페이지 번호 구하기
	String tempPage = request.getParameter("currentPage");
	int currentPage = 1; //최초 페이지는 1번째 페이지가 보임
	if(tempPage != null){
		currentPage = Integer.parseInt(tempPage);
	}//end if
	
	//5.시작 번호
	int startNum = currentPage*pageScale-pageScale+1;
	pageContext.setAttribute("startNum", startNum);
	
	//6.끝 번호
	int endNum = startNum+pageScale-1;
	
	//Dynamic Query에 의해서 구해진 시작번호와 끝번호를 VO에 넣는다.
	brVO.setStartNum(startNum);
	brVO.setEndNum(endNum);
%>

총 레코드의 수 <%= totalCount %> <br>
한 화면에 보여줄 게시물의 수 : <%= pageScale %>건 <br>
총 페이지 수 : <%= totalPage %>장 <br>
현재 페이지 번호 : <%= currentPage %> <br>
시작 번호 : <%= startNum %> <br>
끝 번호 : <%= endNum %> <br>

<%
			try{
				List<WebMemberVO> list = bDAO.selectMember(brVO);
				//관리자 : hello - 권한 있음 / haha - 권한 없음
				String id = (String)session.getAttribute("sesId");
				
				if("1".equals(request.getParameter("dataFlag"))){
					if("hello".equals(id)){
						DataDecrypt dd = new DataDecrypt("a12345678901234567");
						
						for(int i=0; i<list.size(); i++){
							list.get(i).setName(dd.decryption(list.get(i).getName()));
							list.get(i).setCell(dd.decryption(list.get(i).getCell()));
							list.get(i).setEmail(dd.decryption(list.get(i).getEmail()));
						}//end for
					
					}//end if
				
					if("haha".equals(id)){
				%>
						<script type="text/javascript">
							alert("해당 계정은 권한이 없습니다.")
						</script>
				<%
					}//end if
				}//end if
				
				pageContext.setAttribute("memberList", list);
			}catch(SQLException se){
				se.printStackTrace();
			}
%>

<div>
	<form method="post" id="frm">
		<input type="button" value="데이터 보기" class="btn btn-dark" id="btn"/>
		<input type="hidden" name="dataFlag" value="1"/>
	</form>
	
	<form method="post" id="hidFrm" action="../day1020/member_detail.jsp">
		<input type="hidden" name="id" id="id"/>
	</form>
	
	<a href="member_list.jsp?dataFlag=1" class="btn btn-warning">전체보기</a>
	
	<table class="table">
		<thead>
			<tr>
				<th style="width: 80px">번호</th>
				<th style="width: 150px">아이디</th>
				<th style="width: 150px">이름</th>
				<th style="width: 120px">생년월일</th>
				<th style="width: 180px">전화번호</th>
				<th style="width: 300px">이메일</th>
				<th style="width: 80px">성별</th>
				<th style="width: 180px">가입일</th>
			</tr>
		</thead>
		
		<tbody>
			<!-- list가 존재하지 않을 경우 -->
			<c:if test="${ empty memberList }">
				<tr>
					<td colspan="8" style="text-align: center;"> 
						회원정보가 존재하지 않습니다. </td>
				</tr>
			</c:if>
			
			<!-- list가 존재하는 경우 -->
			<c:forEach var="member" items="${ memberList }" varStatus="i">
				<tr>
					<td><c:out value="${ startNum + i.index }"/></td>
					<td><c:out value="${ member.id }"/></td>
					<td><a href="#void" onclick="memberDetail('${ member.id }')"><c:out value="${ member.name }"/></a></td>
					<td><c:out value="${ member.birthday }"/></td>
					<td><c:out value="${ member.cell }"/></td>
					<td><c:out value="${ member.email }"/></td>
					<td><c:out value="${ member.gender eq 1 ? '남자' : '여자' }"/></td>
					<td><fmt:formatDate value="${ member.inputDate }" pattern="yyyy-MM-dd HH:mm"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<!-- 검색 -->
<div style="text-align: center">
<form name="frmSearch" id="frmSearch" action="member_list.jsp" method="GET">
<select name="field" class="inputBox">
	<option value="1" ${ param.field eq '1' ? " selected='selected'" : "" }>아이디</option>
	<option value="2" ${ param.field eq '2' ? " selected='selected'" : "" }>주소</option>
	<option value="3" ${ param.field eq '3' ? " selected='selected'" : "" }>소개</option>
</select>
<!-- 웹브라우저에서 text form control이 하나일 땐 엔터치면 submit이 됨 -->
<input type="text" name="keyword" id="keyword" class="inputBox" value="${ param.keyword ne 'null' ? param.keyword : '' }"/>
<input type="text" style="display:none"/>
<input type="hidden" name="dataFlag" value="1"/>
<input type="button" value="검색" id="btnSearch" class="btn btn-info"/>
</form>
</div>

<br>
<%-- <%
	for(int i=1; i<totalPage+1; i++){%>
		[<a href="member_list.jsp?currentPage=<%= i %>&dataFlag=1&keyword=${ param.keyword }&field=${ param.field }"><%= i %></a>]
	<%
	}
%> --%>

<%
String dataFlag = request.getParameter("dataFlag");
BoardUtilVO buVO = new BoardUtilVO("member_list.jsp",dataFlag,keyword,field,currentPage,totalPage);
out.println(BoardUtil.getInstance().pageNation(buVO));
%>



</body>
</html>