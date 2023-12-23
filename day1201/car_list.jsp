<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="ajax_frm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://192.168.10.136/mvc_prj/common/main/favicon.png">
<!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<style type="text/css">

</style>
<script type="text/javascript">
$(function(){
   $("#country").change(function(){
      var sel=$("#country")[0];
      if(sel.selectedIndex == 0){
         return;
      }//end if
      var param={ country : $("#country").val() };
      
      $.ajax({
         url:"search_maker.do", 
         type: "post",
         data:param,
         dataType: "json",
         error:function(xhr){
            alert( xhr.status );   
         },//error
         success:function( jsonObj ){
            var selMaker = $("#maker")[0];
            if(jsonObj.dataSize = 0){
            	alert("제조국에 대한 정보가 없습니다.");
            	return;
            }//end if
            
            selMaker.length = 1; //옵션을 하나만 남겨둠
            $.each(jsonObj.data, function(i, jsonMaker){
            										//value 값,       보여줄 값
            	selMaker.options[i+1] = new Option(jsonMaker.maker, jsonMaker.maker);
            });
         }//success
         
      });//ajax
   });//click.btn
   
   $("#maker").change(function(){
      var sel=$("#maker")[0];
      if(sel.selectedIndex == 0){
         return;
      }//end if
      var param={ maker : $("#maker").val() };
      
      $.ajax({
         url:"search_model.do", 
         type: "post",
         data:param,
         dataType: "json",
         error:function(xhr){
            alert( xhr.status );   
         },//error
         success:function( jsonObj ){
            var selModel = $("#model")[0];
            if(jsonObj.dataSize = 0){
            	alert("모델에 대한 정보가 없습니다.");
            	return;
            }//end if
            
            selModel.length = 1; //옵션을 하나만 남겨둠
            $.each(jsonObj.data, function(i, jsonModel){
            										//value 값,       보여줄 값
            	selModel.options[i+1] = new Option(jsonModel.model, jsonModel.model);
            });
         }//success
         
      });//ajax
   });//click.btn
   
   $("#model").change(function() {
	   var selModel = $("#model")[0]; //$("#model").val();
	   if(selModel.selectedIndex != 0){ //선택된 인덱스가 0이 아닐 때 값을 가져옴
		   searchCar($("#model").val());
	   }
   });//change
   
   $("#btn").click(function() {
	   searchCar("all");
   });//click
   
});//ready


function searchCar(paramModel) {
	var param = {model : paramModel}
	
	$.ajax({
		url : "../day1204/search_car.do",
		data : param,
		type : "POST",
		dataType : "JSON",
		error : function(xhr){
			alert(xhr.status);
		},
		success : function(jsonObj){
			var output = "<table class='table'>";
			output += "<tr><th colspan='6'>"+ paramModel +" 조회결과 "+ jsonObj.dataSize +"건 조회</th><th>";
			output += "<tr><th>이미지</th><th>년식</th><th>가격</th><th>옵션</th><th>배기량</th><th>입력일</th></tr>";
			
			if(jsonObj.resultData){
				if(jsonObj.dataSize == 0){
					output += "<tr><td colspan='6'> 보유중인 차량이 없습니다. 담당 딜러에게 문의<br>" +
							  "<img src='http://localhost/mvc_prj/common/images/dam1.jpg' style='width:100px'></td>"
				}//end if
				
				$.each(jsonObj.data, function(i, jsonCar){
					output += "<tr>";
					output += "<td><img src='http://localhost/mvc_prj/car_img/" + jsonCar.car_img + "' style='width:80px'/></td>";
					output += "<td>"+ jsonCar.car_year +"</td>";
					output += "<td>"+ jsonCar.price +"</td>";
					output += "<td>"+ jsonCar.car_option +"</td>";
					output += "<td>"+ jsonCar.cc +"</td>";
					output += "<td>"+ jsonCar.hiredate +"</td>";
					output += "</tr>";
				});//each
			}//end if
			
			output += "</table>";
			
			$("#output").html(output);
		}
	});
}//searchModel

</script>
</head>
<body>
<div>
   <select id="country">
      <option>----제조국 선택----</option>
      <option value="국산">국산</option>
      <option value="수입">수입</option>
   </select>
   <select id="maker">
      <option>----제조사 선택----</option>
   </select>
   <select id="model">
      <option>----모델 선택----</option>
   </select>
   <input type="button" id="btn" value="모든 모델 검색">
</div>
<div id="output"></div>
</body>
</html>