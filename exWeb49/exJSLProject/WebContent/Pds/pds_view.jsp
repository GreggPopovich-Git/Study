<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	List<PdsCommentVO> clist = null;
	if(request.getAttribute("clist") != null) {
		clist = (List)request.getAttribute("clist");
	}
	int row = 0;
	if(request.getAttribute("row") != null) {
		row = (int)request.getAttribute("row");
	}
	int rowlike = 0;
	if(request.getAttribute("rowlike") != null) {
		rowlike = (int)request.getAttribute("rowlike");
	}
	if(row == -1) {
%>
<script>
	alert("비밀번호가 틀렸습니다.");
	history.back();
</script>
<%
	}
	if(rowlike == 1) {
%>
<script>
	alert("좋아요는 하루에 한번만 가능합니다.");
</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSL 인재 개발원</title>
<style type="text/css">
	section a:link {color:blue;}
	section a:visited {color:blue;}
	section a:hover {color:red;}
	section a:active {color:green;}
	* {margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	body {background:url("img/aa.jfif");background-repeat:y-repeat;background-size:100%;overflow:auto;}
	.content {padding:100px; height:100%;}
	.title {text-align:center;padding:22px;}
	.content table{width:700px;margin:0 auto;}
	.content table th {width:20%; border:1px solid #bbb; background-color:#A9A9F5;}
	.content table td {padding:5px 5px;border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
</style>
<script>
	function del() {
		if(confirm("삭제 하시겠습니까?")) {
			location.href = "pds_delete?page=" + ${page} + "&idx=" + ${vo.idx};
		}
	}
	function cal() {
		if(${vo.likecnt} == result.value) {
			document.getElementById("like").value = document.getElementById("like").value + "a";
			document.getElementById("result").value = document.getElementById("like").value.length - 9 + ${vo.likecnt};
			view.action="pds_view";
			view.submit();
		}
	}
	function calcomment() {
		document.getElementById("commentresult").value = document.getElementById("comment").value.length;
	}
	function send() {
		if(com.comment.value == "") {
			alert("내용을 입력해주세요.");
			com.comment.focus();
			return;
		}
		if(com.name.value == "") {
			alert("이름을 입력해주세요.");
			com.name.focus();
			return;
		}
		if(com.pass.value == "") {
			alert("비밀번호를 입력해주세요.");
			com.pass.focus();
			return;
		}
		com.action = "pds_view";
		com.submit();
	}
	function commentmodify(x) {
		if(com.repass+x.value == "") {
			alert("비밀번호를 입력해주세요.");
			return;
		}
		
	}
	function commentdelete(x) {
		var frm = document.forms[x];
		var newWin = window.open("about:blank","comment","width=300 height=200");
		frm.action = "commentdelete";
		frm.target = "comment";
		frm.submit();
	}
</script>
</head>
<body>
	<%@ include file = "/Include/header.jsp" %>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title"> 자료실 </h2>
				<form name="view" method="post">
				<input type="hidden" name="idx" value="${vo.idx}">
				<input type="hidden" name="page" value="${page}">
				<input type="hidden" name="sort" value="${sort}">
				<table>
					<tr>
						<th>작성자</th>
						<td>${vo.name}</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${vo.email}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${vo.subject}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${vo.contents}</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><a href="file_down?file=${vo.filename}&idx=${vo.idx}&cnt=${vo.downloadcnt}"><img src="img/disk.gif" align="center" width="22" height="20" border="0">${vo.filename}</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font style="color:gray;size:10px">다운로드 : ${vo.downloadcnt} 번</font>
						</td>
					</tr>
					<tr>
						<td valign="bottom" colspan="2" height="30px" style="border:0;">
						<a href="javascript:cal()"><img name="like" id="like" src="img/like.png" border="0" style="margin:-10px 0px;width:35px;height:35px;"></a>좋아요
						 <input type="text" name="result" id="result" value="${vo.likecnt}" style="width:50px;height:30px;font-size:20px;border:none;background-color:#FBEFEF;" readonly></td>
					</tr>
					<tr>
						<td colspan="2">
	  <p align="center">
      <font size="2">
      <!-- 새글쓰기 -->
       <a href="pds_write?page=${page}">
       <img src="img/write.jpg" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
      <!-- 답글쓰기 -->
       <a href="">
       <img src="img/reply.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
      <!-- 수정하기 -->
       <a href="pds_modify?idx=${vo.idx}&page=${page}&userid=${vo.userid}">
       <img src="img/edit.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
         <!-- 삭제하기 -->
       <a href="javascript:del()"><img src="img/del.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
       <!-- 목록보기 -->
       <a href="pds_list?page=${page}"><img src="img/list-2.gif" border="0"></a>&nbsp;&nbsp;&nbsp;&nbsp;
      </font>
						</td>
					</tr>
				</table>
				</form>
				<form name="com" method="post">
				<input type="hidden" name="idx" value="${vo.idx}">
				<input type="hidden" name="page" value="${page}">
				<input type="hidden" name="sort" value="${sort}">
				<table>
					<tr>
						<td style="width:80%">
							<textarea rows="10" name="comment" id="comment" cols="60" maxlength="200" onkeydown="calcomment()" onkeyup="calcomment()" onkeypress="calcomment()" style="overflow:auto; width:100%;height:80px;font-size:20px;"></textarea>
							<div align="right">이름 : <input type="text" name="name" maxlength="3" style="width:100px;"> &nbsp;비밀번호 : <input type="password" name="pass" maxlength="4" style="width:100px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="text" id="commentresult" value="0" style="width:30px;height:30px;font-size:15px;border:none;background-color:#FBEFEF;" readonly><font style="font-size:15px;">/200</font></div>
						</td>
						<td rowspan="2">
							<input type="button" name="commentbutton" value="댓글쓰기" onClick="send()" style="width:100%;height:80px;font-size:20px;">
						</td>
					</tr>
				</table>
				<br>
				<table>
					<tr style="border:0;">
						<td style="border:0;"><h4>댓글</h4></td>
					</tr>
				</table>
				<% if(clist.size() == 0) { %>
					<h4 align="center">등록된 댓글이 없습니다.</h4>
				<% } else { 
					for(int x = 0; x < clist.size(); x++) {
				%>
				
				<table>
					<tr>
						<td colspan="2">●작성자 : <%= clist.get(x).getName() %> ●작성일자 : <%= clist.get(x).getRegdate() %>
						</td>
					</tr>
					<tr>
						<td style="width:70%;background-color:white;"><%= clist.get(x).getContents() %></td>
						<td align="center">비밀번호 : <input type="password" name="repass" style="width:100px;"><br>
						<input type="button" value="수정" onClick="commentmodify(<%= x %>)" style="width:40%"> 
						<input type="button" value="삭제" onClick="commentdelete(<%= x %>)" style="width:40%"></td>
					</tr>
				</table>
				<br>
				<% 	}
				}
				%>
				<table style="border:0px">
					<tr>
						<td width=100% style="border:0px;text-align:center;"><font size="5em">${comPageSkip}</font></td>
					</tr>
				</table>
				</form>
			</div>
		</section>
	</div>
	<%@ include file = "/Include/footer.jsp" %>
</body>
</html>