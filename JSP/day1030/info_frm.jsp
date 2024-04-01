<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="http://192.168.10.136/html_prj/common/main/favicon.png"/>
<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- jQeury CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">


</style>

<script type="text/javascript">
$(function() {
	$("#btnImg").click(function(){
		if($("#profileImg").val() == ""){
			alert("이미지를 선택해주세요.");
			return;
		}//end if
		
		//1.폼 얻기
		var frm = $("#frm")[0];
		
		//2.ajax로 전송할 폼 객체 생성
		var formData = new FormData(frm);
		
		$.ajax({
			url : "info_upload_process.jsp",
			type : "post",
			processData : false,
			contentType : false,
			data : formData,
			async : "false",
			dataType : "JSON",
			error : function(xhr) {
				$("#imgResult").html("이미지 업로드 실패");
				console.log(xhr.status);
			},
			success : function(jsonObj) {
				var msg = "이미지 업로드 실패";
				if(jsonObj.uploadFlag){
					msg = jsonObj.id + "님 이미지가 업로드 되었습니다.";
					$("#imgResult").html(msg);
				}
			}
		});	
		
		$("#profileImg").change(function(event) {
			if($("#profileImg").val() == ""){
				alert("이미지를 선택해주세요.");
				return;
			}
			var file = event.target.files[0];
		    var reader = new FileReader(); 
		    
		    reader.onload = function(e) {
		    	$("#previewProFile").attr("src", e.target.result);
		    }

		    reader.readAsDataURL(file);
		});
		
		$("#btnSubmit").click(function() {
			$("#frm").submit();
		});
		
	});//click
});//ready
</script>

</head>
<body>
<form action="info_frm_process.jsp" method="post" id="frm" name="frm">

프로필 이미지 : <input type="file" id="profileImg" name="profileImg" class="inputBox"/>
<input type="button" id="btnImg" value="이미지 업로드" class="btn btn-success"/> <br>
<span id="imgResult"></span>
<br>

<img id="previewProFile" src="../common/images/default.png" style="width:100px"/><br>

ID : <input type="text" name="id" id="id" class="inputBox" value="nong" readonly="readonly"><br>
이름 : <input type="text" name="name" id="name" class="inputBox">

<input type="button" id="btnSubmit" value="전송" class="btn btn-warning"/>

</form>
</body>
</html>