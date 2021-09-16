<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${deleterow==1}">
	<script>
		alert("삭제되었습니다.");
		opener.location.href = "gallery.do";
		self.close();
	</script>
</c:if>
<c:if test="${deleterow==0}">
	<script>
		alert("비밀번호가 틀렸습니다.");
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
	<form name="deleteform" method="post" action="gallery_delete_pro.do">
		<input type="hidden" name="idx" value="${idx}">
		<table style="width:100%">
			<caption class="readonly">갤러리 삭제</caption>
			<colgroup>
				<col width="20%">
				<col width="70%">
				<col width="30%">
			</colgroup>
			<tbody>
				<tr>
					<th width="30%">비밀번호</th>
					<td><input type="password" name="pass"></td>
					<td rowspan="2">
						<input type="submit" value="삭 제" class="btn-write" style="height:110px;cursor:pointer;">
					</td>
				</tr>
			</tbody>
				<tr>
					<td colspan="3">경고 ! 삭제하면 복구 할 수 없습니다.</td>
				</tr>
		</table>
	</form>
	</div>

















