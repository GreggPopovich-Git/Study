<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>
<c:if test="${sessionvo.userid != 'administer'}">
	<script>
		alert("잘못된 접근입니다.");
	</script>
</c:if>
<c:if test="${answerrow == 1}">
	<script>
		alert("답변이 등록되었습니다.");
		location.href = "qaview.do?idx=${idx}";
	</script>
</c:if>
<c:if test="${answerrow == 0}">
	<script>
		alert("답변 등록에 실패했습니다.");
		history.back();
	</script>
</c:if>
<form name="reply" method="post">
<input type="hidden" name="idx" value="${idx}">
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-view-title">${vo.subject}</h2>
		<p class="sub-view-wd">${vo.name} | ${vo.regdate}</p>
	</div>
	<div class="sub-view-contnet">
		${vo.contents}
	</div>
	
	<div class="qareply" style="padding-bottom:30px;">
		<h2 style="padding-bottom:16px;">답변</h2>
		<textarea name="answer" style="width:100%; height:300px;"></textarea>
	</div>
	<div class="sub-view-bottom">
		<a href="javascript:send()" class="btn-modify">답변저장</a>&nbsp;&nbsp;
		<a href="qa.do" class="btn-list">목록</a>&nbsp;&nbsp;
	</div>
</div>
</form>

<script>
	function send() {
		if(reply.answer.value == "") {
			alert("답변을 입력해주세요.");
			reply.answer.focus();
			return;
		}
		reply.action = "qareply.do";
		reply.submit();
	}
</script>
<%@ include file="/include/footer.jsp"%>















