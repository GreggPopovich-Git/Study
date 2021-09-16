<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">질문답변</h2>
		<div class="sub-search">
			<form name="my" method="post" action="qasearch.do" onsubmit="return check()">
				<select name="sel" class="sel">
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="cont" class="text">
				<input type="submit" value="검색" class="btn">
			</form>
		</div>
	</div>
	
	<div class="content-body">
		<table class="qatable">
			<caption class="readonly">질문답변</caption>
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
					<th>답변상태</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
				<c:if test="${!empty noticelist}">
					<c:forEach var="notice" items="${noticelist}">
						<tr style="background-color:#BCB8B8">
							<td><b>공지</b></td>
							<td class="tleft"><a href="notice_view.do?idx=${notice.idx}"><center>${notice.subject}</center></a></td>
							<td>${notice.name}</td>
							<td></td>
							<td>${notice.regdate}</td>
							<td>${notice.readcnt}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty list}">
					<tr>
						<td colspan="6">등록된 게시물이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${!empty list}">
					<c:forEach var="qa" items="${list}">
						<tr>
							<td>${listcount}</td>
							<td class="tleft"><a href="qaview.do?idx=${qa.idx}"><center>${qa.subject}</center></a></td>
							<td>${qa.name}</td>
							<c:if test="${empty qa.answer}">
							<td><span class="red">답변대기</span></td>
							</c:if>
							<c:if test="${!empty qa.answer}">
							<td><span class="gray">답변완료</span></td>
							</c:if>
							<td>${qa.regdate}</td>
							<td>${qa.readcnt}</td>
						</tr>
						<c:set var="listcount" value="${listcount-1}" />
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
		
		
		<div class="paging">
				${pageSkip}
			<a href="qawrite.do" class="btn-write">글쓰기</a>
		</div>

</div>

<script>
	function check() {
		if(my.cont.value=="") {
			alert("검색단어입력하세요");
			my.cont.focus;
			return false;
		}
		return true;
	}
</script>

<%@ include file="/include/footer.jsp"%>















