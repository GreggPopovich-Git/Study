<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "java.util.*, exServlet.model.member.*" %>
<%
	List<MemberVO> list = (List) request.getAttribute("list");
%>
<html>
<head>
<title>회원목록 보여주기</title>

<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000} 
--->
</STYLE>
<script>
	function search() {
		if(list.key.value == "") {
			alert("검색어를 입력하세요");
			list.key.focus();
			return;
		}
		list.action = "userinfo_list";
		list.submit();
	}
</script>
</head>
<body>
<form name = "list" method = "post">
<table width="550" border="1" cellspacing="0" cellpadding="2" bordercolorlight="#173E7C" bordercolordark="white">
  <tr>
    <td width=50 align=center>번호</td>
    <td width=50 align=center>ID</td>
    <td width=80 align=center>이름</td>
    <td width=100 align=center>전화번호</td>
    <td width=100 align=center>등록일자</td>
    <td width=100 align=center>최근접속일</td>
  </tr>
<%
	for(int x = 0; x < list.size(); x++) {
%>
   <tr>
      <td align=center><%= x+1 %></td>
      <td align=center><%= list.get(x).getUserid() %></td>
      <td align=center><%= list.get(x).getName() %></td>
      <td align=center><%= list.get(x).getTel() %></td>
      <td align=center><%= list.get(x).getFirst_time() %></td>
      <td align=center><%= list.get(x).getLast_time() %></td>
   </tr>
<%
	}
%>
</table>
<table width=550>
  <tr>
    <td>
      <select name="search">
        <option value = "name" <% if(request.getAttribute("search") == null || request.getAttribute("search").equals("name")) { %> selected <% } %>>이름 </option>
        <option value = "addr1" <% if(request.getAttribute("search") != null && request.getAttribute("search").equals("addr1")) { %> selected <% } %>>주소 </option>
        <option value = "tel" <% if(request.getAttribute("search") != null && request.getAttribute("search").equals("tel")) { %> selected <% } %>>전화번호 </option>
        <option value = "email" <% if(request.getAttribute("search") != null && request.getAttribute("search").equals("email")) { %> selected <% } %>>이메일 </option>
    </td>
    <td>  찾는이름:
          <input type="text" name="key" size=10 value = "${key}"> &nbsp;
          <a href = "javascript:search()">[조회]</a>
     </td>
   </tr>
  <tr>
    <td>
    </td>
    <td></td>
   </tr>
  <tr>
<%
	if(session.getAttribute("vo") == null) {
%>
    <td><a href = "userlogin_form">[ 로  그  인  ]</a></td>
    
    <td><a href = "userinfo_insert">[ 회  원  가  입  ]</a></td>
<%
	} else {
%>
    <td><a href = "logout">[ 로  그  아  웃  ]</a></td>
<%
	}
%>
    
   </tr>
</table>   
</form> 
</body>
</html>
