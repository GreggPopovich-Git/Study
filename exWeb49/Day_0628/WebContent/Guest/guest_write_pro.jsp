<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	out.print("name : " + name + "<br>");
	out.print("pass : " + pass + "<br>");
	out.print("subject : " + subject + "<br>");
	out.print("contents : " + contents + "<br>");
%>

