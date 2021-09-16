<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회 원 가 입</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.content {bpadding:16px; height:700px;}
	.title {text-align:center;padding:22px;}
	.content table{width:550px; height:500px; margin:0 auto;}
	.content table td{text-align:left; padding:10px; background-color:#F6CEEC;}
	.content table th{width:25%; background-color:#F6CEEC; text-align:left; text-align:center;}
	body {background:url("img/aa.jfif");background-repeat:y-repeat;background-size:100%;}
	::placeholder {color:gray; font-size:0.7em;}
</style>
<script>
function send() {
	if(insert.userid.value == "") {
		alert("아이디 중복체크를 해주세요.");
		insert.userid.focus();
		return;
	}
	if(insert.pass.value == "") {
		alert("비밀번호를 입력하세요.");
		insert.pass.focus();
		return;
	}
	var passExp = /^[a-zA-Z0-9]{5,12}$/;
    if(!passExp.test(insert.pass.value)){
       alert("비밀번호는 5~12자의 영문 대소문자와 숫자로만 입력");
       insert.pass.focus();
       return;
    }
	if(insert.repass.value == "") {
		alert("비밀번호를 확인하세요.");
		insert.repass.focus();
		return;
	}
	if(insert.pass.value != insert.repass.value) {
		alert("비밀번호가 다릅니다 다시 입력하세요.");
		insert.repass.focus();
		return;
	}
	if(insert.name.value == "") {
		alert("이름을 입력하세요.");
		insert.name.focus();
		return; 
	}
	if(insert.gender.value == "") {
		alert("성별을 선택하세요");
		insert.name.focus();
		return; 
	}
	if(insert.email.value==""){
        alert("이메일을 입력하세요");
        insert.email.focus();
        return;
     }else{
        var emailExp = /([\w~\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
        if(!emailExp.test(insert.email.value)){
           alert("이메일이 유효하지 않음");
           insert.email.focus();
           return;
        }
     }
	if(insert.tel.value == "") {
		alert("전화번호를 입력하세요.");
		insert.tel.focus();
		return;
	} else {
		var usertelExp = /^(010[0-9]{8})$/;
		if(!usertelExp.test(insert.tel.value)) {
			alert("전화번호 유효하지 않음");
			insert.tel.focus();
			return;
		}
	}
	alert("회원정보를 저장합니다.");
	insert.action = "member_insert";
	insert.submit();
}
// 아이디 중복검사 스크립트
function id_check() {
	window.open("id_check", "아이디 중복체크", "width=330, height=220");
}
</script>
</head>
<body>
	<%@ include file = "/Include/header.jsp" %>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title"> 회 원 가 입 </h2>
			<form name = "insert" method = "post">
				<table>
					<tr>
						<th>회원 ID</th>
						<td><input type="text" name="userid" placeholder="중복체크를 해주세요." style="width:300px;height:30px;font-size:20px;" readonly>
							<input type="button" name="idcheck" value="중복체크" onClick="id_check()" style="width:70px;height:30px;font-size:15px;cursor:pointer;">
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pass" placeholder="5~12자 이내의 영문이나 숫자만 가능합니다." style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" name="repass" placeholder="5~12자 이내의 영문이나 숫자만 가능합니다." style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>회원 성명</th>
						<td><input type="text" name="name" maxlength="4" style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>성별</th>
						<td> &nbsp;<input type="radio" name="gender" value = "M">남성&nbsp;&nbsp;<input type="radio" name="gender" value = "F">여성 </td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email" size="15" style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="tel" maxlength="11" style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center;"><input type="button" value="회원가입" onClick="send()" style="width:300px;height:30px;font-size:20px;cursor:pointer;"></td>
					</tr>
				</table>
			</form>
			</div>
		</section>
	</div>
	<%@ include file = "/Include/footer.jsp" %>
</body>
</html>    