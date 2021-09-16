<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String irum = request.getParameter("irum");
	String pass = request.getParameter("pass");
	out.print("이름 : " + irum + "<br>");
	out.print("비번 : " + pass + "<br>");
%>
<!DOCTYPE html>
<html>
이름 : <%= irum %> <br>
비번 : <%= pass %> <br>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>exam_03.jsp 에서 넘어온 값입니다.</h3>
</body>
</html>