<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<link rel="stylesheet" type="text/css" 
href="http://localhost/html_prj/common/css/main_v20230906.css"/>
<style type="text/css">
#wrap {
    width: 502px;
    height: 303px;
    margin: 0px auto;
}

#idDup {
    width: 502px;
    height: 303px;
    background: #FFFFFF url(../common/images/id_background.png) no-repeat;
    position: relative;
}

#idDiv {
    position: absolute;
    top: 100px;
    left: 80px;
    width: 300px;
}

</style>
<script type="text/javascript">
window.onload = function() {
    document.getElementById("btn").addEventListener("click",sendId);
}

function sendId() {
    //1.아이디를 가져와서
    var id = document.subFrm.id.value;
    //2.부모창에 전달한 후
    opener.window.document.frm.id.value = id;
    //3.자식창 닫기
    self.close();
}

</script>
</head>
<body>
<div id="wrap">
    <div id="idDup">
        <div id="idDiv">
            <form name="subFrm">
                <label>아이디</label>
                <input type="text" name="id" class="inputBox" style="width: 160px" 
                maxlength="16" autofocus="autofocus" value="${param.id}"/>
                
                <% String id = request.getParameter("id"); %>
                
                <input type="text" name="id2" class="inputBox" style="width: 160px" 
                maxlength="16" autofocus="autofocus" value="<%= id  %>"/>
                
                <input type="button" id="btn" value="중복확인" class="btn"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>