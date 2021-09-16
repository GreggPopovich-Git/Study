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
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		Class.forName(myDriver);
		conn = DriverManager.getConnection(myURL, myID, myPass);
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	
	String query = "delete from tbl_guest where idx=?";
	pstmt = conn.prepareStatement(query);
	pstmt.setInt(1, idx);
	int row = pstmt.executeUpdate();
	
	response.sendRedirect("guest_list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>