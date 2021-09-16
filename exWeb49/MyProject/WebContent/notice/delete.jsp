<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>
<c:if test="${deleterow==1}">
	<script>
		alert("삭제되었습니다.");
		location.href="notice.do";
	</script>
</c:if>
<c:if test="${deleterow==0}">
	<script>
		alert("삭제가 실패했습니다.");
		history.back();
	</script>
</c:if>
