<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getParameter("row") != null) {
%>
<script>
	alert("다시 로그인 해 주세요.");
</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.content {bpadding:16px; height:100%;}
	.title {text-align:center;padding:22px;}
	.content table{width:550px; height:300px; margin:0 auto;}
	.content table td{text-align:left; padding:10px; background-color:#F6CEEC;}
	.content table th{width:25%; background-color:#F6CEEC; text-align:left; text-align:center;}
	body {background:url("img/aa.jfif");background-repeat:y-repeat;background-size:100%;}
	::placeholder {color:gray; font-size:0.7em;}
</style>
<script>
	function send() {
		if(login.userid.value == "") {
			alert("아이디를 입력하세요.");
			login.userid.focus();
			return;
		}
		if(login.pass.value == "") {
			alert("비밀번호를 입력하세요.");
			login.pass.focus();
			return;
		}
		login.action = "login_form";
		login.submit();
	}
	function id_search() {
		window.open("id_search", "아이디 찾기", "width=330, height=220");
	}
</script>
</head>
<body>
	<%@ include file = "/Include/header.jsp" %>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title"> 로그인 </h2>
			<form name="login" method="post">
				<table>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userid" style="width:330px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pass" style="width:330px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<td colspan="2" class="btn_group">
						<input type="button" value="로그인" onClick="send()" style="width:250px;height:30px;font-size:20px;cursor:pointer;"> 
						<input type="button" value="회원가입" onClick="location.href='member_insert'" style="width:250px;height:30px;font-size:20px;cursor:pointer;">
						</td>
					</tr>
					<tr>
						<td colspan="2" class="btn_group">
						<input type="button" value="아이디찾기" onClick="id_search()" style="width:250px;height:30px;font-size:20px;cursor:pointer;"> 
						<input type="button" value="비밀번호찾기" onClick="pass_search()" style="width:250px;height:30px;font-size:20px;cursor:pointer;">
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