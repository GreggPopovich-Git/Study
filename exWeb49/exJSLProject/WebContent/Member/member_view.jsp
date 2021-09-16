<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.*" %>
<%
	if(request.getParameter("row") != null) {	
%>
<script>
	alert("비밀번호가 틀렸습니다.");
</script>
<%
	}
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
	.content {bpadding:16px; height:800px; overflow:auto;}
	.title {text-align:center;padding:22px;}
	.content table{width:1000px; height:500px; margin:0 auto;}
	.content table td{text-align:left; padding:10px; background-color:#F6CEEC;}
	.content table th{width:15%; background-color:#F6CEEC; text-align:left; text-align:center;}
	body {background:url("img/aa.jfif");background-repeat:y-repeat;background-size:100%;}
	::placeholder {color:gray; font-size:0.7em;}
</style>
<script>
	function send() {
		if(view.nowpass.value == "") {
			alert("현재 비밀번호를 입력 해 주세요.");
			view.nowpass.focus();
			return;
		}
		if(view.pass.value == "") {
			alert("변경할 비밀번호를 입력 해 주세요.");
			view.pass.focus();
			return;
		}
		var passExp = /^[a-zA-Z0-9]{5,12}$/;
	    if(!passExp.test(view.pass.value)){
	       alert("비밀번호는 5~12자의 영문 대소문자와 숫자로만 입력");
	       view.pass.focus();
	       return;
	    }
		if(view.repass.value == "") {
			alert("비밀번호를 다시 입력 해 주세요.");
			view.repass.focus();
			return;
		}
		if(view.repass.value != view.pass.value) {
			alert("변경할 비밀번호가 서로 다릅니다.");
			view.repass.focus();
			return;
		}
		view.action = "member_view";
		view.submit();
	}
	function del() {
		if(view.nowpass.value == "") {
			alert("현재 비밀번호를 입력 해 주세요.");
			view.nowpass.focus();
			return;
		}
		if(confirm("정말 탈퇴 하시겠습니까? 모든 게시물은 삭제 됩니다.")) {
			view.action = "member_delete";
			view.submit();
		} 
	}
</script>
</head>
<body>
	<%@ include file = "/Include/header.jsp" %>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title"> 회 원 정 보 </h2>
			<form name = "view" method = "post">
			<input type="hidden" name="userid" value="<%= vo.getUserid() %>">
				<table>
					<tr>
						<th>회원 ID</th>
						<td><%= vo.getUserid() %></td>
						<th>현재비밀번호</th>
						<td><input type="password" name="nowpass" placeholder="5~12자 이내의 영문이나 숫자만 가능합니다." style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>회원 성명</th>
						<td><%= vo.getName() %></td>
						<th>변경비밀번호</th>
						<td><input type="password" name="pass" placeholder="5~12자 이내의 영문이나 숫자만 가능합니다." style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>성별</th>
						<td>
						<%
							if(vo.getGender().equals("M")) {
						%>
						남성
						<%
							} else {
						%>
						여성
						<%
							}
						%>
						</td>
						<th>비밀번호확인</th>
						<td><input type="password" name="repass" placeholder="5~12자 이내의 영문이나 숫자만 가능합니다." style="width:300px;height:30px;font-size:20px;"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><%= vo.getEmail() %></td>
						<th>가입일자</th>
						<td><%= vo.getFirst_time() %></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><%= vo.getTel() %></td>
						<th>최종로그인</th>
						<td><%= vo.getLast_time() %></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center;"><input type="button" value="회원탈퇴" onClick="del()" style="width:300px;height:30px;font-size:20px;cursor:pointer;"></td>
						<td colspan="2" style="text-align:center;"><input type="button" value="비밀번호 변경하기" onClick="send()" style="width:300px;height:30px;font-size:20px;cursor:pointer;"></td>
					</tr>
				</table>
			</form>
			</div>
		</section>
	</div>
	<%@ include file = "/Include/footer.jsp" %>
</body>
</html>