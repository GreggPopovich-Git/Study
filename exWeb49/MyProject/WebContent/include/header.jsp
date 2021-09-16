<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSL 인재개발원</title>
	<link href="/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<link href="/css/common.css" rel="stylesheet">
	<link href="/css/mystyle.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

  <script>
    $(function(){
    	
      $('.slider').bxSlider({
    	  mode: 'fade',
    	  captions: true
      });
      
      $(".sitemap").click(function() {
			$(".sitewrap").slideDown();
		})
	  $("#close").click(function() {
			$(".sitewrap").slideUp();
		})
		
	  $(".nav > nav > .navi > li").hover(function() {
		  $(this).children(".navi2").stop().slideDown();
	  }, function() {
		  $(this).children(".navi2").stop().slideUp();
	  });
		
    });
	function log_out() {
		if(confirm("로그아웃 하시겠습니까?")) {
			location.href = "logout.do";
		}
	}
  </script>

</head>
<body>
	<div class="header">
		<header>
			<div class="topnav">
				<ul>
				<c:if test="${empty sessionvo}">
					<li><a href="login.do">로그인</a></li>
					<li><a href="member.do">회원가입</a></li>
				</c:if>
				<c:if test="${!empty sessionvo}">
					<li><a href="javascript:log_out()">로그아웃</a></li>
					<li><a href="member_info.do">회원정보</a></li>
				</c:if>
					<li><a href="javascript:void(0)" class="sitemap">사이트맵</a></li>
				</ul>
			</div>
			<div class="navigation">
				<h1 class="logo"><a href="/index.do"><img src="http://m.jslhrd.com/img_up/shop_pds/jslcom/build/option/jsl-in-jae-gae-bal-won_-ro-go1622616169.png" alt="" title="logo" width="50" height="30"></a></h1>
				<div class="nav">
					<nav>
						<ul class="navi">
							<li><a href="board.do">게시판</a>
								<ul class="navi2">
									<li><a href="board.do">자유게시판</a></li>
									<li><a href="mboard.do">회원게시판</a></li>
									<li><a href="pds.do">자료실</a></li>
								</ul>
							</li>
							<li><a href="gallery.do">갤러리</a>
								<ul class="navi2">
									<li><a href="gallery.do">전체보기</a></li>
									<li><a href="gallery.do?type=국내여행">국내여행</a></li>
									<li><a href="gallery.do?type=해외여행">해외여행</a></li>
									<li><a href="gallery.do?type=맛집사진">맛집사진</a></li>
								</ul>
							</li>
							<li><a href="qa.do">질문답변</a></li>
							<li><a href="notice.do">공지사항</a></li>
							<c:if test="${sessionvo.rank == 0 || sessionvo.rank == 1}">
								<li><a href="member_list.do">관리페이지</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
		</header>
	</div>
	
	<div class="line"></div>
	
	<div class="sitewrap">
		<span class="fa fa-close" id="close" style="cursor:pointer"></span>
		<div class="inner">
			<span class="map"><a href="board.do"><font color="white">자유게시판</font></a></span>
			<span class="map"><a href="gallery.do"><font color="white">갤러리</font></a></span>
			<span class="map"><a href="qa.do"><font color="white">질문답변</font></a></span>
			<span class="map"><a href="notice.do"><font color="white">공지사항</font></a></span>
		</div>
	</div>
</body>
</html>