<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/include/header.jsp"%>


<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">갤러리</h2>
		<div class="sub-search">
			<form name="search_form" method="post" action="gallery.do" onsubmit="return check()">
				<select name="search" class="sel">
					<option value="subject" <c:if test="${search=='subject'}">selected</c:if>>제목</option>
					<option value="contents" <c:if test="${search=='contents'}">selected</c:if>>내용</option>
					<option value="name" <c:if test="${search=='name'}">selected</c:if>>작성자</option>
				</select>
				<input type="text" name="key" class="text" value="${key}">
				<input type="submit" value="검색" class="btn" style="cursor:pointer">
			</form>
		</div>
	</div>
	
		<ul class="sub-content">
			<c:if test="${empty list}">
				<center><h3>등록된 글이 없습니다.</h3></center>
			</c:if>
			<c:if test="${!empty list}">
				<table ${style}>
				<c:forEach var="gallery" items="${list}" varStatus="status" begin="0" end="3">
					<c:if test="${status.index mod 4 == 0}"><tr height="250"></c:if>
						<td width="100" style="padding-left:15px;">
						<a href="gallery_view.do?idx=${gallery.idx}"><img ${path[status.index]} width=200px height=200px></a>
						</td>
				</c:forEach>
				<c:forEach var="gallery" items="${list}" varStatus="status" begin="0" end="3">
					<c:if test="${status.index mod 4 == 0}"><tr height="80"></c:if>
						<td width="100" style="padding-left:15px;">
							<p class="p26">
								<a href="gallery_view.do?idx=${gallery.idx}">
									<span class="gallery-title"><b> &nbsp;&nbsp;${gallery.subject} </b></span>
								</a>
									<span class="hit"><font size="2" color="gray">조회수 : ${gallery.readcnt}</font></span>
							</p>
						</td>
				</c:forEach>
				<c:forEach var="gallery" items="${list}" varStatus="status" begin="4" end="7">
					<c:if test="${status.index mod 4 == 0}"><tr height="250"></c:if>
						<td width="100" style="padding-left:15px;">
						<a href="gallery_view.do?idx=${gallery.idx}"><img ${path[status.index]} width=200px height=200px></a>
						</td>
				</c:forEach>
				<c:forEach var="gallery" items="${list}" varStatus="status" begin="4" end="7">
					<c:if test="${status.index mod 4 == 0}"><tr height="80"></c:if>
						<td width="100" style="padding-left:15px;">
							<p class="p26">
								<a href="gallery_view.do?idx=${gallery.idx}">
									<span class="gallery-title"><b> &nbsp;&nbsp;${gallery.subject} </b></span>
								</a>
									<span class="hit"><font size="2" color="gray">조회수 : ${gallery.readcnt}</font></span>
							</p>
						</td>
				</c:forEach>
				<c:forEach var="gallery" items="${list}" varStatus="status" begin="8" end="11">
					<c:if test="${status.index mod 4 == 0}"><tr height="250"></c:if>
						<td width="100" style="padding-left:15px;">
						<a href="gallery_view.do?idx=${gallery.idx}"><img ${path[status.index]} width=200px height=200px></a>
						</td>
				</c:forEach>
				<c:forEach var="gallery" items="${list}" varStatus="status" begin="8" end="11">
					<c:if test="${status.index mod 4 == 0}"><tr height="80"></c:if>
						<td width="100" style="padding-left:15px;">
							<p class="p26">
								<a href="gallery_view.do?idx=${gallery.idx}">
									<span class="gallery-title"><b> &nbsp;&nbsp;${gallery.subject} </b></span>
								</a>
									<span class="hit"><font size="2" color="gray">조회수 : ${gallery.readcnt}</font></span>
							</p>
						</td>
				</c:forEach>
				</table>
			</c:if>

		</ul>
		<div class="paging">
			${pageSkip}
			<a href="gallery_write.do" class="btn-write">글쓰기</a>
		</div>
</div>

<script>
	function check() {
		if(search_form.key.value=="") {
			alert("검색단어입력하세요");
			search_form.key.focus;
			return false;
		}
		return true;
	}
</script>

<%@ include file="/include/footer.jsp"%>















