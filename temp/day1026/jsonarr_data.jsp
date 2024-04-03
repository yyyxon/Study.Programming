<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

JSONObject jsonObj = new JSONObject();
jsonObj.put("name","흰둥이");
jsonObj.put("age","15");
jsonObj.put("addr","서울시 강남구 역삼동");

JSONObject jsonObj2 = new JSONObject();
jsonObj2.put("name","짱구");
jsonObj2.put("age","5");
jsonObj2.put("addr","인천시 부평구 부평동");

JSONObject jsonObj3 = new JSONObject();
jsonObj3.put("name","자두");
jsonObj3.put("age","10");
jsonObj3.put("addr","서울시 강서구 화곡동");

JSONArray jsonArr = new JSONArray();
jsonArr.add(jsonObj);
jsonArr.add(jsonObj2);
jsonArr.add(jsonObj3);

out.print(jsonArr.toJSONString());
%>