<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 회원 관리</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.content {padding:16px; height:300px;}
	.title {text-align:center;padding:22px;}
	body {background:url("img/aa.jfif");background-repeat:no-repeat;background-size:100%;}
	table {width:700px;height:300px;text-align:center;border:1px solid #444444;}
	td {border:1px solid #444444;}
</style>
<script>
	function send() {
		if(insert.name.value == "") {
			alert("회원성명을 입력하세요.");
			insert.name.focus();
			return;
		}
		if(insert.address.value == "") {
			alert("주소를 입력하세요.");
			insert.address.focus();
			return;
		}
		if(insert.regdate.value == "") {
			alert("가입일자를 입력하세요.");
			insert.regdate.focus();
			return;
		}
		if(insert.rank.value == "") {
			alert("고객등급을 입력하세요.");
			insert.rank.focus();
			return;
		}
		if(insert.citycode.value == "") {
			alert("도시코드를 입력하세요.");
			insert.citycode.focus();
			return;
		}
		alert("회원등록이 정상적으로 등록 되었습니다.");
	}
	function reflash() {
		if(confirm("모든 정보를 지우고 다시 시작합니다.")) {
			insert.reset();
			insert.name.focus();
		}
	}
</script>
</head>
<body>
<%@ include file = "/Include/header.jsp" %>
	<div class="section">
		<section>
			<div class="content" align="center">
				<h2 class="title">쇼핑몰 회원 등록</h2>
				<form name="insert" method="post">
				<table>
					<tr>
						<td>회원번호(자동발생)</td>
						<td align="left"><input type="text" readonly></td>
					</tr>
					<tr>
						<td>회원성명</td>
						<td align="left"><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>회원주소</td>
						<td align="left"><input type="text" name="address"></td>
					</tr>
					<tr>
						<td>가입일자</td>
						<td align="left"><input type="text" name="regdate"></td>
					</tr>
					<tr>
						<td>고객등급[A:VIP,B:일반,C:직원]</td>
						<td align="left"><input type="text" name="rank"></td>
					</tr>
					<tr>
						<td>도시코드</td>
						<td align="left"><input type="text" name="citycode"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="등록" onClick="send()">&nbsp;&nbsp;<input type="button" value="취소" onClick="reflash()"></td>
					</tr>
				</table>
				</form>
			</div>
		</section>
	</div>
<%@ include file = "/Include/footer.jsp" %>
</body>
</html>    