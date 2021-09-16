<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>

<%
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String myURL = "jdbc:oracle:thin:@localhost:1521:xe";
	String myID = "jsl49";
	String myPass = "ehfkdl12";
%>

<%
	request.setCharacterEncoding("utf-8");
	int idx= Integer.parseInt(request.getParameter("idx"));
	String pass1 = request.getParameter("pass");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL, myID, myPass);
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	String query = "select pass from tbl_board where idx = ?";
	pstmt = conn.prepareStatement(query);
	pstmt.setInt(1, idx);
	rs = pstmt.executeQuery();
	rs.next();
	String dbPass = rs.getString("pass");
	
	int row = 0;
	if(dbPass.equals(pass1)) {
		query = "delete from tbl_board where idx = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, idx);
		row = pstmt.executeUpdate();
	}

	if (row == 1) {
%>
<script>
	window.opener.location.replace("board_list.jsp");
	self.close();
</script>
<% 
	} else {
%>
<script>
	alert("비밀번호 오류 ");
	history.back();
</script>
<%
	}
%>