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
	int idx = Integer.parseInt(request.getParameter("idx"));
	String email = request.getParameter("email");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");

	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL, myID, myPass);
	} catch(Exception e) {
		e.printStackTrace();
	}
	String query = "update tbl_board set subject = ?, email = ?, contents = ?, regdate = sysdate where idx = ?";
	pstmt = conn.prepareStatement(query);
	pstmt.setString(1, subject);
	pstmt.setString(2, email);
	pstmt.setString(3, contents);
	pstmt.setInt(4, idx);
	
	int row = pstmt.executeUpdate();
	response.sendRedirect("board_list.jsp");
%>
