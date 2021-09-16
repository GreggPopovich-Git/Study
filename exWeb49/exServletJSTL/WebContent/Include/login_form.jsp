<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <title>Login</title>
<script>
	function check_login() {
		if(login_form.userid.value == "") {
			alert("아이디를 입력해주세요.");
			login_form.userid.focus();
			return;
		}
		if(login_form.passwd.value == "") {
			alert("비밀번호를 입력해주세요.");
			login_form.passwd.focus();
			return;
		}
		login_form.action = "login_form.do";
		login_form.submit();
	}
	function autoSubmit() {
		if (event.keyCode == 13) {
			check();
		}
	}
</script>
 </head>

 <body>
   <c:if test="${empty sessionScope.vo}">
<form name="login_form" action="" method="post" onSubmit="return false;">
   <table width="100%" height="120" border="0">

     <tr>
       <td colspan="2" bgcolor="#6FA0E" height="20" align="center">
         <font size="2" color="white"><b>Member Login</b></font>
       </td>
     </tr>
     <tr>
       <td ><font size="2">아 이 디</font></td>
       <td ><input type="text" size="10" name="userid"></td>
     </tr>
     <tr>
       <td><font size="2">비밀번호</font></td>
			 <td>
         <input type="password" size="10" name="passwd" onKeyUp="autoSubmit()">
       </td>
     </tr>
     <tr>
       <td><input type="image" src="Include/img/login1.gif" border="0" onClick="check_login()"></td>
			 <td>
           <a href="userinfo_insert.do"><img src="Include/img/regist.gif" border="0"></a>
       </td>
     </tr>
 </table>
</form>
 </c:if>
 <c:if test="${sessionScope.vo.userid == 'admin'}">
 <table width="100%" height="120" border="0">
   <tr>
     <td bgcolor="#6FA0E" align="center" height="20">
       <font size="2" color="white">${sessionScope.vo.name} 님!</font>
     </td>
   </tr>
   <tr>
     <td align="center">
       <font size="2">
       <a href="">관리자 페이지</a><br>
       <a href="logout.do">로그오프</a><br>
       <a href="userinfo_modify.do">회원정보수정</a><br>
       </font>
     </td>
   </tr>
 </table>
 </c:if>
<c:if test="${!empty vo && (sessionScope.vo.userid != 'admin')}">
 <table width="100%" height="120" border="0">
   <tr>
     <td bgcolor="#6FA0E" align="center" height="20">
       <font size="2" color="white">${vo.name} 님!</font>
     </td>
   </tr>
   <tr>
     <td align="center">
       <font size="2">
       <a href="logout.do">로그오프</a><br>
       <a href="userinfo_modify.do">회원정보수정</a><br>
       <a href="">회원탈퇴</a>
       </font>
     </td>
   </tr>
 </table>
</c:if>
 </body>
 </html>
