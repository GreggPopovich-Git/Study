<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "model.member.*, model.member.*, java.util.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String idsearch = "";
	String email = "";
	if(request.getParameter("email") != null) {
		email = request.getParameter("email");
	}
	MemberDAO dao = MemberDAO.getInstance();
	idsearch = dao.idSearch(email);
%>
<HTML>
<HEAD>
<TITLE>사용자의 아이디를 체크합니다.</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
--->
</STYLE>
<script>
	function check() {
		if(idform.email.value == "") {
			alert("가입하신 이메일을 입력해주세요");
			idform.email.focus();
			return;
		} else {
			var useridExp = /([\w~\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
			if(!useridExp.test(idform.email.value)) {
				alert("이메일 유효하지 않음");
				idform.email.focus();
				return;
			}
		}
		idform.action = "id_search.jsp";
		idform.submit();
	}
	function win_close() {
		var idsearch = '<%= idsearch %>';
		if(idsearch == null) {
			self.close();
		} else {
			<%-- opener.loginf.userid.value = '<%= idsearch %>'; --%>
			self.close();
		}
	}
</script>
</HEAD>
<BODY bgcolor="#FFFFFF">
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="./img/u_b02.gif"></td>
    <td align=center><FONT COLOR="#FFFFFF"><b>아이디 찾기</b></FONT></td>
    <td align=right><img src="./img/u_b03.gif"></td>
  </tr>
</table>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
<TR BGCOLOR=#948DCF>
  <TD>
    <TABLE CELLPADDING=4 CELLSPACING=1 BORDER=0 WIDTH=330>
  	  <TR BGCOLOR="#FFFFFF">
        <TD ALIGN="center">
<form name="idform" method="post">
<%
	if(request.getParameter("email") == null) {
%>
	<br><FONT FACE="굴림"><B>이메일를 입력해주세요.</B></FONT><br>
	<INPUT NAME=email type=text size=30 maxlength=30>
	<a href = "javascript:check()"><img src="./img/u_bt08.gif" border=0 vspace=0></a>
<%
	} else if(idsearch != null) {
%>
         <br><FONT FACE="굴림"><B></B></FONT><br>
         <BR><FONT COLOR="#483cae">회원님의 아이디는 <b><%= idsearch.substring(0,3) %><% for(int x = 0; x < (idsearch.length()-3); x++) { %>*<% } %></b></FONT> 입니다.
<%
	} else {
%>
         <br><font face="굴림"><b>죄송합니다</b></font><br>
    	 <BR><FONT COLOR="#483cae"><b><%= email %></b></FONT>등록되지 않은 이메일입니다.<br>
    	이메일을 다시 입력해 주십시오.
    	<INPUT NAME=email type=text size=30 maxlength=30>
    	<a href = "javascript:check()"><img src="./img/u_bt08.gif" border=0 vspace=0></a>
<%
	}
%> 
		</form>
        </TD>
      </TR>
    </TABLE>
 </TD>
</TR>
</TABLE>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="./img/u_b04.gif"></td>
    <td align=right><img src="./img/u_b05.gif"></td>
  </tr>
  <tr>
    <td colspan=3 align=center>
      <a href = "javascript:win_close()"><img src="./img/u_bt13.gif" border=0 vspace=5></a>
    </td>
  </tr>
</table>
</BODY>
</HTML>