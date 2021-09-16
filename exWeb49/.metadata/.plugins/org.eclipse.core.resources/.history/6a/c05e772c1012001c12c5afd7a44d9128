<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>협력업체 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css"> 
<!-- 
body,td,tr,table{font-size:9pt; font-family:tahoma;color:#666666;line-height:160%;} 

A:link {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:visited {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:active {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:hover {font-family:tahoma;font-size:9pt;color:#009900;text-decoration:underline;} 
--> 
</style> 
<script>
	function selectAll(selectAll)  {
	  const checkboxes = document.getElementsByName('sel');
	  checkboxes.forEach((checkbox) => {checkbox.checked = selectAll.checked;})
	}
	function check() {
		if(boardform.key.value == "") {
			alert("검색어를 입력하세요.");
			return;
		}
		boardform.action="admin_board_list.do";
		boardform.submit();
	}
	function boarddelete() {
		var flag = 0;
        for(var x = 0; x < boardform.sel.length; x++) {
        	if(boardform.sel[x].checked) {
        		flag = 1;
        		break;
        	}
        }
        if(!flag) {
        	alert("회원을 선택 하세요.");
        	return;
        }
		if(confirm("삭제 하시겠습니까?") == true) {
			boardform.action="admin_board_delete.do";
			boardform.submit();
		}
	}
</script>
</head>

<body>
<form name="boardform" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td><jsp:include page="top_menu.jsp" flush="true" /></td></tr>
	<tr>
		<td align="center" height="100%" valign=middle><br>
			<table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr> 
					<td height=40 align="center" style="font-size: 15px;"><b>자유게시판</b></td>
				</tr>
			</table><br>
			<table width="80%" border="0" cellspacing="0" cellpadding="0">
				<tr>
                    <td height="20">* 총 등록수 : <font color=red>${listcount}</font> 건</td>
                  </tr>
                  <tr>
                    <td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
                      <tr bgcolor="EcECEC">
                        <td width="2%"><input type="checkbox" name="sel" value="selectall" onclick='selectAll(this)'></td>
                        <td width="15%" align="center" bgcolor="EcECEC"><strong>번호</strong></td>
						<td align="center" bgcolor="EcECEC"><strong>제목</strong></td>
						<td width="15%" align="center"><strong>글쓴이</strong></td>
						<td width="15%" align="center"><strong>아이디</strong></td>
                        <td width="20%" align="center"><strong>등록일</strong></td>
                        <td width="10%" align="center"><strong>조회수</strong></td>
                      </tr>
                      <c:forEach var="board" items="${list}" varStatus="status">
                      <tr>
                      	<td><input type="checkbox" name="sel" value="${board.idx}"></td>
                        <td align="center" bgcolor="#FFFFFF">${listcount}</td>
                        <td align="center" bgcolor="#FFFFFF"><a href="admin_board_view.do?idx=${board.idx}">${board.subject}</a></td>
                        <td align="center" bgcolor="#FFFFFF">${board.name}</td>
						<td align="center" bgcolor="#FFFFFF">${board.userid}</td>
						<td align="center" bgcolor="#FFFFFF">${board.regdate}</td>
						<td align="center" bgcolor="#FFFFFF">${board.readcnt}</td>
                      </tr>
                      <c:set var="listcount" value="${listcount-1}" />
                      </c:forEach>
	                     <tr>
                        <td height="35" colspan="10" align="center" bgcolor="#FFFFFF">${pageSkip}</td>
                      </tr>
                      <tr>
                        <td colspan="10" align="center" bgcolor="#FFFFFF"><table width="610" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width=80% height="30" colspan="2" align="right">
								<select name="search" class="textfield">
									<option value="subject" <c:if test="${search=='subject'}"> selected </c:if>>제목</option>
									<option value="name" <c:if test="${search=='name'}"> selected </c:if>>글쓴이</option>
									<option value="userid" <c:if test="${search=='userid'}"> selected </c:if>>아이디</option>
								</select>
								<input name="key" type="text" class="textfield" size="30" value="${key}"></td>
                              <td width=20% align="right"><a href="javascript:check()"><b>[검색]</b></a>  &nbsp;
                              <a href="javascript:boarddelete()"><font color="red"><b>[선택삭제]</b></font></a>
                              </td>
                            </tr>
                        </table></td>
                      </tr>
                    </table>
                </td>
            </tr>
       </table>
  </td>
  </tr>
  </table>       
  </form>           
</body>
</html>
