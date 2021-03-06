<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="success" value="0" />
<c:set var="fail" value="0" />
<c:forEach var="sel" items="${row}" varStatus="status">
	<c:if test = "${sel==1}">
		<c:set var="success" value="${success+1}" />
	</c:if>
	<c:if test = "${sel==0}">
		<c:set var="fail" value="${fail+1}" />
	</c:if>
</c:forEach>

<script>
	alert("${success} 개 성공, ${fail} 개 실패 했습니다.");
	location.href="admin_board_list.do";
</script>