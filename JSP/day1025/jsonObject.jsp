<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="JSONObject를 생성하는 외부 library 사용"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

String name = "농담곰";
int age = 20;
String addr = "서울시 강남구 역삼동 한독약품빌딩 8층";

//1.JSONObject 생성
JSONObject jsonObj = new JSONObject();

//2.값 할당 (값은 순서대로 들어가지 않는다.)
jsonObj.put("name",name);
jsonObj.put("age", age);
jsonObj.put("addr",addr);

//같은 이름이 입력되면 이전의 값을 덮어쓴다.
jsonObj.put("addr","경기도 수원시 팔달구 영통동");

%>

<%= jsonObj.toJSONString() %>