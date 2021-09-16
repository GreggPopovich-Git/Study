<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String email = request.getParameter("email");
	String domain = request.getParameter("domain");
	String gender = request.getParameter("gender");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String[] interests = request.getParameterValues("interests");
	String feel = request.getParameter("feel");

	out.print("idx : " + idx + "<br>");
	out.print("이름 : " + name + "<br>");
	out.print("아이디 : " + id + "<br>");
	out.print("비밀번호 : " + pass + "<br>");
	out.print("이메일 : " + email + "@" + domain + "<br>");
	out.print("성별 : " + gender + "<br>");
	out.print("전화번호 : " + tel1 + "-" + tel2 + "-" + tel3 + "<br>");
	out.print("관심분야 : ");
	if(interests != null) {
		for (String a : interests) {
			out.print(a + " ");
		}
	}
	out.print("<br>");
	out.print("소감 : " + feel);
	
	int row = 1;
	if (row == 1) {
%>
	<script>
		location.href = "Guest/guest_view.jsp?idx=<%=idx%>";
		alert("회원가입 성공");
	</script>
<%
	}else {
%>
	<script>
		alert("잠시 후 다시....");
		history.back();
	</script>
<%
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