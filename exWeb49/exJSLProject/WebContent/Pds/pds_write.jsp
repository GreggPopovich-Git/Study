<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int nowpage = Integer.parseInt(request.getParameter("page"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSL 인재 개발원</title>
<style type="text/css">
	* {margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	body {background:url("img/aa.jfif");background-repeat:y-repeat;background-size:100%;overflow:auto;height:1000px;}
	.content {padding:16px; height:300px;}
	.title {text-align:center;padding:22px;}
	.content table{width:700px;margin:0 auto;}
	.content table th {width:20%; border:1px solid #bbb;}
	.content table td {padding:5px 5px;border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
</style>
<script>
	function send() {
		var emailExp = /([\w~\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	    if(!emailExp.test(pds.email.value)){
	    	alert("이메일이 유효하지 않음");
	        pds.email.focus();
	        return;
	    }
		if(pds.subject.value == "") {
			alert("제목을 입력해 주세요.");
			pds.subject.focus();
			return;
		}
		if(pds.contents.value == "") {
			alert("내용을 입력해 주세요.");
			board.contents.focus();
			return;
		}
		alert("글을 등록합니다.");
		pds.action = "pds_write?page=<%= nowpage %>";
		pds.submit();
	}
	function cal() {
		document.getElementById('result').value = document.getElementById("contents").value.length;
	}
</script>
</head>
<body>
	<%@ include file = "/Include/header.jsp" %>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title"> 자 료 실 </h2>
			<form name="pds" method="post" enctype="multipart/form-data">
			<input type="hidden" name="userid" value="${vo.userid}">
				<table>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="name" maxlength="3" value="${vo.name}" readonly style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email" maxlength="30" value="${vo.email}" style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="subject" maxlength="50" style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="10" name="contents" id="contents" cols="60" maxlength="1000" onkeydown="cal()" onkeyup="cal()" onkeypress="cal()" style="overflow:auto; width:500px;height:300px;font-size:20px;"></textarea><br>
						<input type="text" id="result" value="0" style="width:50px;height:30px;font-size:20px;border:none;background-color:#FBEFEF;" readonly><font style="font-size:20px;">/1000</font>
						</td>
					</tr>
					<tr>
		  				<th>파일첨부</th>
		  				<td><input type="file" name="filename" size="30"></td></tr>
					<tr>
						<td colspan="2" class="btn_group">
						<input type="button" value="글쓰기" onClick="send()" style="width:300px;height:30px;font-size:20px;cursor:pointer;"> 
						<input type="button" value="취소" onClick="history.back()" style="width:300px;height:30px;font-size:20px;cursor:pointer;">
						</td>
					</tr>
				</table>
			</form>
			</div>
		</section>
	</div>
	<%@ include file = "/Include/footer.jsp" %>
</body>
</html>