<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<html>
   <head><title>방명록 작성</title>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
<script>
	function send() {
		if(guest.name.value == "") {
			alert("이름을 입력해주세요");
			guest.name.focus();
			return;
		}
		if(guest.pass.value == "") {
			alert("비밀번호를 입력해주세요");
			guest.pass.focus();
			return;
		}
		if(guest.subject.value == "") {
			alert("제목을 입력해주세요");
			guest.subject.focus();
			return;
		}
		if(guest.contents.value == "") {
			alert("내용을 입력해주세요");
			guest.contents.focus();
			return;
		}
		guest.action = "guest_write_pro.jsp";
		guest.submit();
	}
</script>
</head>
 <body topmargin="0" leftmargin="0">
 <table border="0" width="800">
 <tr>
   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">
   <!-- 다음에 추가할 부분 --> 
   </td>
   <td width="80%" valign="top">&nbsp;<br>
     <img src="img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>방명록</b></font>
     <font size="2"> - 글쓰기</font><p>
     <img src="img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     <form method="post" name="guest">
      <table border="0">
       <tr>
         <td width="5%" align="right"><img src="img/bullet-02.gif"></td>
         <td width="15%"><font size="2" face="돋움">글쓴이</font></td>
         <td width="80%"><input type="text" size="20" name="name"></td>
       </tr>
       <tr>
         <td width="5%" align="right"><img src="img/bullet-02.gif"></td>
         <td width="15%"><font size="2" face="돋움">비밀번호</font></td>
         <td width="80%"><input type="password" size="20" name="pass"> 수정삭제시 필요</td>
       </tr>
       <tr>
         <td align="right"><img src="img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제목</font></td>
         <td><input type="text" size="60" name="subject"></td>
       </tr>
       <tr>
         <td align="right"><img src="img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" name="contents" cols="60"></textarea></td>
       </tr>
        <tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td>
          	<input type = "button" value = "등록" onClick = "javascript:send()"><input type="button" value="취소" onClick = "javascript:history.back()">
          </td>
        </tr>
      </table>
      </form>
    </td>
  </tr>
  </table>
  </body>
</html>
