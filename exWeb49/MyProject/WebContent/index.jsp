<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/header.jsp" %>
	
	<div class="slider">
	    <div><img src="img/hhh.png" alt="" title="배움의 즐거움이 있는곳"></div>
	    <div><img src="img/ddd.png" alt="" title="나에게 주는 만큼"></div>
	    <div><img src="img/aaa.png" alt="" title="나에게도 많은 축복이 있습니다"></div>
  	</div>
	<div class="indexgallery">
			<div class="indextitle">
				<h2>갤러리</h2>
				<span><a href="gallery.do">MORE</a></span>
			</div>
			<ul>
				<li><a href="gallery_view.do?idx=${glist[0].idx}"><img ${path[0]}></a></li>
				<li><a href="gallery_view.do?idx=${glist[1].idx}"><img ${path[1]}></a></li>
				<li><a href="gallery_view.do?idx=${glist[2].idx}"><img ${path[2]}></a></li>
			</ul>
	</div>
	
	
	<div class="bbs_wrap">
		<div class="bbs_left">
			<h2 class="title">공지시항</h2>
			<ul>
				<li><a href="notice_view.do?idx=${nlist[0].idx}">${nlist[0].subject}</a></li>
				<li><a href="notice_view.do?idx=${nlist[1].idx}">${nlist[1].subject}</a></li>
				<li><a href="notice_view.do?idx=${nlist[2].idx}">${nlist[2].subject}</a> </li>
				<li><a href="notice_view.do?idx=${nlist[3].idx}">${nlist[3].subject}</a></li>
				<li><a href="notice_view.do?idx=${nlist[4].idx}">${nlist[4].subject}</a></li>
			</ul>
			<a href="notice.do"><span class="fa fa-plus plus"></span></a>
		</div>
		<div class="bbs_right">
			<h2 class="title">질문답변</h2>
			<ul>
				<li><a href="qaview.do?idx=${qalist[0].idx}">${qalist[0].subject}</a></li>
				<li><a href="qaview.do?idx=${qalist[1].idx}">${qalist[1].subject}</a></li>
				<li><a href="qaview.do?idx=${qalist[2].idx}">${qalist[2].subject}</a></li>
				<li><a href="qaview.do?idx=${qalist[3].idx}">${qalist[3].subject}</a></li>
				<li><a href="qaview.do?idx=${qalist[4].idx}">${qalist[4].subject}</a></li>
			</ul>
			<a href="qa.do"><span class="fa fa-plus plus"></span></a>
		</div>
	</div>
	
<%@ include file="/include/footer.jsp" %>