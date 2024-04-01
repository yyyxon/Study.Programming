<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="JSONArray"%>
<%
//warning 뜨는 이유 : Generic 안 써서
//JSON은 Generic 지원하지 않으므로 작성x

//1.JSONArray 생성 (List)
JSONArray jsonArr = new JSONArray();

//2.JSONObject 생성
JSONObject jsonObj = new JSONObject();
jsonObj.put("name","농담곰");
jsonObj.put("age",20);

JSONObject jsonObj2 = new JSONObject();
jsonObj2.put("name","담곰이");
jsonObj2.put("age",23);

JSONObject jsonObj3 = new JSONObject();
jsonObj3.put("name","담곰");
jsonObj3.put("age",6);

//3.JSONObject를 JSONArray에 할당
jsonArr.add(jsonObj);
jsonArr.add(jsonObj2);
jsonArr.add(jsonObj3);

%>

<%= jsonArr.toJSONString() %>