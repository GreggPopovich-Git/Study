<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, model.vo.*" %>
<%
	if(session.getAttribute("vo") == null) {
%>
<script>
	alert("회원 전용입니다.");
	location.href = "login_form";
</script>
<%
	}
	List<PdsVO> list = (List) request.getAttribute("list");
	String search = (String) request.getAttribute("search");
	int listcount = (int)request.getAttribute("listcount");
	String sort = (String) request.getAttribute("sort");
	int drow = 0;
	if(request.getParameter("drow") != null) {
		drow = Integer.parseInt(request.getParameter("drow"));
	}
	if(drow == -1){
%>
<script>
	alert("해당 글은 작성자만 삭제 할 수 있습니다.");
	history.back();
</script>
<%
	}
%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>JSL 인재 개발원</title>
<style type="text/css">
	section a:link { color:blue; }
	section a:visited { color:blue; }
	section a:hover { color:red; }
	section a:active { color:green; }
	* {margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	body {background:url("img/aa.jfif");background-repeat:y-repeat;background-size:100%;}
	.contents {background-color:#E6E6E6; padding:16px; height:150%;}
	.title {text-align:center;padding:22px;}
	.content{height:500px;}
	.content table {width:800px; margin:0 auto;}
	.content table,th, td {border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
	.content table .white {color:#fff;}
	.content .text_center{text-align:center;}
</style>

 </head>
 <body>
 	<%@ include file = "/Include/header.jsp" %>
<!-- 본문의 시작 section  -->
	<div class="section">
		<section>
		<div class="content">
			<h2 class="title"> 자 료 실 </h2>
			<form name="sort" action="pds_list" method="post">
			<input type="hidden" name="page" value="${page}">
			<input type="hidden" name="search" value="${search}">
			<input type="hidden" name="key" value="${key}">
			<input type="hidden" name="row" value="${row}">
			<table style="border:0px;">
				<tr>
					<td style="border:0px;text-align:right;">
						<select name="sort" onchange="javascript:submit()">
							<option value="order by regdate desc" <% if(sort.equals("order by regdate desc")) { %>selected<% } %>>최근등록순</option>
							<option value="order by regdate" <% if(sort.equals("order by regdate")) { %>selected<% } %>>등록순서순</option>
							<option value="order by readcnt desc" <% if(sort.equals("order by readcnt desc")) { %>selected<% } %>>조회수순</option>
						</select>
					</td>
				</tr>
			</table>
			</form>
				<table>
					<tr style="background-color:#A9A9F5;">
						<th>글번호</th>
						<th>글제목</th>
						<th>작성자</th>
						<th>첨부파일</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
<%
	if(list.size() == 0) {
%>
					<tr class="text_center">
						<td colspan="6">등록된 글이 없습니다.</td>
					</tr>
<%
	} else {
		for(int x = 0; x < list.size(); x++) {
%>
					<tr class="text_center">
						<td><%= listcount-- %></td>
						<td><a href="pds_view?idx=<%= list.get(x).getIdx() %>&page=${page}&sort=${sort}"><%= list.get(x).getSubject() %></a></td>
						<td><%= list.get(x).getName() %></td>
						<td><%= list.get(x).getFilename() %></td>
						<td><%= list.get(x).getRegdate().substring(0,10) %></td>
						<td><%= list.get(x).getReadcnt() %></td>
					</tr>
<%
		}
	}
%>
				</table>
				<br>
				<table style="border:0px">
					<tr>
						<td width=100% style="border:0px;text-align:center;"><font size="5em">${pageSkip}</font></td>
						<td style="border:0px;text-align:right;"><a href="pds_write?page=${page}"><img src="img/write.gif" border="0"></a></td>
					</tr>
				</table>
				<form name = "search_list" method = "post">
				<input type="hidden" name="sort" value="${sort}">
				<input type="hidden" name="page" value="${page}">
				<input type="hidden" name="row" value="<%= 1 %>">
				    <table style="border:0px;">
				      <tr>
				      <td style="border:0px;text-align:center;">
				      <font color="#004080" size="4" face="Courier New"><strong>Search&nbsp;</strong></font>
				        <select name="search" size="1" style="font-family: 돋움체">
						   <option value="subject" <% if(search.equals("subject")) { %> selected <% } %>>글제목</option>
						   <option value="name" <% if(search.equals("name")) { %> selected <% } %>>작성자</option>
						   <option value="contents" <% if(search.equals("contents")) { %> selected <% } %>>글내용</option>
						</select>
						&nbsp;&nbsp;<input type="text" name="key" size="20" value = "${key}">
						&nbsp;&nbsp;<input type="image" src="img/search2.gif" align="center">
					   </td>
					   </tr>
				    </table>
				</form>
		</div>
		</section>
	</div>
<!--  footer  -->
	<%@ include file = "/Include/footer.jsp" %>
</body>
</html>    