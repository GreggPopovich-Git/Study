<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>장수하늘소</title>
	<link href="/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<link href="/css/common.css" rel="stylesheet">
	<link href="/css/mystyle.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
</head>
	<div class="write-form" style="width:100%; margin:0 auto;">
	<form name="passfind" method="post">
	<input type="hidden" name="id" value="${userid}">
	<c:if test="${empty row}">
		<table style="width:100%">
			<caption class="readonly">비밀번호 찾기</caption>
			<colgroup>
				<col width="20%">
				<col width="70%">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
				
					<th colspan="2">●비밀번호 찾기</th>
				</tr>
				<tr>
					<th scope="row">아이디</th>
					<td><input type="text" name="userid" style="width:300px"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" name="email1" class="email"> @
						<input type="text" name="email2" class="email" disabled>
						<select name="domain" style="height:40px;" onChange="email_change()">
							<option value="0">선택하세요</option>
							<option value="9">직접입력</option>
							<option value="gmail.com">gmail.com</option>
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="yahoo.co.kr">yahoo.co.kr</option>
							<option value="nate.com">nate.com</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="비밀번호 찾기" class="btn-write" style="cursor:pointer;" onClick="formcheck()">
					</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<c:if test="${row == 1}">
		<table style="width:100%">
			<caption class="readonly">비밀번호 찾기</caption>
			<colgroup>
				<col width="20%">
				<col width="70%">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
					<th>인증번호</th>
				</tr>
				<tr>
					<td>회원님의 이메일로 인증번호를 보냈습니다. 확인하고 입력해주세요.</td>
				</tr>
				<tr>
					<td><input type="text" name="key" style="width:300px"></td>
					<td colspan="2">
						<input type="button" value="확인" class="btn-write" style="cursor:pointer;" onClick="check()">
					</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<c:if test="${row == 0}">
		<table style="width:100%">
			<caption class="readonly">비밀번호 찾기</caption>
			<colgroup>
				<col width="20%">
				<col width="70%">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
					<th colspan="2"><font color="red">회원을 찾을 수 없습니다.</font></th>
				</tr>
			</tbody>
		</table>
	</c:if>
	</form>
	</div>
<script>
	function formcheck() {
		if(passfind.userid.value == "") {
			alert("아이디를 입력해주세요.");
			passfind.userid.focus();
			return;
		}
		if(passfind.email1.value == "") {
			alert("이메일을 입력해주세요.");
			passfind.email1.focus();
			return;
		}
		if(passfind.email2.value == "") {
			alert("이메일을 입력해주세요.");
			passfind.email2.focus();
			return;
		}
		passfind.action="pwfind_pro.do";
		passfind.submit();
	}
    function email_change(){
    	if(document.passfind.domain.options[document.passfind.domain.selectedIndex].value == "0") {
			document.passfind.email2.disabled = true;
    	 	document.passfind.email2.value = "";
    	} else if(document.passfind.domain.options[document.passfind.domain.selectedIndex].value == "9") {
    	 	document.passfind.email2.disabled = false;
    	 	document.passfind.email2.value = "";
    	 	document.passfind.email2.focus();
    	} else {
    	 	document.passfind.email2.disabled = true;
    	 	document.passfind.email2.value = document.passfind.domain.options[document.passfind.domain.selectedIndex].value;
    	}
    }
    function check() {
    	if(passfind.key.value == '${akey}') {
    		alert("본인인증 되었습니다. 새로운 비밀번호를 설정합니다.");
    		passfind.action="newpass.do";
    		passfind.submit();
    	} else {
    		alert("인증번호가 틀렸습니다.");
    	}
    }
</script>
