<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	alert("${success} 명에게 메일을 보냈습니다.");
	location.href="member_list.do";
</script>