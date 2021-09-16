<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "model.board.*, model.board.*, java.util.*, util.*" %>

<%
	request.setCharacterEncoding("utf-8");
	BoardDAO dao = BoardDAO.getInstance();
	String url = "board_list.jsp";
	String s_query = "", query = "", key = "", addtag = "";
	int totcount = 0; // 전체 게시물 카운트
	if (request.getParameter("key") != null) {
		key = request.getParameter("key");
		query = request.getParameter("search");
		//totcount = dao.boardCount(key, query);
		//list = dao.boardList(key, query);
		s_query = query + " like '%" + key + "%'";
		addtag = "&search=" + query + "&key=" + key;
		totcount = dao.boardCount(s_query);
	} else {
		totcount = dao.boardCount();
	}
	int nowpage = 1; // 현재페이지
	int maxlist = 10; // 페이지당 글수
	int totpage = 1; // 총페이지
	// 페이지 수 계산
	if (totcount % maxlist == 0) {
		totpage = totcount / maxlist;
	} else {
		totpage = totcount / maxlist + 1;
	}
	//
	if (request.getParameter("page") != null && !request.getParameter("page").equals("")) {
		nowpage = Integer.parseInt(request.getParameter("page"));
	}
	if(nowpage > totpage)
		nowpage = totpage; // 현재페이지가 총페이지보다 클 경우 마지막페이지를 현재페이지로
		
	int pagestart = (nowpage - 1) * maxlist; // 현재페이지 시작번호
	int listcount = totcount - pagestart; // 임시 글번호 출력용
	
	List<BoardVO> list = null;
	if (key.equals("")) {
		list = dao.boardList(pagestart, maxlist);
	} else {
		list = dao.boardList(s_query, pagestart, maxlist);
	}
	// 페이지 인덱스 처리
	String pageList = "";
	if (key.equals("")) {
		pageList = PageIndex.pageList(nowpage, totpage, url, addtag);
	} else {
		pageList = PageIndex.pageListHan(nowpage, totpage, url, query, key);
	}
	if(nowpage == 0) nowpage = 1;
%>
<html>
<head><title>게시판 읽기</title>
<link rel="stylesheet" type="text/css" href="/stylesheet.css">
<style type="text/css">
  a.list {text-decoration:none;color:black;font-size:10pt;}
</style>
<script>
	function search() {
		if(bSearch.key.value == "") {
			alert("검색어를 입력하세요");
			bSearch.name.focus();
			return;
		}
		bSearch.action = "board_list.jsp";
		bSearch.submit();
	}
</script>
</head>
<body bgcolor="#FFFFFF" topmargin="0" leftmargin="0">
<table border="0" width="800">
  <tr>
    <td width="20%" height="500" valign="top" bgcolor="#ecf1ef">

	<!-- 다음에 추가할 부분 --></td>

	<td width="80%" valign="top">	
		<br>
    <table border="0" cellspacing="1" width="100%" align="center">
      <tr>
        <td colspan="7" align="center" valign="center" height="20">
        <font size="4" face="돋움" color="blue">
        <img src="./img/bullet-01.gif"> <b>자 유 게 시 판</b></font></td></tr>
      <tr>
        <td colspan="5" align="right" valign="middle" height="20">
		<font size="2" face="고딕">전체 : <b><%= totcount %></b>건 - <%= nowpage %>/ <%= totpage %> Pages</font></td></tr>
 	   <tr bgcolor="e3e9ff">
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">번 호</font></td>
 	      <td width="50%" align="center" height="20"><font face="돋움" size="2">제 목</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">글쓴이</font></td>
 	      <td width="15%" align="center" height="20"><font face="돋움" size="2">작성일</font></td>
 	      <td width="10%" align="center" height="20"><font face="돋움" size="2">조회수</font></td>
 	   </tr>
<%
	if (list.size() != 0) {
		for(int x = 0; x < list.size(); x++) {
%>
		<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
			<td align="center" height="25">
			<font face="돋움" size="2" color="#000000"><%= listcount-- %></font></td>
			<td align="left" height="20">&nbsp;
				<font face="돋움" size="2" color="#000000">
				<a class="list" href="board_view.jsp?idx=<%= list.get(x).getIdx() %>&page=<%= nowpage %>"><%= list.get(x).getSubject() %></a></td>
					<td align="center" height="20"><font face="돋움" size="2">
					<a class="list" href="<%= list.get(x).getEmail() %>"><%= list.get(x).getName() %></a></font></td>
				<td align="center" height="20"><font face="돋움" size="2"><%= list.get(x).getRegdate().substring(0,10) %></font></td>
				<td align="center" height="20"><font face="돋움" size="2">
				<%= list.get(x).getReadcnt() %></font></td>
		</tr>
<%
		}
	} else {
%>
		<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''">
		<td align="center" height="25" colspan="5">
		<font face="돋움" size="2" color="#000000">등록된 글이 없습니다.</font></td>
<%
	}
%>
	 <div align="center">
        <table width="700" border="0" cellspacing="0" cellpadding="5">
          <tr>&nbsp;</tr><tr>
             <td colspan="5">
                <div align="center"><%= pageList %></div>
			  </td>
			 </tr>
		</table>
	<table width="600">
		<tr>
			<td width="25%"> &nbsp;</td>
			<td width="50%" align="center">
				<table>
					<form name = "bSearch" method = "post">	
					<!-- 검색어를 이용하여 글제목, 작성자, 글내용 중에 하나를 입력 받아 처리하기 위한 부분 -->
						<tr>
							<td>
								<select name="search">
									<option value="subject" <% if(query.equals("subject")) { %> selected <% } %>>글제목</option>
									<option value="name" <% if(query.equals("name")) { %> selected <% } %>>작성자</option>
									<option value="contents" <% if(query.equals("contents")) { %> selected <% } %>>글내용</option>
								</select>
							</td>
							<td> <input type="text" size=20 name="key" value="<%= key %>"></td>
							<td> <a href="javascript:search()"><img src="./img/search2.gif" border="0"></a></td>
						</tr>
					</form>
				</table>
			</td>
			<td width="25%" align="right">
			<a href="board_write.jsp?page=<%= nowpage %>"><img src="./img/write.gif" border="0"></a>
			</td>
		</tr>
	</table>
</body>
</html>