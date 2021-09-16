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
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
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
	String query = "insert into tbl_guest(idx, name, pass, subject, contents) values(tbl_guest_seq_idx.nextval,?,?,?,?)";
	pstmt = conn.prepareStatement(query);
	pstmt.setString(1, name);
	pstmt.setString(2, pass);
	pstmt.setString(3, subject);
	pstmt.setString(4, contents);
	
	int row = pstmt.executeUpdate();
	response.sendRedirect("guest_list.jsp");
%>

