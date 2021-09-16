<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>
<script src="/css/summernote-lite.js"></script>
<script src="/css/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/css/summernote-lite.css">
<c:if test="${writerow==1}">
	<script>
		alert("글이 등록되었습니다.");
		location.href = "board.do";
	</script>
</c:if>
<c:if test="${writerow==0}">
	<script>
		alert("등록에 실패 하였습니다.");
		history.back();
	</script>
</c:if>
<c:if test="${writerow==-1}">
	<script>
		alert("갤러리 입니다. 사진을 하나 이상 등록해주세요.");
		history.back();
	</script>
</c:if>
<c:if test="${writerow==-2}">
	<script>
		alert("사진 용량이 너무 큽니다. 다시 등록해주세요.");
		history.back();
	</script>
</c:if>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">자유게시판</h2>
	</div>
	
	<div class="write-form">
	<form name="my" method="post" action="board_write.do">
		<table summery="자유게시판 글쓰기 테이블 입니다">
			<caption class="readonly">자유게시판 입력폼</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="subject"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="name" value="${sessionvo.name}"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pass"></td>
					</tr>
					<tr>
					
						<th>내용</th>
						<td><textarea id="summernote" rows="10" name="contents"></textarea></td>
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
		alert("글을 등록합니다.");
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















