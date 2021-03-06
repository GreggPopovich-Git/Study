<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file = "/Include/topmenu.jsp" %>

<html>
<head><title>자료 등록 수정</title><link rel="stylesheet" type="text/css" href="/stylesheet.css">
<script>
	function pds_modify() {
		if(modify.name.value == "") {
			alert("이름을 입력해 주세요.");
			modify.name.focus();
			return;
		}
		if(modify.subject.value == "") {
			alert("제목을 입력해 주세요.");
			modify.subject.focus();
			return;
		}
		if(modify.contents.value == "") {
			alert("내용을 입력해 주세요.");
			modify.contents.focus();
			return;
		}
		if(modify.pass.value == "") {
			alert("비밀번호를 입력해 주세요.");
			modify.pass.focus();
			return;
		}
		modify.submit();
	}
</script>   
</head>
<body topmargin="0" leftmargin="0">
<table border="0" width="800">
<tr>
  <td width="20%" height="500" valign="top" bgcolor="#ecf1ef">
<%@ include file = "/Include/login_form.jsp" %>

  <!--  로그인 폼 추가부분 -->
  
  </td>
  <td width="80%" valign="top">&nbsp;<br>
  <img src="Pds/img/bullet-01.gif"><font size="3" face="돋움" color="blue">
  <b> 뮤직자료실</b></font><font size="2"> - 자료 수정하기</font><p>
  <img src="Pds/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
  <img src="Pds/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
<form method="post" name="modify" action="pds_modify.do" enctype = "multipart/form-data">
	<input type="hidden" name="page" value="${page}">
	<input type="hidden" name="idx" value="${vo.idx}">
	<input type="hidden" name="oldfilename" value="${vo.filename}">

   <table border="0">
    <tr>
      <td width="5%" align="right"><img src="Pds/img/bullet-02.gif"></td>
      <td width="15%"><font size="2 face="돋움"">글쓴이</font></td>
      <td width="80%"><input type="text" size="20" name="name" value="${vo.name}"></td></tr>
    <tr>
      <td align="right">&nbsp;</td>
      <td ><font size="2 face="돋움"">메일주소</font></td>
      <td><input type="text" size="20" name="email" value="${vo.email}"></td></tr>
    <tr>
      <td align="right"><img src="Pds/img/bullet-02.gif"></td>
      <td><font size="2" face="돋움">제목</font></td>
      <td><input type="text" size="60" name="subject" value="${vo.subject}"></td></tr>
    <tr>
      <td align="right"><img src="Pds/img/bullet-02.gif"></td>
      <td><font size="2" face="돋움">자료설명</font></td>
      <td><textarea wrap="physical" rows="10" name="contents" cols="60">${vo.contents}</textarea></td></tr>
    <tr>
      <td align="right"><img src="Pds/img/bullet-02.gif"></td>
      <td><font size="2" face="돋움">파일첨부</font></td>
      <td><input type="file" name="filename" size="30" value="${vo.filename}"></td></tr>
    <tr>
      <td align="right"><img src="Pds/img/bullet-02.gif"></td>
      <td><font size="2" face="돋움">비밀번호</font></td>
      <td><input type="password" size="10" name="pass"></td></tr>
    <tr>
      <td align="right">&nbsp;</td>
      <td><font size="2">&nbsp;</font></td>
      <td><a href="javascript:pds_modify()"><input type="button" value="수정하기" ></a>&nbsp;
      <a href="javascript:history.back()"><input type="button" value="돌아가기" ></a></td></tr>
    </table>
    </form>
    </td>
  </tr>
  </table>
</body>
</html>
 <%@ include file = "/Include/copyright.jsp" %>
