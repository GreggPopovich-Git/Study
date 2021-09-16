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
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">공지사항</h2>
		<div class="sub-search">
			<form name="notice_search" method="post" action="notice.do" onsubmit="return check()">
				<select name="search" class="sel">
					<option value="subject" <c:if test="${search=='subject'}">selected</c:if>>제목</option>
					<option value="contents" <c:if test="${search=='contents'}">selected</c:if>>내용</option>
					<option value="name" <c:if test="${search=='name'}">selected</c:if>>작성자</option>
				</select>
				<input type="text" name="key" class="text">
				<input type="submit" value="검색" class="btn">
			</form>
		</div>
	</div>
	
	<div class="content-body">
		<table class="qatable">
			<caption class="readonly">공지사항</caption>
			<colgroup>
				<col width="6%">
				<col width="48%">
				<col width="10%">
				<col width="15%">
				<col width="11%">
				<col width="10%">
			</colgroup>
			<tbody>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>게시판</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
				<c:if test="${empty list}">
					<tr>
						<td colspan="6">등록 된 공지사항이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${!empty list}">
					<c:forEach var="notice" items="${list}">
						<tr>
							<td>${listcount}</td>
							<td class="tleft"><a href="notice_view.do?idx=${notice.idx}"><center>${notice.subject}</center></a></td>
							<td>${notice.name}</td>
							<td><span  class="gray">
							<c:if test="${notice.boardtype == 'board'}">
								자유게시판
							</c:if>
							<c:if test="${notice.boardtype == 'pds'}">
								자 료 실
							</c:if>
							<c:if test="${notice.boardtype == 'qa'}">
								질문답변
							</c:if>
							</span></td>
							<td>${notice.regdate}</td>
							<td>${notice.readcnt}</td>
						</tr>
						<c:set var="listcount" value="${listcount-1}" />
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
		<div class="paging">
			${pageSkip}
			<c:if test="${sessionvo.userid == 'administer'}">
				<a href="notice_write.do" class="btn-write">글쓰기</a>
			</c:if>
		</div>

</div>

<script>
	function check() {
		if(notice_search.key.value=="") {
			alert("검색단어입력하세요");
			notice_search.key.focus;
			return false;
		}
		return true;
	}
</script>

<%@ include file="/include/footer.jsp"%>















