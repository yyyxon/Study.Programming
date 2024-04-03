<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.member.vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.member.dao.BoardDAO2"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String paramNum = request.getParameter("num");
JSONObject jsonObj = new JSONObject();
jsonObj.put("result",false); //if를 타지 않으면 false

if(paramNum != null){
	int num = Integer.parseInt(paramNum);
	
	BoardDAO2 bDAO = BoardDAO2.getInstance();
	
	try{
		List<ReplyVO> list = bDAO.selectReplyList(num);
		
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonTemp = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		for(ReplyVO rVO : list){//조회 결과를 사용하여 반복
			jsonTemp = new JSONObject(); //조회 결과를 서브 JSONObject에 저장
			jsonTemp.put("num",rVO.getNum());
			jsonTemp.put("content",rVO.getContent());
			jsonTemp.put("writer", rVO.getWriter());
			jsonTemp.put("reply_num",rVO.getReply_num());
			jsonTemp.put("input_date", sdf.format(rVO.getInput_date()));
			
			//JSONObject를 JSONArray에 저장
			jsonArr.add(jsonTemp);
		}//end for
		
		//모든 데이터를 가진 JSONArray를 메인 JSONObject에 저장
		jsonObj.put("data",jsonArr);
		jsonObj.put("dataSzie",jsonArr.size());
		jsonObj.put("dataEmpty",list.isEmpty());
		jsonObj.put("result",true);
		
	}catch(SQLException se){
		se.printStackTrace();
	}//end catch
}//end if

out.print(jsonObj.toJSONString());


%>