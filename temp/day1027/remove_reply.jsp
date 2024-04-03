<%@page import="kr.co.sist.member.dao.BoardDAO2"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="리플 삭제"%>
<%

String num = request.getParameter("num");
JSONObject json = new JSONObject();
json.put("deleteFlag",false);

if(num!=null){
	BoardDAO2 bDAO = BoardDAO2.getInstance();
	json.put("deleteFlag",bDAO.deleteReply(Integer.parseInt(num))==1);
}
out.print(json.toJSONString());
%>