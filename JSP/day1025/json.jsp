<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

String name = "농담곰";
int age = 10;
String addr = "서울시 강남구";

%>

{ "name" : "<%= name %>", "age" : <%= age %>, "addr" : "<%= addr %>" }