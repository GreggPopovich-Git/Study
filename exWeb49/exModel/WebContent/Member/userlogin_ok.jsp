<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "vo.member.*, dao.member.*, java.util.*" %>

<%
	MemberDAO dao = MemberDAO.getInstance();
	int row = dao.userLogin(request.getParameter("userid"), request.getParameter("passwd"));
	if (row == 0) {
%>
<script>
	alert("비밀번호가 다릅니다.");
	history.back();
</script>
<%
	} else if (row == -1) {
%>
<script>
	alert("아이디가 존재하지 않습니다.");
	history.back();
</script>
<%
	}
%>
<HTML>
<TITLE>본 사이트에 오신 것을 환영합니다..</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
-->
</STYLE>
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src=./Member/img/h_b02.gif></td>
    <td align=center><FONT COLOR="#FFFFFF"><b>로그인 성공</b></FONT></td>
    <td align=right><img src=./Member/img/f_b03.gif></td>
  </tr>
</table>
<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
<TR BGCOLOR=#948DCF>
  <TD>
    <TABLE CELLPADDING=4 CELLSPACING=1 BORDER=0 WIDTH=330>
  	  <TR BGCOLOR="#FFFFFF">
        <TD ALIGN="center">
          <%= request.getParameter("userid") %>님 환영합니다.<br><br>
        </TD>
      </TR>
    </TABLE>
 </TD>
</TR>
</TABLE>

<TABLE CELLPADDING=0 CELLSPACING=0 BORDER=0 WIDTH=330>
  <TR BGCOLOR=#7AAAD5>
    <td align=left><img src=./Member/img/h_b04.gif></td>
    <td align=right><img src=./Member/img/h_b05.gif></td>
  </tr>
</table>

<br><br>
<table cellpadding=0 cellspacing=0 border=0 width=330>
  <tr>
    <td align="center">
      <a href="userinfo_modify.jsp?userid=<%= request.getParameter("userid") %>">[자기정보수정]</a>
      <a href="logout.jsp">[로그아웃]</a>

	</td>
  </tr>
</table>

</BODY>
</HTML>