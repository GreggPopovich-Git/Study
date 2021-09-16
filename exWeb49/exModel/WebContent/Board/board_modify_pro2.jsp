<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, dao.board.*, vo.board.*" %>

<%
	request.setCharacterEncoding("utf-8");
	int nowpage = Integer.parseInt(request.getParameter("idx"));
	BoardVO vo = new BoardVO();
	vo.setIdx(nowpage);
	vo.setName(request.getParameter("name"));
	vo.setEmail(request.getParameter("email"));
	vo.setPass(request.getParameter("pass"));
	vo.setSubject(request.getParameter("subject"));
	vo.setContents(request.getParameter("contents"));
	
	BoardDAO dao = BoardDAO.getInstance();
	int row = dao.modify(vo);
	if(row == 1) {
		response.sendRedirect("board_list2.jsp?page=" + nowpage);
	} else {
		response.sendRedirect("board_modify2.jsp?page=" + nowpage);
	}
%>
