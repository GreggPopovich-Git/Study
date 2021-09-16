<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function test() {
		alert("AAAA");
	}
	function exam(idx) {
		a = confirm("등록할까요");
		document.write(a);
	}
</script>
</head>
<body>
	<a href = "javascript:test()">test 호출</a><br>
	<a href = "javascript:exam(10)">exam호출</a><br>
	<a href = "join.jsp">회원가입</a><br>
</body>
</html>