<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import = "vo.member.*, dao.member.*, java.util.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String searchGubun = request.getParameter("search_gubun");
	String search = request.getParameter("search");
	MemberDAO dao = MemberDAO.getInstance();
	List<MemberVO> mList = new ArrayList<MemberVO>();
	List<MemberVO> sList = new ArrayList<MemberVO>();
	int size = 0;
	if (search == null) {
		mList = dao.memberList();
		size = mList.size();
	} else {
		sList = dao.searchList(searchGubun, search);
		size = sList.size();
	}
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
		if(list.search.value == "") {
			alert("검색어를 입력하세요");
			list.search.focus();
			return;
		}
		list.action = "userinfo_list.jsp";
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
		for(int x = 0; x < size; x++) {
%>
   <tr>
      <td align=center><%= x+1 %></td>
      <td align=center><a href = "userinfo_modify.jsp?userid=<% if(search == null) { %><%= mList.get(x).getUserid() %><% } else { %><%= sList.get(x).getUserid() %><% } %>"><% if(search == null) { %><%= mList.get(x).getUserid() %><% } else { %><%= sList.get(x).getUserid() %><% } %></a></td>
      <td align=center><% if(search == null) { %><%= mList.get(x).getName() %><% } else { %><%= sList.get(x).getName() %><% } %></td>
      <td align=center><% if(search == null) { %><%= mList.get(x).getTel() %><% } else { %><%= sList.get(x).getTel() %><% } %></td>
      <td align=center><% if(search == null) { %><%= mList.get(x).getFirst_time() %><% } else { %><%= sList.get(x).getFirst_time() %><% } %></td>
      <td align=center><% if(search == null) { %><%= mList.get(x).getLast_time() %><% } else { %><%= sList.get(x).getLast_time() %><% } %></td>
   </tr>
<%
		}
%>
</table>
<table width=550>
  <tr>
    <td>
      <select name="search_gubun">
        <option value = "name" <% if(searchGubun == null || searchGubun.equals("name")) { %> selected <% } %>>이름 </option>
        <option value = "addr1" <% if(searchGubun != null && searchGubun.equals("addr1")) { %> selected <% } %>>주소 </option>
        <option value = "tel" <% if(searchGubun != null && searchGubun.equals("tel")) { %> selected <% } %>>전화번호 </option>
      </select>
    </td>
    <td>  찾는이름:
          <input type="text" name="search" size=10 value="<% if(search != null) { %><%= search %><% } %>"> &nbsp;
          <a href = "javascript:search()">[조회]</a>
     </td>
   </tr>
  <tr>
    <td>
    </td>
    <td></td>
   </tr>
  <tr>
    <td><a href = "userlogin_form.jsp">로그인 페이지 이동</a>
    </td>
    <td><a href = "userinfo_insert.jsp">회원가입페이지 이동</a></td>
   </tr>
</table>    
</form>
</body>
</html>
