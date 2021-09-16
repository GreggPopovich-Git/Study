<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${row==0}">
	<script>
		alert("비밀번호가 틀렸습니다.");
		history.back();
	</script>
</c:if>
<c:if test="${row==1}">
	<script>
		alert("회원정보를 수정합니다.");
	</script>
</c:if>
<%@ include file="/include/header.jsp"%>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">회원정보</h2>
	</div>
	
	<div class="write-form">
		<table summery="회원가입 글쓰기 테이블 입니다">
			<caption class="readonly">회원정보수정</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
			<form name="my" method="post" action="member_info.do" onsubmit="return formcheck();">
			<input type="hidden" name="userid" value="${sessionvo.userid}">
				<fieldset>
					<legend class="readonly">정보수정</legend>
					<tr>
						<th scope="row">
							<label for="id">아이디</label>
						</th>
						<td>
							<h3>${sessionvo.userid}</h3> 
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
						<td><input type="text" name="name" value="${sessionvo.name}" class="minput"></td>
					</tr>
					<tr>
						<th scope="row">이메일</th>
						<td>
							<input type="text" name="email1" class="email" value="${sessionvo.email.split('@')[0]}"> @
							<input type="text" name="email2" class="email" value="${sessionvo.email.split('@')[1]}" disabled>
							<select name="domain" style="height:40px;" onChange="email_change()">
								<option value="0">선택하세요</option>
								<option value="9">직접입력</option>
								<option value="gmail.com" <c:if test="${sessionvo.email.split('@')[1].equals('gmail.com')}"> selected </c:if>>gmail.com</option>
								<option value="naver.com" <c:if test="${sessionvo.email.split('@')[1].equals('naver.com')}"> selected </c:if>>naver.com</option>
								<option value="hanmail.net" <c:if test="${sessionvo.email.split('@')[1].equals('hanmail.net')}"> selected </c:if>>hanmail.net</option>
								<option value="yahoo.co.kr" <c:if test="${sessionvo.email.split('@')[1].equals('yahoo.co.kr')}"> selected </c:if>>yahoo.co.kr</option>
								<option value="nate.com" <c:if test="${sessionvo.email.split('@')[1].equals('nate.com')}"> selected </c:if>>nate.com</option>
							</select>
						</td>
					</tr>
					<tr>
						<th scope="row">전화번호</th>
						<td><input type="text" name="tel1" maxlength="3" value="${sessionvo.tel.split('-')[0]}" style="width:90px"> - <input type="text" name="tel2" maxlength="4" value="${sessionvo.tel.split('-')[1]}" style="width:110px"> - <input type="text" name="tel3" maxlength="4" value="${sessionvo.tel.split('-')[2]}" style="width:110px"></td>
					</tr>
					<tr>
						<th scope="row">회원가입일자</th>
						<td>${sessionvo.first_time}</td>
					</tr>
					<tr>
						<th scope="row">최종로그인</th>
						<td>${sessionvo.last_time}</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="수정" class="btn-write" style="cursor:pointer;" onClick="formcheck()">
							<input type="button" value="다시쓰기" class="btn-reset" style="cursor:pointer;" onClick="location.reload()">
						</td>
					</tr>
					</fieldset>
				</form>
			</tbody>
		</table>
	</div>
		
</div>

<script>
	function formcheck() {
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
</script>

<%@ include file="/include/footer.jsp"%>















