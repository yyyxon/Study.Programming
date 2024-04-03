<%@page import="org.jdom2.output.Format"%>
<%@page import="org.jdom2.output.XMLOutputter"%>
<%@page import="java.util.Random"%>
<%@page import="org.jdom2.Element"%>
<%@page import="org.jdom2.Document"%>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="랜덤 인사를 응답하는 XML" trimDirectiveWhitespaces="true"%>
<%

String[] msgArr = {"안녕하세요?","기분 조은 하루 되세요","오늘은 당신의 날이에용^.^b I am 신뢰예요","삽.피곤"};

String name = request.getParameter("name");

//JDOM2 Parser를 사용한 XML 생성
Document doc = new Document();

Element rootNode = new Element("root"); //<root/>
Element msgNode = new Element("msg"); //<msg/>

msgNode.setText(name+"님 " + msgArr[new Random().nextInt(msgArr.length)]); //<msg>하이</msg>

rootNode.addContent(msgNode); //<root><msg>하이</msg></root>
doc.setRootElement(rootNode); //<?xml version..><root><msg>하이</msg></root>

XMLOutputter xOut = new XMLOutputter(Format.getPrettyFormat());
xOut.output(doc, out);

%>