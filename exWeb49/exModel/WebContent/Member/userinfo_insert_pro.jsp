<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "vo.member.*, dao.member.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id = "member" class = "vo.member.MemberVO">
	<jsp:setProperty name = "member" property = "*" />
</jsp:useBean>
<%
	String[] farr = request.getParameterValues("fa");
	String favorite = farr[0];
	for(int x = 1; x < farr.length; x++) {
		favorite = favorite + "," + farr[x];
	}
	member.setFavorite(favorite);
	MemberDAO dao = MemberDAO.getInstance();
	int row = dao.memberInsert(member);
	if(row == 1) {
		response.sendRedirect("userinfo_list.jsp");
	} else {
		response.sendRedirect("userinfo_insert.jsp");
	}
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