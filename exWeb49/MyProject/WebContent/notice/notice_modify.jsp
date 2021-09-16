<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>
<c:if test="${modifyrow==1}">
	<script>
		alert("공지사항이 수정되었습니다.");
		location.href="notice_view.do?idx=${vo.idx}";
	</script>
</c:if>
<c:if test="${modifyrow==0}">
	<script>
		alert("수정에 실패했습니다.");
		history.back();
	</script>
</c:if>
<script src="/css/summernote-lite.js"></script>
<script src="/css/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/css/summernote-lite.css">
<c:if test="${sessionvo.userid != 'administer'}">
	<script>
		alert("잘못된 접근입니다.");
		history.back();
	</script>
</c:if>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">공지사항</h2>
	</div>
	
	<div class="write-form">
	<form name="notice" method="post" action="notice_modify_pro.do" enctype="multipart/form-data">
	<input type="hidden" name="idx" value="${vo.idx}">
	<input type="hidden" name="oldfilename" value="${vo.filename}">
		<table>
			<caption class="readonly">공지사항 입력폼</caption>			
			<colgroup>
				<col class="w20">
				<col class="w80">
			</colgroup>
			<tbody>
					<tr>
						<th>게시판</th>
						<td><select name="boardtype" style="height:40px;" onChange="type_change()">
								<option value="">선택하세요</option>
								<option value="board" <c:if test="${vo.boardtype=='board'}"> selected </c:if>>자유게시판</option>
								<option value="qa" <c:if test="${vo.boardtype=='qa'}"> selected </c:if>>질문답변</option>
								<option value="pds" <c:if test="${vo.boardtype=='pds'}"> selected </c:if>>자료실</option>
							</select></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="subject" value="${vo.subject}"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea id="summernote" rows="10" name="contents">${vo.contents}</textarea></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="name" value="${vo.name}"></td>
					</tr>
					<tr>
						<th>첨부</th>
						<td><input type="file" name="filename"value="">${vo.filename}</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="전송" class="btn-write" onClick="formcheck()">
							<input type="button" value="목록"  class="btn-reset" onClick="javascript:location.href='portfolio.do'">
						</td>
					</tr>
				
			</tbody>
		</table>
	</form>
	</div>
		
</div>

<script>
	function formcheck() {
		if(notice.boardtype.value=="") {
			alert("게시판을 선택 하세요");
			notice.boardtype.focus();
			return;
		}
		if(notice.subject.value=="") {
			alert("제목을 입력하세요");
			notice.subject.focus();
			return;
		}
		if(notice.name.value=="") {
			alert("이름을 입력하세요");
			notice.name.focus();
			return;
		}
		if(notice.contents.value=="") {
			alert("내용을 입력하세요");
			notice.contnets.focus();
			return;
		}
		alert("글을 수정합니다.");
		notice.submit();
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




