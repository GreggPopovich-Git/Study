<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<html>
<head>
<title>관리자</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style type="text/css"> 
<!-- 
body,td,tr,table{font-size:9pt; font-family:tahoma;color:#000000;line-height:160%;} 

A:link {font-family:tahoma;font-size:9pt;color:#000000;text-decoration:none;} 
A:visited {font-family:tahoma;font-size:9pt;color:#000000;text-decoration:none;} 
A:active {font-family:tahoma;font-size:9pt;color:#000000;text-decoration:none;} 
A:hover {font-family:tahoma;font-size:9pt;color:#000000;text-decoration:underline;} 
--> 
</style> 
</HEAD>
<BODY topmargin=0 leftmargin="0" marginwidth="0" marginheight="0">
  <TABLE WIDTH=100% height=30 border=0 bgcolor="#FFCC66">
    <TR> 
			<TD width="20"></TD>
			<td width="100"> 
        <p><a href="notice_list.do">[공지사항 관리]</a></p>
      </td>
			<TD width="100"> 
        <P><a href="board_list.do">[게시판 관리]</a></P>
      </TD>
			<TD width="100"> 
        <P><a href="">[포토갤러리 관리]</a></P>
      </TD>
			<TD width="100"> 
        <P><a href="pds_list.do">[자료실 관리]</a></P>
      </TD>
			<TD width="100"> 
        <P><a href="guest_list.do">[방명록 관리]</a></P>
      </TD>
			<TD width="100"> 
        	<P><a href="admin_list.do">[관리자 관리]</a></P>
      </TD>
<c:if test="${!empty admin}">      
      <TD width="100"> 
        <P><a href="adminlogout.do">로그아웃${admin.adminname}</a></P>
      </TD>
</c:if>
      
    </TR>
  </TABLE>
</body>
</html>
