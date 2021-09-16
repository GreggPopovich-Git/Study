<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.*" %>
<%
	int row = 99;
	MemberVO vo = null;
	if(request.getParameter("row") != null) {
		row = Integer.parseInt(request.getParameter("row"));
		vo = (MemberVO)session.getAttribute("vo");
	}
	if(row == 1) {
%>
<script>
	alert("<%= vo.getName() %>님 환영합니다.");
</script>
<%
	} else if(row == 0) {
%>
<script>
	alert("비밀번호가 틀렸습니다.");
	history.back();
</script>
<%
	} else if(row == -1) {
%>
<script>
	alert("해당 아이디를 찾을 수 없습니다.");
	history.back();
</script>
<%
	} else if(row == 3) {
%>
<script>
	alert("회원정보가 수정되었습니다.");
</script>
<%
	}
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
	.content {padding:16px; height:300px;}
	.title {text-align:center;padding:22px;}
	body {background:url("img/aa.jfif");background-repeat:no-repeat;background-size:100%;}
</style>
</head>
<body>
<%@ include file = "/Include/header.jsp" %>
	<div class="section">
		<section>
			<div class="content" align="center">
				<h2 class="title">일본해외취업 연수기관 ‘JSL인재개발원’이 함께합니다!</h2>
					<br>JSL인재개발원은 한국산업인력공단의 해외취업연수 사업인 K-Move스쿨 운영기관으로
							글로벌 인재양성을 위한 해외취업 특화과정을 주 프로그램으로 운영하고 있습니다.<br><br>
				<h3>‘JSL인재개발원’은 이런 분들께 추천합니다!</h3>
					<br> 1. IT 관련 학과를 전공하신 분<br>
					<br> 2. JAVA/C를 배우고 싶으신 분<br>
					<br> 3. DB 에 관심이 많으신 분<br>
					<br> 4. JSP&Sevelet 경험하고 싶으신분<br>
					<br> 5. 일본어 학과를 전공하신 분<br>
					<br> 6. 일본취업에 관심이 많으신 분<br>
					<br> 7. 일본취업을 목표로 하시는 분<br>
			</div>
		</section>
	</div>
<%@ include file = "/Include/footer.jsp" %>
</body>
</html>    