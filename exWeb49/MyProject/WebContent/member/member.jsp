<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/include/header.jsp"%>
<c:if test="${row==1}">
	<script>
		location.href = "login.do";
	</script>
</c:if>
<c:if test="${row==0}">
	<script>
		alert("회원가입에 실패 했습니다. 다시 시도 해 주세요.");
		history.back();
	</script>
</c:if>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">회원가입</h2>
	</div>
	
	<div class="write-form">
	<form name="my" method="post" action="member_pro.do" onsubmit="return formcheck();">
		<table summery="회원가입 글쓰기 테이블 입니다">
			<caption class="readonly">회원가입 입력폼</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
				<fieldset>
					<legend class="readonly">입력폼</legend>
					<tr>
						<th scope="row">
							<label for="id">아이디</label>
						</th>
						<td>
							<input type="text" name="userid" id="id" class="minput" placeholder="중복확인을 해주세요" readonly> 
							<a href="javascript:idcheck()" class="btn-write">중복확인</a>
						</td>
					</tr>
					<tr>
						<th scope="row"><lavel for="pass1">패스워드</lavel></th>
						<td><input type="password" name="pass" id="pass1" class="minput"></td>
					</tr>
					<tr>
						<th scope="row">패스워드 확인</th>
						<td><input type="password" name="repass" class="minput"></td>
					</tr>
					<tr>
						<th scope="row">이름</th>
						<td><input type="text" name="name" class="minput"></td>
					</tr>
					<tr>
						<th scope="row">이메일</th>
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
						<td><input type="text" name="tel1" maxlength="3" style="width:90px"> - <input type="text" name="tel2" maxlength="4" style="width:110px"> - <input type="text" name="tel3" maxlength="4" style="width:110px"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="전송" class="btn-write" style="cursor:pointer;" onClick="formcheck()">
							<input type="button" value="취소" class="btn-reset" style="cursor:pointer;" onClick="history.back()">
						</td>
					</tr>
					</fieldset>
			</tbody>
		</table>
		</form>
	</div>
		
</div>

<script>
	function formcheck() {
		if(my.id.value=="") {
			alert("아이디를 입력하세요");
			my.id.focus();
			return false;
		}
		if(my.pass.value=="") {
			alert("패스워드를 입력하세요");
			my.pass.focus();
			return false;
		}
		if(my.repass.value=="") {
			alert("패스워드를 다시 한번 더 입력하세요");
			my.repass.focus();
			return false;
		}
		if(my.pass.value != my.repass.value) {
			alert("패스워드를 확인하세요");
			my.repass.focus();
			return false;
		}
		if(my.name.value == "") {
			alert("이름을 입력하세요");
			my.name.focus();
			return false;
		}
		if(my.email1.value == "") {
			alert("이메일을 입력하세요");
			my.email1.focus();
			return false;
		}
		if(my.email2.value == "") {
			alert("이메일을 입력하세요");
			my.email1.focus();
			return false;
		}
		if(my.email2.value == "") {
			alert("이메일을 입력하세요");
			my.email2.focus();
			return false;
		}
		if(my.tel1.value == "" || my.tel2.value == "" || my.tel3.value == "") {
			alert("전화번호를 입력하세요");
			my.tel1.focus();
			return false;
		}
		my.submit();
	}
    function email_change(){
    	if(document.my.domain.options[document.my.domain.selectedIndex].value == "0") {
			document.my.email2.disabled = true;
    	 	document.my.email2.value = "";
    	} else if(document.my.domain.options[document.my.domain.selectedIndex].value == "9") {
    	 	document.my.email2.disabled = false;
    	 	document.my.email2.value = "";
    	 	document.my.email2.focus();
    	} else {
    	 	document.my.email2.disabled = true;
    	 	document.my.email2.value = document.my.domain.options[document.my.domain.selectedIndex].value;
    	}
    }
 	// 아이디 중복검사 스크립트
	function idcheck() {
		window.open("idcheck.do", "아이디 중복체크", "width=600, height=220");
	}
</script>

<%@ include file="/include/footer.jsp"%>















