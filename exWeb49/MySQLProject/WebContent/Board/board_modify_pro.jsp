<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, model.board.*, model.board.*" %>

<%
	request.setCharacterEncoding("utf-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	int nowpage = Integer.parseInt(request.getParameter("page"));
	BoardVO vo = new BoardVO();
	vo.setIdx(idx);
	vo.setName(request.getParameter("name"));
	vo.setEmail(request.getParameter("email"));
	vo.setPass(request.getParameter("pass"));
	vo.setSubject(request.getParameter("subject"));
	vo.setContents(request.getParameter("contents"));
	
	BoardDAO dao = BoardDAO.getInstance();
	int row = dao.modify(vo);
	if(row == 1) {
		response.sendRedirect("board_list.jsp?page=" + nowpage);
	} else {
		response.sendRedirect("board_modify.jsp?page=" + nowpage);
	}
%>
