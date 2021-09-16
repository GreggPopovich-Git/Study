<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/include/header.jsp"%>
<c:if test="${!empty sessionvo}">
	<script>
		alert("${sessionvo.name} 님 환영합니다 !");
		location.href = "index.do";
	</script>
</c:if>
<c:if test="${row==0}">
	<script>
		alert("비밀번호가 틀립니다.");
	</script>
</c:if>
<c:if test="${row==-1}">
	<script>
		alert("해당 아이디가 없습니다.");
	</script>
</c:if>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">장수하늘소 로그인</h2>
	</div>
	
	<div class="write-form" style="width:50%; margin:0 auto; border:1px solid #ccc; padding:20px;">
		<form name="login" method="post">
			<fieldset>
				<legend class="readonly">로그인그룹</legend>
				<div style="width:70%; float:left;">
					<label for="userid" class="readonly">아이디</label>
					<input type="text" name="userid" id="id" placeholder="아이디">
					<label for="pass" class="readonly">패스워드</label>
					<input type="password" name="pass" id="pw" onKeyUp="autoSubmitRight()" placeholder="패스워드">
				</div>
				<div style="width:28%; float:right;padding:15px;
				height:132px; margin-top:3px;">
					<input type="button" value="로그인" alt="로그인" onClick="logincheck()"
					style="background: #FF4000; color:#fff;
					width:100%; height:100%; border:0 none; cursor:pointer;">
				</div>
				<p style="clear:both;padding-top:20px; text-align:center;">
				<a href="javascript:idfind()">아이디찾기</a> | <a href="javascript:pwfind()">패스워드찾기</a> | <a href="member.do">회원가입</a></p>
			</fieldset>
		</form>
	</div>
		
</div>

<script>
	function logincheck() {
		if(login.userid.value=="") {
			alert("아이디를 입력하세요");
			login.userid.focus();
			return false;
		}
		if(login.pass.value=="") {
			alert("비밀번호를 입력하세요");
			login.pass.focus();
			return false;
		}
		login.action="login.do";
		login.submit();
	}
	function autoSubmitRight() {
		if (event.keyCode == 13) {
			logincheck();
		}
	}
	function idfind() {
		window.open("idfind.do", "아이디 찾기", "width=600, height=400");
	}
	function pwfind() {
		window.open("pwfind.do", "비밀번호 찾기", "width=600, height=400");
	}
</script>

<%@ include file="/include/footer.jsp"%>















