<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.*" %>
<%
	MemberVO loginvo = null;
	if(session.getAttribute("vo") != null) {
		loginvo = (MemberVO)session.getAttribute("vo");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.logo {color:#fff; text-align:center; background-color:#5858FA; padding:16px 0;}
	.nav {padding:12px 90px; overflow:hidden; background-color:#A9A9F5;}
	.nav ul li {float:left; padding:0 45px; text-align:center; color:#fff;}
</style>
<script>
	function logout() {
		 if (confirm("로그아웃 하시겠습니까?")) {
		 	location.replace("logout");
		 }
	}
</script>
</head>
<body>
	<div class="header">
		<header>
			<h1 class="logo"> JSL 인재 개발원  </h1>
			<div class="nav">
				<nav>
					<ul class="navi">
						<li><a href="index">[홈으로]</a></li>
					<%
						if(loginvo != null) {
					%>
						<li><a href="javascript:logout()">[로그아웃]</a></li>
					<%
						} else {
					%>
						<li><a href="login_form">[로그인]</a></li>
					<%
						}
					%>
						<li><a href="board_list">[자유게시판]</a></li>
						<li><a href="pds_list">[자료실(회원전용)]</a></li>
					<%
						if(loginvo != null) {
					%>
						<li><a href="member_modify">[회원정보수정]</a></li>
					<%
						} else {
					%>
						<li><a href="member_insert">[회원가입]</a></li>
					<%
						}
						if(loginvo != null) {
					%>	
						<li><a href="member_view">[<%= loginvo.getName() %> 님]</a></li>
					<%
						} else {
					%>
						<li>[guest 님]</li>
					<%
						}
					%>
						<li><a href="map.jsp">[오시는길]</a></li>
					</ul>
				</nav>
			</div>
		</header>
	</div>
</body>
</html>