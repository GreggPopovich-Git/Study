<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	function send() {
		if(input.name.value == "") {
			alert("이름을 입력하세요");
			input.name.focus();
			return;
		}
		var id = input.id.value;
		if(id == "" || id.length < 4) {
			alert("아이디를 입력하세요");
			input.id.focus();
			return;
		}
		if(input.pass.value == "") {
			alert("비밀번호를 입력하세요");
			input.pass.focus();
			return;
		}
		if(input.email.value == "") {
			alert("이메일을 입력하세요");
			input.email.focus();
			return;
		}
		// select
		if(input.domain.selectedIndex == 0) {
			alert("이메일선택");
			input.domain.focus();
			return;
		}
		// 라디오, 체크박스 버튼 체크
		var flag = 0;
		for (x = 0; x < input.gender.length; x++) {
			if(input.gender[x].checked) {
				flag = 1;
				break;
			}
		}
		if(!flag) {
			alert("성별을 체크하세요");
			return;
		}
		if(input.tel1.value == "") {
			alert("전화번호를 입력하세요");
			input.tel1.focus();
			return;
		}
		if(input.tel2.value == "") {
			alert("전화번호를 입력하세요");
			input.tel2.focus();
			return;
		}
		if(input.tel3.value == "") {
			alert("전화번호를 입력하세요");
			input.tel3.focus();
			return;
		}
		var flag1 = 0;
		for (x = 0; x < input.interests.length; x++) {
			if(input.interests[x].checked) {
				flag1 = 1;
				break;
			}
		}
		if(!flag1) {
			alert("관심분야를 선택하세요");
			return;
		}
		alert("전송합니다");
		input.action = "join_pro.jsp";
		input.submit();
	}
	function del() {
		input.reset();
		input.name.focus();
	}
	// 폼 이름 없이 불러올 때
	//var name = Document.getElementsByName("name");
	//var name = Document.getElementById("name");
	function back() {
		alert("회원가입을 취소하고 되돌아갑니다");
		history.back();
	}
</script>
</head>
<body>
	<form method="post" name="input">
	<input type = "hidden" name = "idx" value = "1">
	<table width="800" height="700" align="center" border="1">
	<tr align="center">
		<td colspan="2" align="center">회원가입</td>
	</tr>
	<tr align="center">
		<td width="30%">이름</td>
		<td width="70%"><input type="text" size="50" name="name"></td>
	</tr>
	<tr align="center">
		<td width="30%">ID</td>
		<td width="70%"><input type="text" size="50" name="id"></td>
	</tr>
	<tr align="center">
		<td width="30%">PW</td>
		<td width="70%"><input type="password" size="50" name="pass"></td>
	</tr>
	<tr align="center">
		<td width="30%">이메일</td>
		<td width="70%"><input type="text" size="25" name="email"> @
		<select name="domain">
			<option>이메일을 선택하세요</option>
			<option value="naver.com">naver.com</option>
			<option value="daum.net">daum.net</option>
			<option value="gmail.com">gmail.com</option>
		</select></td>
	</tr>
	<tr align="center">
		<td width="30%">성별</td>
		<td width="70%"><input type="radio" name="gender" value="남">남
						<input type="radio" name="gender" value="여">여
		</td>
	</tr>
	<tr align="center">
		<td width="30%">전화</td>
		<td width="70%"><input type="text" name="tel1" size="10" maxlength = "3" value = "010"> -
						<input type="text" name="tel2" size="10" maxlength = "4"> -
						<input type="text" name="tel3" size="10" maxlength = "4">
	</tr>
	<tr align="center">
		<td width="30%">관심분야</td>
		<td width="70%"><input type="checkbox" name="interests" value="영화">영화
						<input type="checkbox" name="interests" value="스포츠">스포츠
						<input type="checkbox" name="interests" value="여행">여행
	</tr>
	<tr align="center">
		<td width="30%">소감</td>
		<td width="70%"><textarea col="60" row="10" size="50" name="feel"></textarea>
	</tr>
	<tr align="center">
		<td colspan="2" align="center">
		<input type = "button" value = "등록" onClick = "send()">&nbsp;&nbsp;
		<input type="button" value="다시입력" onClick = "del()">&nbsp;&nbsp;
		<input type="button" value="취소" onClick = "javascript:history.back()">
		<input type="button" value="방명록가기" onClick = "location.href = 'Guest/guest_list.jsp'"></td>
	</tr>
	</table>
	</form>
</body>
</html>