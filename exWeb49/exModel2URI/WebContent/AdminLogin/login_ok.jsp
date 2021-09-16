<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${row == -1}">
	<SCRIPT>
		alert("등록된 아이디가 없습니다")
		history.go(-1);
	</SCRIPT>
</c:if>
<c:if test="${row == 0}">
	<SCRIPT>
    	alert("비밀번호가 맞지 않습니다")
    	history.go(-1);
	</SCRIPT>
</c:if>
<c:if test="${row == 1}">
	<SCRIPT>
    	alert("로그인되었습니다")
    	location.href="/Admin/notice_list.do";
	</SCRIPT>
</c:if>

</body>
</html>