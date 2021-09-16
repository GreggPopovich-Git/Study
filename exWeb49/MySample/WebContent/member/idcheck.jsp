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
	<form name="idcheck" method="post">
	<c:if test="${empty row}">
		<table style="width:100%">
			<caption class="readonly">아이디 체크</caption>
			<colgroup>
				<col width="20%">
				<col width="70%">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userid"></td>
					<td rowspan="2">
						<input type="button" value="중복체크" class="btn-write" style="height:110px;cursor:pointer;" onClick="formcheck()">
					</td>
				</tr>
			</tbody>
				<tr>
					<td colspan="3">아이디는 8자~15자의 영문이나 숫자만 가능합니다.</td>
				</tr>
		</table>
	</c:if>
	<c:if test="${row==1}">
		<table style="width:100%">
			<caption class="readonly">아이디 체크</caption>
			<colgroup>
				<col width="20%">
				<col width="70%">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userid" placeholder="${userid}는 사용할 수 없습니다."></td>
					<td rowspan="2">
						<input type="button" value="중복체크" class="btn-write" style="height:110px;cursor:pointer;" onClick="formcheck()">
					</td>
				</tr>
			</tbody>
				<tr>
					<td colspan="3">아이디는 8자~15자의 영문이나 숫자만 가능합니다.</td>
				</tr>
		</table>
	</c:if>
	<c:if test="${row==0}">
		<table style="width:100%">
			<caption class="readonly">아이디 체크</caption>
			<colgroup>
				<col width="20%">
				<col width="70%">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><font color="blue"><b>${userid}</b></font> 는 사용할 수 있습니다. <br>사용 하시겠습니까?</td>
					<td>
						<input type="button" value="확인" class="btn-write" style="height:110px;width:30;cursor:pointer;" onClick="sendid()">
					</td>
					<td>
						<input type="button" value="취소" class="btn-write" style="height:110px;width:30;cursor:pointer;" onClick="history.back()">
					</td>
				</tr>
			</tbody>
				<tr>
					<td colspan="3">아이디는 추후 변경이 불가 합니다.</td>
				</tr>
		</table>
	</c:if>
	</form>
	</div>
<script>
	function formcheck() {
		if(idcheck.userid.value=="") {
			alert("아이디를 입력하세요");
			idcheck.userid.focus();
			return;
		} else {
			var useridExp = /^([a-zA-Z]{1})([a-zA-Z0-9]{7,14})$/;
			if(!useridExp.test(idcheck.userid.value)) {
				alert("아이디 유효하지 않음");
				idcheck.userid.focus();
				return;
			}
		}
		idcheck.action="idcheck.do";
		idcheck.submit();
	}
	function sendid() {
		opener.my.userid.value = '${userid}';
		self.close();
	}
</script>
















