<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.SQLException"%>
<%@page import="admin.vo.BoardManageVO"%>
<%@page import="admin.dao.BoardManageDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <c:catch var="se">
<%

int rcode = Integer.parseInt(request.getParameter("rcode"));

BoardManageDAO bmDAO = BoardManageDAO.getInstance();
bmDAO.deleteReview(rcode);
%>
<script>alert("삭제되었습니다."); location.href = "boardManagement.jsp";</script>
<%

%>
</c:catch>
<c:if test="${ not empty se }">
	<script> 
		alert("잠시 후 다시 시도해주세요.");
		location.href = "boardManagement.jsp";
	</script>
</c:if> --%>

<%

int rcode = Integer.parseInt(request.getParameter("rcode"));

BoardManageDAO bmDAO = BoardManageDAO.getInstance();
JSONObject jsonObj = new JSONObject();

try{
	jsonObj.put("result",bmDAO.deleteReview(rcode)==0?false:true);
}catch(SQLException se){
	se.printStackTrace();
}

out.print(jsonObj.toJSONString());
%>

