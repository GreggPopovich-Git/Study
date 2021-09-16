<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty key}">
	<script>
		alert("잘못된 접근입니다.");
		history.back();
	</script>`
</c:if>
<c:if test="${row == 1}">
	<script>
		alert("비밀번호가 변경되었습니다.");
		self.close();
	</script>
</c:if>
<c:if test="${row == 0}">
	<script>
		alert("비밀번호 변경이 실패했습니다.");
		history.back();
	</script>
</c:if>
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
	<form name="passmodify" method="post">
	<input type="hidden" name="userid" value="${userid}">
	<input type="hidden" name="key" value="${key}">
	<c:if test="${row == 99}">
		<table style="width:100%">
			<caption class="readonly">비밀번호 재설정</caption>
			<colgroup>
				<col width="20%">
				<col width="70%">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
					<th colspan="2">●비밀번호 재설정</th>
				</tr>
				<tr>
					<th scope="row">새로운 비밀번호</th>
					<td><input type="password" name="pass" style="width:300px"></td>
				</tr>
				<tr>
					<th scope="row">비밀번호 재입력</th>
					<td><input type="password" name="repass" style="width:300px"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="확인" class="btn-write" style="cursor:pointer;" onClick="formcheck()">
					</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	</form>
	</div>
<script>
	function formcheck() {
		if(passmodify.pass.value == "") {
			alert("비밀번호를 입력해주세요.");
			passmodify.pass.focus();
			return;
		}
		if(passmodify.repass.value == "") {
			alert("비밀번호를 한번 더 입력해주세요.");
			passmodify.repass.focus();
			return;
		}
		if(passmodify.pass.value != passmodify.repass.value) {
			alert("비밀번호를 확인해주세요.");
			passmodify.repass.focus();
			return;
		}
		passmodify.action="newpass_pro.do";
		passmodify.submit();
	}
</script>
