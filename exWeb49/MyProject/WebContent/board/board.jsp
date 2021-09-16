<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">자유게시판</h2>
		<div class="sub-search">
			<form name="board_search" method="post" action="board.do" onsubmit="return check()">
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
			<caption class="readonly">자유게시판</caption>
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
					<th>날짜</th>
					<th>조회수</th>
				</tr>
				<c:if test="${empty list}">
					<tr>
						<td colspan="6">등록 된 게시물이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${!empty noticelist}">
					<c:forEach var="notice" items="${noticelist}">
						<tr style="background-color:#BCB8B8">
							<td><b>공지</b></td>
							<td class="tleft"><a href="notice_view.do?idx=${notice.idx}"><center>${notice.subject}</center></a></td>
							<td>${notice.name}</td>
							<td>${notice.regdate}</td>
							<td>${notice.readcnt}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${!empty list}">
					<c:forEach var="board" items="${list}">
						<tr>
							<td>${listcount}</td>
							<td class="tleft"><a href="board_view.do?idx=${board.idx}"><center>${board.subject}</center></a></td>
							<td>${board.name}</td>
							<td>${board.regdate}</td>
							<td>${board.readcnt}</td>
						</tr>
						<c:set var="listcount" value="${listcount-1}" />
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
		<div class="paging">
			${pageSkip}
			<a href="board_write.do" class="btn-write">글쓰기</a>
		</div>

</div>

<script>
	function check() {
		if(board_search.key.value=="") {
			alert("검색단어입력하세요");
			board_search.key.focus;
			return false;
		}
		return true;
	}
</script>

<%@ include file="/include/footer.jsp"%>















