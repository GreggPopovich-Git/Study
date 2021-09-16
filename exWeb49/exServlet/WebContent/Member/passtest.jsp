<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="exServlet.util.*" %>

<%
   String pass = "1234";
   String repass = UserSHA256.getSHA256(pass);
   out.print(repass);
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