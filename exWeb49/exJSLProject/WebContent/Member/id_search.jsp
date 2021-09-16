<%@ page contentType="text/html; charset=UTF-8" %>

<%
	String userid = "";
	int length = 0;
	if(request.getAttribute("userid") != null) {
		userid = (String)request.getAttribute("userid");
		length = (int)request.getAttribute("length");
	}
%>
<HTML>
<HEAD>
<TITLE>아이디 찾기</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<STYLE TYPE="text/css">
<!--
body {font-family: 돋움, Verdana; font-size: 9pt;}
td   {font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000;} 
--->
</STYLE>
<script>
	function search() {
		if(idsearch.name.value == "") {
			alert("이름을 입력해주세요");
			search.name.focus();
			return;
		}
		if(idsearch.email.value == "") {
			alert("이메일을 입력해주세요");
			search.name.focus();
			return;
		}else{
	        var emailExp = /([\w~\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	        if(!emailExp.test(idsearch.email.value)){
	           alert("이메일이 유효하지 않음");
	           idsearch.email.focus();
	           return;
	        }
	     }
		idsearch.action = "id_search";
		idsearch.submit();
	}
</script>
</HEAD>
<BODY bgcolor="#FFFFFF">
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="img/u_b02.gif"></td>
    <td align=center><FONT COLOR="#FFFFFF"><b>아이디 찾기</b></FONT></td>
    <td align=right><img src="img/u_b03.gif"></td>
  </tr>
</table>
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
<TR BGCOLOR=#948DCF>
  <TD>
    <TABLE CELLPADDING=4 CELLSPACING=1 BORDER=0 WIDTH=330>
  	  <TR BGCOLOR="#FFFFFF">
        <TD ALIGN="center">
<%
	if(userid == "") {
%>
<form name="idsearch" method="post">
	<br><FONT FACE="굴림"><B>회원님의 이름을 입력해주세요.</B></FONT><br><br>
	<INPUT NAME=name type=text size=16 maxlength=5><br>
	<br><FONT FACE="굴림"><B>회원님의 이메일을 입력해주세요.</B></FONT><br><br>
	<INPUT NAME=email type=text size=16 maxlength=30><br><br>
	<a href = "javascript:search()"><img src="img/u_bt08.gif" border=0 vspace=0></a>
</form>
<%
	} else if(userid.equals("x")) {
%>
	<br><FONT FACE="굴림"><B>회원님의 아이디를 찾을 수 없습니다.</B></FONT><br><br>
<% 
	} else {
%>
	<br><FONT FACE="굴림"><B>회원님의 아이디는 <%= userid %><%for(int x = 0; x < length; x++)  { %>*<% } %> 입니다.</B></FONT><br><br>
<%
	}
%>
        </TD>
      </TR>
    </TABLE>
 </TD>
</TR>
</TABLE>
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src="img/u_b04.gif"></td>
    <td align=right><img src="img/u_b05.gif"></td>
  </tr>
  <tr>
    <td colspan=3 align=center>
      <a href = "javascript:self.close()"><img src="img/u_bt13.gif" border=0 vspace=5></a>
    </td>
  </tr>
</table>
</BODY>
</HTML>