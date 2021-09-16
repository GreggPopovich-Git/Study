<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "exServlet.model.member.*, java.util.*" %>

<%
	int idcheck = 0;
	if (request.getAttribute("idcheck") != null) {
		idcheck = (int) request.getAttribute("idcheck");
	}
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
		if(idform.userid.value == "") {
			alert("아이디를 입력해주세요");
			idform.userid.focus();
			return;
		} else {
			var useridExp = /^([a-zA-Z]{1})([a-zA-Z0-9]{4,9})$/;
			if(!useridExp.test(idform.userid.value)) {
				alert("아이디 유효하지 않음");
				idform.userid.focus();
				return;
			}
		}
		idform.action = "id_check";
		idform.submit();
	}
	function win_close() {
		var row = '${idcheck}';
		if(row == 1) {
			self.close();
		} else {
			opener.member.userid.value = '${userid}';
			self.close();
		}
	}
</script>
</HEAD>
<BODY bgcolor="#FFFFFF">
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="Member/img/u_b02.gif"></td>
    <td align=center><FONT COLOR="#FFFFFF"><b>아이디 중복 체크</FONT></td>
    <td align=right><img src="Member/img/u_b03.gif"></td>
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
	if(request.getParameter("userid") == null) {
%>
	<br><FONT FACE="굴림"><B>아이디를 입력해주세요.</B></FONT><br>
	<INPUT NAME=userid type=text size=16 maxlength=16>
	<a href = "javascript:check()"><img src="Member/img/u_bt08.gif" border=0 vspace=0></a>
<%
	} else if(idcheck == 0) {
%>
         <br><FONT FACE="굴림"><B>사용 가능합니다.</B></FONT><br>
         <BR><FONT COLOR="#483cae"><b>${userid}</b></FONT>는 아직 사용되지 않은 아이디입니다.
         <BR><FONT COLOR="#483cae"><b>${userid}</b></FONT>로 등록하셔도 됩니다.
<%
	} else {
%>
         <br><font face="굴림"><b>죄송합니다</b></font><br>
    	 <BR><FONT COLOR="#483cae"><b>${userid}</b></FONT>는 이미 사용 중인 아이디입니다<br>
    	다른 아이디를 사용하여 주십시오.
    	<INPUT NAME=userid type=text size=16 maxlength=16>
    	<a href = "javascript:check()"><img src="Member/img/u_bt08.gif" border=0 vspace=0></a>
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
    <td align=left><img src="Member/img/u_b04.gif"></td>
    <td align=right><img src="Member/img/u_b05.gif"></td>
  </tr>
  <tr>
    <td colspan=3 align=center>
      <a href = "javascript:win_close()"><img src="Member/img/u_bt13.gif" border=0 vspace=5></a>
    </td>
  </tr>
</table>
</BODY>
</HTML>