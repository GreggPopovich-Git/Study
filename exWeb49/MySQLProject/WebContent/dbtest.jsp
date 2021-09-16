<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "util.*, java.sql.*" %>

<%
	Connection conn = MySQLManager.getConnection();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MySQL 연결테스트</h1>
	<h3><%= conn %></h3>
</body>
</html>