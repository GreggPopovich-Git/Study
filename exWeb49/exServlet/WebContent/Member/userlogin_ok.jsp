<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.*, exServlet.model.member.*" %>
<%
	int row = (int)request.getAttribute("row");
	MemberVO vo = new MemberVO();
	if(row == -1) {
%>
<script>
	alert("해당 아이디가 없습니다.");
	history.back();
</script>
<%
	} else if (row == 0) {
%>
<script>
	alert("비밀번호가 틀립니다.");
	history.back();
</script>
<%
	} else {
		vo = (MemberVO) session.getAttribute("vo");
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
          <%= vo.getName() %>님 환영합니다.<br><br>
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
      <a href="userinfo_modify">[자기정보수정]</a>
      <a href="logout">[로그아웃]

	</td>
  </tr>
</table>

</BODY>
</HTML>