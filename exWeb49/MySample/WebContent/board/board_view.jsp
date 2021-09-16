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
	
	<div class="sub-view-bottom">
		<a href="board_modify.do?idx=${vo.idx}" class="btn-modify">수정</a>&nbsp;&nbsp;
		<a href="javascript:void(0)" class="btn-delete" onclick="avent();">삭제</a>&nbsp;&nbsp;
		<a href="board.do" class="btn-list">목록</a>&nbsp;&nbsp;
	</div>
		
</div>
<script>
function avent(){
	if(confirm("삭제하시겠습니까?") == true) {
		window.open("board_delete.do?idx=${vo.idx}", "게시물 삭제", "width=550, height=220");
	}else {
		return;
	}
}
</script>


<%@ include file="/include/footer.jsp"%>















