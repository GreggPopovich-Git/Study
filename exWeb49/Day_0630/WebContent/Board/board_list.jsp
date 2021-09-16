<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*, java.util.*" %>
<%
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "jsl49";
	String myPass = "ehfkdl12";
%>

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL, myID, myPass);
	} catch(Exception e) {
		e.printStackTrace();
	}
	pstmt = conn.prepareStatement("select count(*) from tbl_board");
	rs = pstmt.executeQuery();
	int count = 0;
	if(rs.next())
		count = rs.getInt(1);
	pstmt = conn.prepareStatement("select * from tbl_board order by idx desc");
	rs = pstmt.executeQuery();
%>

<html>
<head><title>게시판 읽기</title>
<link rel="stylesheet" type="text/css" href="/stylesheet.css">
<style type="text/css">
  a.list {text-decoration:none;color:black;font-size:10pt;}
</style>

</head>
<body bgcolor="#FFFFFF" topmargin="0" leftmargin="0">
<table border="0" width="800">
  <tr>
    <td width="20%" height="500" valign="top" bgcolor="#ecf1ef">

	<!-- 다음에 추가할 부분 --></td>

	<td width="80%" valign="top">	
		<br>
    <table border="0" cellspacing="1" width="100%" align="center">
      <tr>
        <td colspan="7" align="center" valign="center" height="20">
        <font size="4" face="돋움" color="blue">
        <img src="./img/bullet-01.gif"> <b>자 유 게 시 판</b></font></td></tr>
      <tr>
        <td colspan="5" align="right" valign="middle" height="20">
		<font size="2" face="고딕">전체 : <b><%= count %></b>건 - 1/ 2 Pages</font></td></tr>
 	   <tr bgcolor="e3e9ff">
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">번 호</font></td>
 	      <td width="50%" align="center" height="20"><font face="돋움" size="2">제 목</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">글쓴이</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">작성일</font></td>
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">조회수</font></td>
 	   </tr>
<%
		while(rs.next()) {
%>
		<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
			<td align="center" height="25">
			<font face="돋움" size="2" color="#000000"><%= rs.getInt("idx") %></font></td>
			<td align="left" height="20">&nbsp;
				<font face="돋움" size="2" color="#000000">
				<a href = "board_view.jsp?idx=<%= rs.getInt("idx") %>"><%= rs.getString("subject") %></a></td>
					<td align="center" height="20"><font face="돋움" size="2">
					<a class="list" href="mailto:<%= rs.getString("email") %>"><%= rs.getString("name") %></a></font></td>
				<td align="center" height="20"><font face="돋움" size="2"><%= rs.getString("regdate") %></font></td>
				<td align="center" height="20"><font face="돋움" size="2">
				<%= rs.getString("readcnt") %></font></td>
		</tr>
<%
		}
%>
<%
		if (count == 0) {
%>
		<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
          <td align="center" height="25" colspan = "5">
          <font face="돋움" size="2" color="#000000">등록된 글이 없습니다.</font>
          </td>
      </tr>
<%
		}
%>
	 <div align="center">
        <table width="700" border="0" cellspacing="0" cellpadding="5">
          <tr>&nbsp;</tr><tr>
             <td colspan="5">        
                <div align="center">[1][2][3]</div>
			  </td>
			 </tr>
		</table>

	<table width="600">
		<tr>
			<td width="25%"> &nbsp;</td>
			<td width="50%" align="center">
				<table>
					<form>	
					<!-- 검색어를 이용하여 글제목, 작성자, 글내용 중에 하나를 입력 받아 처리하기 위한 부분 -->
						<tr>
							<td>
								<select name="search">
									<option value="">글제목</option>
									<option value="">작성자</option>
									<option value="">글내용</option>
								</select>
							</td>
							<td> <input type="text" size=20 name=""></td>
							<td> <a href="#"><img src="./img/search2.gif" border="0" onClick = ""></a></td>
						</tr>
					</form>
				</table>
			</td>
			<td width="25%" align="right">
			<a href="board_write.jsp"><img src="./img/write.gif" border="0"></a>
			</td>
		</tr>
	</table>
</body>
</html>

