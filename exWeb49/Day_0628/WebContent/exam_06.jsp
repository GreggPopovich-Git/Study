<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String[] name = {"김학생", "이학생", "박학생", "장학생", "윤학생", 
			"강학생", "오학생", "유학생", "강학생", "이학생"};
	int sum() {
		int tot = 0;
		for (int x = 1; x <= 100; x++) {
			tot += x;
		}
		return tot;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = 1 width = 500>
		<tr>
			<td width = 10%>번호</td><td width = 20%>이름</td><td>주소</td>
		</tr>
<% 
	for(int x = 0; x < 100; x++) {
		if (x % 2 == 1) {
%>
		<tr>
			<td><%= x %></td><td></td><td>대전 중구 오류동 182</td>
		</tr>
<%
		} 
	}
%>		
	</table>
	합계 : <%= sum() %>
</body>
</html>