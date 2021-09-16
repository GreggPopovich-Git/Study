<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, model.board.*" %>

<%
	int idx = Integer.parseInt(request.getParameter("idx"));
	int nowpage = Integer.parseInt(request.getParameter("page"));
	String pass = request.getParameter("pass");
	BoardDAO dao = BoardDAO.getInstance();
	int row = dao.delete(idx, pass);
	if(row == 1) { // 삭제
%>
<script>
	alert("삭제 성공");
	window.opener.location.replace("board_list.jsp?page=<%= nowpage %>");
	self.close();
</script>
<%
	} else if(row == 0) { // 실패
%>
<script>
	alert("삭제 실패");
	history.back();
</script>
<%
	} else { // 비밀번호틀림
%>
<script>
	alert("비밀번호 오류");
	history.back();
</script>
<%
	}
%>