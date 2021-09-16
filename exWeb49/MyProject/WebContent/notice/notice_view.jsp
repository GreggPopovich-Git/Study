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
	<c:if test="${!empty vo.filename}">
	<div class="sub-view-bottom">
		<font size="5">첨부파일 | </font><a href="" class="btn-modify">${vo.filename}</a>
	</div>
	</c:if>
	<div class="sub-view-bottom">
	<c:if test="${sessionvo.userid == 'administer'}">
		<a href="notice_modify.do?idx=${vo.idx}" class="btn-modify">수정</a>&nbsp;&nbsp;
		<a href="javascript:void(0)" class="btn-delete" onclick="avent();">삭제</a>&nbsp;&nbsp;
	</c:if>
		<a href="notice.do" class="btn-list">목록</a>&nbsp;&nbsp;
	</div>
		
</div>
<script>
function avent(){
	if(confirm("삭제하시겠습니까?") == true) {
		location.href="notice_delete.do?idx=${vo.idx}";
	}else {
		return;
	}
}
</script>


<%@ include file="/include/footer.jsp"%>















