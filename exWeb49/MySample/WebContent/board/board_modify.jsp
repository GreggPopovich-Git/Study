<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>
<script src="/css/summernote-lite.js"></script>
<script src="/css/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/css/summernote-lite.css">
<c:if test="${modifyrow==1}">
	<script>
		alert("글이 수정되었습니다.");
		location.href = "board.do";
	</script>
</c:if>
<c:if test="${modifyrow==0}">
	<script>
		alert("수정에 실패 하였습니다.");
		history.back();
	</script>
</c:if>
<c:if test="${modifyrow==-3}">
	<script>
		alert("비밀번호가 틀립니다.");
		history.back();
	</script>
</c:if>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">자유게시판</h2>
	</div>
	
	<div class="write-form">
	<form name="my" method="post" action="board_modify.do">
		<input type="hidden" name="idx" value="${vo.idx}">
		<table summery="자유게시판 글쓰기 테이블 입니다">
			<caption class="readonly">자유게시판 수정폼</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="subject" value="${vo.subject}"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="name" value="${vo.name}"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pass"></td>
					</tr>
					<tr>
					
						<th>내용</th>
						<td><textarea id="summernote" rows="10" name="contents">${vo.contents}</textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="전송" class="btn-write" style="cursor:pointer" onClick="formcheck()">
							<input type="button" value="목록"  class="btn-reset" style="cursor:pointer" onClick="javascript:location.href='board.do'">
						</td>
					</tr>
			</tbody>
		</table>
		</form>
	</div>
		
</div>

<script>
	function formcheck() {
		if(my.subject.value=="") {
			alert("제목을 입력하세요");
			my.subject.focus();
			return;
		}
		if(my.name.value=="") {
			alert("이름을 입력하세요");
			my.name.focus();
			return;
		}
		if(my.pass.value=="") {
			alert("비밀번호를 입력하세요");
			my.pass.focus();
			return;
		}
		if(my.contents.value=="") {
			alert("내용을 입력하세요");
			my.contnets.focus();
			return;
		}
		alert("글을 수정합니다.");
		my.submit();
	}
	$(document).ready(function() {
        $('#summernote').summernote({
        	height:400,
        	minHeight:null,
        	maxHeight:null,
        	lang: "ko-KR"
        }); 
	});
</script>

<%@ include file="/include/footer.jsp"%>















