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
	<form name="idfind" method="post">
	<c:if test="${empty userid}">
		<table style="width:100%">
			<caption class="readonly">아이디 찾기</caption>
			<colgroup>
				<col width="20%">
				<col width="70%">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
					<th colspan="2">●아이디 찾기</th>
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
					<th scope="row">전화번호</th>
					<td><input type="text" name="tel1" maxlength="3" style="width:80px"> - <input type="text" name="tel2" maxlength="4" style="width:100px"> - <input type="text" name="tel3" maxlength="4" style="width:100px"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="아이디 찾기" class="btn-write" style="cursor:pointer;" onClick="formcheck()">
					</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<c:if test="${!empty userid}">
		<table style="width:100%">
			<caption class="readonly">아이디 찾기</caption>
			<colgroup>
				<col width="20%">
				<col width="70%">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<td>회원님의 아이디는 <b>${userid}</b> 입니다.</td>
					<td colspan="2">
						<input type="button" value="창닫기" class="btn-write" style="cursor:pointer;" onClick="self.close()">
					</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<c:if test="${userid == ''}">
		<table style="width:100%">
			<caption class="readonly">아이디 체크</caption>
			<colgroup>
				<col width="20%">
				<col width="70%">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
					<th colspan="2"><font color="red">아이디를 찾을 수 없습니다.</font></th>
				</tr>
			</tbody>
		</table>
	</c:if>
	</form>
	</div>
<script>
	function formcheck() {
		if(idfind.email1.value == "") {
			alert("이메일을 입력해주세요.");
			idfind.email1.focus();
			return;
		}
		if(idfind.email2.value == "") {
			alert("이메일을 입력해주세요.");
			idfind.email2.focus();
			return;
		}
		if(idfind.tel1.value == "" || idfind.tel2.value == "" || idfind.tel3.value == "") {
			alert("전화번호를 입력해 주세요.");
			idfind.tel1.focus();
			return;
		}
		idfind.action="idfind.do";
		idfind.submit();
	}
    function email_change(){
    	if(document.idfind.domain.options[document.idfind.domain.selectedIndex].value == "0") {
			document.idfind.email2.disabled = true;
    	 	document.idfind.email2.value = "";
    	} else if(document.idfind.domain.options[document.idfind.domain.selectedIndex].value == "9") {
    	 	document.idfind.email2.disabled = false;
    	 	document.idfind.email2.value = "";
    	 	document.idfind.email2.focus();
    	} else {
    	 	document.idfind.email2.disabled = true;
    	 	document.idfind.email2.value = document.idfind.domain.options[document.idfind.domain.selectedIndex].value;
    	}
    }
</script>
