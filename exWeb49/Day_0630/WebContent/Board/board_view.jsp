<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*, java.util.*" %>

<%
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "jsl49";
	String myPass = "ehfkdl12";
%>

<%
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL, myID, myPass);
	} catch(Exception e) {
		e.printStackTrace();
	}
	// 조회수 증가
	String query1 = "update tbl_board set readcnt = readcnt + 1 where idx = ?";
	pstmt = conn.prepareStatement(query1);
	pstmt.setInt(1, idx);
	pstmt.executeUpdate();
	
	String query = "select * from tbl_board where idx = ?";
	pstmt = conn.prepareStatement(query);
	pstmt.setInt(1, idx);
	rs = pstmt.executeQuery();
	rs.next();
%>
 <html>
 <head><meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
   <title>게시판 내용 보기</title>
   <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>
	<script>
	   	function board_del(idx) {
			window.open("board_delete.jsp?idx=" + idx, "board_delete", "width = 300, height = 200");
			
	   	}
   </script>
 </head>
 <body topmargin="0" leftmargin="0">
   <table border="0" width="800">
     <tr>
       <td width="20%"  height="500" bgcolor="#ecf1ef" valign="top">

		 <!--  다음에 추가할 부분 -->

	   </td>
       <td width="80%" valign="top">&nbsp;<br>
         <table border="0" width="90%" align="center">
           <tr>
             <td colspan="2"><img src="./img/bullet-01.gif"> 
              <font color="blue" size="3">자 유 게 시 판</font><font size="2"> - 글읽기</font></td>
           </tr>
         </table>
       <p>
       <table border="0" width="90%" align="center" cellspacing="0"  style="border-width:1px;border-color:#0066cc;border-style:outset;">
         <tr bgcolor="e3e9ff">
           <td class="title">
             <img src="./img/bullet-04.gif"> <font size="2" face="돋움"><%= rs.getString("subject") %></font>
           </td>
         </tr>
         <tr>
           <td class="content">
             <p align="right"><font size="2" face="돋움">
              <a class="list"><%= rs.getString("regdate") %></a> / <font size="2" face="돋움"><a href="mailto:<%= rs.getString("email") %>"><%= rs.getString("name") %></a> / <%= rs.getInt("readcnt") %>번 읽음</font>
             <p><%= rs.getString("contents").replace("\n", "<br>") %><p><!--contents의 내용을 <BR>태그로 처리-->
           </td>
         </tr>
       </table>
  
      <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 답변, 수정, 삭제, 목록보기 ****-->
      <p align="center">
      <font size="2">
       <!-- 새글쓰기 -->
       <a href="board_write.jsp">
       <img src="./img/write.jpg" border="0"></a>&nbsp;&nbsp;
	   <!-- 답글쓰기 -->
       <a href="">
       <img src="./img/reply.gif" border="0"></a>&nbsp;&nbsp;
	   <!-- 수정하기 -->
       <a href="board_modify.jsp?idx=<%= idx %>">
       <img src="./img/edit.gif" border="0"></a>&nbsp;&nbsp;
         <!-- 삭제하기 -->
       <a href="javascript:board_del(<%= idx %>)"><img src="./img/del.gif" border="0"></a>&nbsp;&nbsp;
       <!-- 목록보기 -->
       <a href="board_list.jsp"><img src="./img/list-2.gif" border="0"></a>&nbsp;&nbsp;
      </font>
    </td>
  </tr>
  </table>
  </body>
  </html>

