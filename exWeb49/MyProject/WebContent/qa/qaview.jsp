<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-view-title">${vo.subject}</h2>
		<p class="sub-view-wd">${vo.name} | ${vo.regdate}</p>
	</div>
	<div class="sub-view-contnet">
		${vo.contents}
	</div>
	<c:if test="${!empty vo.answer}">
		<h3>답변</h3>
		<div class="sub-view-contnet">
			${vo.answer}
		</div>
	</c:if>
	<div class="sub-view-bottom">
	<c:if test="${sessionvo.userid == 'administer'}">
		<c:if test="${empty vo.answer}">
			<a href="qareply.do?idx=${idx}" class="btn-modify">답변</a>&nbsp;&nbsp;
		</c:if>
		<c:if test="${!empty vo.answer}">
			<a href="qareply.do?idx=${idx}" class="btn-modify">답변수정</a>&nbsp;&nbsp;
		</c:if>
	</c:if>
		<a href="javascript:void(0)" class="btn-delete" onclick="avent();">삭제</a>&nbsp;&nbsp;
		<a href="qa.do" class="btn-list">목록</a>&nbsp;&nbsp;
	</div>
		
</div>
<script>
function avent(){
	if(confirm("후회안해? 삭제?") == true) {
		location.href="qadelete.do";
	}else {
		return;
	}
}
</script>


<%@ include file="/include/footer.jsp"%>















