<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSL 인재 개발원</title>
<style type="text/css">
	* {margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	body {background:url("img/aa.jfif");background-repeat:y-repeat;background-size:100%;overflow:auto;height:1000px;}
	.content {padding:16px; height:300px;}
	.title {text-align:center;padding:22px;}
	.content table{width:700px;margin:0 auto;}
	.content table th {width:20%; border:1px solid #bbb;}
	.content table td {padding:5px 5px;border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
</style>
<script>
	function send() {
		if(board.name.value == "") {
			alert("이름을 입력해 주세요.");
			board.name.focus();
			return;
		}
		if(board.subject.value == "") {
			alert("제목을 입력해 주세요.");
			board.subject.focus();
			return;
		}
		if(board.contents.value == "") {
			alert("내용을 입력해 주세요.");
			board.contents.focus();
			return;
		}
		if(board.pass.value == "") {
			alert("비밀번호를 입력해 주세요.");
			board.pass.focus();
			return;
		}
		alert("글을 등록합니다.")
		board.action = "board_reply?page=${page}";
		board.submit();
	}
	function cal() {
		document.getElementById('result').value = document.getElementById("contents").value.length;
	}
</script>
</head>
<body>
	<%@ include file = "/Include/header.jsp" %>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title"> 자유게시판 </h2>
			<form name="board" method="post">
			<input type="hidden" name="userid" value="${vo.userid}">
			<input type="hidden" name="idx" value="${idx}">
			<input type="hidden" name="reply" value="${reply}">
				<table>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="name" maxlength="3" value="${vo.name}" style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email" maxlength="30" value="${vo.email}" style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="subject" maxlength="50" value="${subject}" style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="10" name="contents" id="contents" cols="60" maxlength="1000" onkeydown="cal()" onkeyup="cal()" onkeypress="cal()" style="overflow:auto; width:500px;height:300px;font-size:20px;"></textarea><br>
						<input type="text" id="result" value="0" style="width:50px;height:30px;font-size:20px;border:none;background-color:#FBEFEF;" readonly><font style="font-size:20px;">/1000</font>
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pass" maxlength="10" style="width:150px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<td colspan="2" class="btn_group">
						<input type="button" value="글쓰기" onClick="send()" style="width:300px;height:30px;font-size:20px;cursor:pointer;"> 
						<input type="button" value="취소" onClick="history.back()" style="width:300px;height:30px;font-size:20px;cursor:pointer;">
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