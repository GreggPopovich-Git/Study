<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.*" %>
<%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSL 인재 개발원</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.content {bpadding:16px; height:700px; overflow:auto;}
	.title {text-align:center;padding:22px;}
	.content table{width:550px; height:500px; margin:0 auto;}
	.content table td{text-align:left; padding:10px; background-color:#F6CEEC;}
	.content table th{width:25%; background-color:#F6CEEC; text-align:left; text-align:center;}
	body {background:url("img/aa.jfif");background-repeat:y-repeat;background-size:100%;}
	::placeholder {color:gray; font-size:0.7em;}
</style>
<script>
function send() {
	if(modify.pass.value == "") {
		alert("비밀번호를 입력하세요.");
		modify.pass.focus();
		return;
	}
	if(modify.name.value == "") {
		alert("이름을 입력하세요.");
		modify.name.focus();
		return; 
	}
	if(modify.email.value==""){
        alert("이메일을 입력하세요");
        modify.email.focus();
        return;
     }else{
        var emailExp = /([\w~\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
        if(!emailExp.test(modify.email.value)){
           alert("이메일이 유효하지 않음");
           modify.email.focus();
           return;
        }
     }
	if(modify.tel.value == "") {
		alert("전화번호를 입력하세요.");
		modify.tel.focus();
		return;
	} else {
		var usertelExp = /^(010[0-9]{8})$/;
		if(!usertelExp.test(modify.tel.value)) {
			alert("전화번호 유효하지 않음");
			modify.tel.focus();
			return;
		}
	}
	alert("회원정보를 저장합니다.");
	modify.action = "member_modify";
	modify.submit();
}
</script>
</head>
<body>
	<%@ include file = "/Include/header.jsp" %>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title"> 회 원 정 보 수 정 </h2>
			<form name = "modify" method = "post">
				<table>
					<tr>
						<th>회원 ID <br> <h5>(수정불가)</h5></th>
						<td><input type="text" name="userid" value="<%= vo.getUserid() %>" style="width:300px;height:30px;font-size:20px;" readonly></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pass" placeholder="5~12자 이내의 영문이나 숫자만 가능합니다." style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>회원 성명</th>
						<td><input type="text" name="name" value="<%= vo.getName() %>" style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>성별</th>
						<td> &nbsp;
						<input type="radio" name="gender" value="M" <% if(vo.getGender().equals("M")) { %> checked <% } %>>남성&nbsp;&nbsp;
						<input type="radio" name="gender" value="F" <% if(vo.getGender().equals("F")) { %> checked <% } %>>여성 
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email" size="15" value="<%= vo.getEmail() %>" style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="tel" maxlength="11" value="<%= vo.getTel() %>" style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center;"><input type="button" value="회원정보수정" onClick="send()" style="width:300px;height:30px;font-size:20px;cursor:pointer;"></td>
					</tr>
				</table>
			</form>
			</div>
		</section>
	</div>
	<%@ include file = "/Include/footer.jsp" %>
</body>
</html>    