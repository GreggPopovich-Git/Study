<%@ page contentType="text/html; charset=UTF-8" %>

<%
	int nowpage = Integer.parseInt(request.getParameter("page"));
	int idx = Integer.parseInt(request.getParameter("idx"));
	int row = 99;
	if(request.getParameter("row") != null) {
		row = Integer.parseInt(request.getParameter("row"));
	}
	if(row == 0) {
%>
<script>
	alert("비밀번호가 틀렸습니다.");
	self.close();
</script>
<%
	} else if(row == 1){
%>
<script>
	alert("삭제되었습니다.");
	opener.location.href="board_list?page=<%= nowpage %>";
	self.close();
</script>
<%
	}
%>
<html>
<head><title>게시글 삭제</title>
 <link rel="stylesheet" type="text/css" href="/stylesheet.css">
 </head>
 <body>
 <form name="delete" method="post" action="board_delete">
 <input type="hidden" name="idx" value="<%= idx %>">
 <input type="hidden" name="page" value="<%= nowpage %>">
   <table border="0" cellpadding="0" cellspacing="0" width="300" align="center">
     <tr>
       <td height="50">
       <img src="img/bullet-05.gif"><b><font size="3" color="red">잠깐 !!</font></b></td></tr>
     <tr>
       <td valign="middle" height="30">
       <font size="2" face="돋움">게시물은 작성하신 분만 삭제할 수 있습니다.<br>
       글작성시 입력한 비밀번호를 입력해 주세요...</font></td></tr>
     <tr>
       <td valign="middle" height="40">
       <font size="2" face="돋움">
       비밀번호 <input type="password" name="pass" size="8"></font>
       <input type="submit" value="삭제">
       <input type="button" value="닫기" onClick="self.close()"></td></tr>
   </table>
   </form>
 </body>
 </html>
