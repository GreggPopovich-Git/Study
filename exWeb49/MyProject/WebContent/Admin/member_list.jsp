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
	function check() {
		if(memberform.key.value == "") {
			alert("검색어를 입력하세요.");
			return;
		}
		memberform.action="member_list.do";
		memberform.submit();
	}
	function selectAll(selectAll)  {
	  const checkboxes = document.getElementsByName('users');
	  checkboxes.forEach((checkbox) => {checkbox.checked = selectAll.checked;})
	}
	function memberdelete() {
		var flag = 0;
        for(var x = 0; x < memberform.users.length; x++) {
        	if(memberform.users[x].checked) {
        		flag = 1;
        		break;
        	}
        }
        if(!flag) {
        	alert("회원을 선택 하세요.");
        	return;
        }
		if(confirm("삭제 하시겠습니까?") == true) {
			memberform.action="member_delete.do";
			memberform.submit();
		}
	}
	function rankup() {
		var flag = 0;
        for(var x = 0; x < memberform.users.length; x++) {
        	if(memberform.users[x].checked) {
        		flag = 1;
        		break;
        	}
        }
        if(!flag) {
        	alert("회원을 선택 하세요.");
        	return;
        }
		alert("해당 회원의 등급을 올립니다.");
		memberform.action="member_rankup.do";
		memberform.submit();
	}
	function rankdown() {
		var flag = 0;
        for(var x = 0; x < memberform.users.length; x++) {
        	if(memberform.users[x].checked) {
        		flag = 1;
        		break;
        	}
        }
        if(!flag) {
        	alert("회원을 선택 하세요.");
        	return;
        }
		alert("해당 회원의 등급을 내립니다.");
		memberform.action="member_rankdown.do";
		memberform.submit();
	}
	function send() {
		var flag = 0;
        for(var x = 0; x < memberform.users.length; x++) {
        	if(memberform.users[x].checked) {
        		flag = 1;
        		break;
        	}
        }
        if(!flag) {
        	alert("회원을 선택 하세요.");
        	return;
        }
        memberform.action="member_mail.do";
        memberform.submit();
	}
</script>
</head>

<body>
<form method="post" name="memberform">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td><jsp:include page="top_menu.jsp" flush="true" /></td></tr>
	<tr>
		<td align="center" height="100%" valign=middle><br>
			<table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr> 
					<td height=40 align="center" style="font-size: 15px;"><b>회원정보리스트</b></td>
				</tr>
			</table><br>
			<table width="80%" border="0" cellspacing="0" cellpadding="0">
				<tr>
                    <td height="20">* 총 회원수 : <font color=red>${listcount}</font> 명</td>
                  </tr>
                  <tr>
                    <td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
                      <tr bgcolor="EcECEC">
                      	<td width="2%"><input type="checkbox" name="users" value="selectall" onclick='selectAll(this)'></td>
                        <td width="10%" align="center" bgcolor="EcECEC"><strong>번호</strong></td>
						<td align="center" bgcolor="EcECEC"><strong>이름</strong></td>
						<td width="15%" align="center"><strong>아이디</strong></td>
                        <td width="20%" align="center"><strong>이메일</strong></td>
                        <td width="10%" align="center"><strong>연락처</strong></td>
                        <td width="10%" align="center"><strong>가입일자</strong></td>
                        <td width="10%" align="center"><strong>최근로그인</strong></td>
                        <td width="10%" align="center"><strong>회원등급</strong></td>
                      </tr>
                      <c:forEach var="member" items="${list}" varStatus="status">
                      <tr>
                      	<td><input type="checkbox" name="users" value="${member.userid}"></td>
                        <td align="center" bgcolor="#FFFFFF">${status.index + 1}</td>
                        <td align="center" bgcolor="#FFFFFF">${member.name}</td>
                        <td align="center" bgcolor="#FFFFFF">${member.userid}</td>
						<td align="center" bgcolor="#FFFFFF">${member.email}</td>
						<td align="center" bgcolor="#FFFFFF">${member.tel}</td>
						<td align="center" bgcolor="#FFFFFF">${member.first_time}</td>
						<td align="center" bgcolor="#FFFFFF">${member.last_time}</td>
						<td align="center" bgcolor="#FFFFFF">${member.rank}</td>
                      </tr>
                      </c:forEach>
	                  <tr>
                        <td height="35" colspan="10" align="center" bgcolor="#FFFFFF">${pageSkip}</td>
                      </tr>
                      <tr>
                        <td colspan="9" align="center" bgcolor="#FFFFFF"><table width="80%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width=50% height="30" colspan="4" align="right">
								<select name="search" class="textfield">
									<option value="name" <c:if test="${search=='name'}"> selected </c:if>>이름</option>
									<option value="userid" <c:if test="${search=='userid'}"> selected </c:if>>아이디</option>
									<option value="email" <c:if test="${search=='email'}"> selected </c:if>>이메일</option>
									<option value="tel" <c:if test="${search=='tel'}"> selected </c:if>>연락처</option>
									<option value="first_time" <c:if test="${search=='first_time'}"> selected </c:if>>가입일자</option>
									<option value="last_time" <c:if test="${search=='last_time'}"> selected </c:if>>최근로그인</option>
									<option value="rank" <c:if test="${search=='rank'}"> selected </c:if>>회원등급</option>
								</select>
								<input name="key" type="text" class="textfield" size="30" value="${key}"></td>
                              <td width=10% align="right"><a href="javascript:check()"><b>[검색]</b></a></td>
                              <td colspan="4" width="40%" align="center"><a href="javascript:memberdelete()"><font color="red"><b>[선택삭제]</b></font></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                              <a href="javascript:rankup()"><b>[등급올리기]</b></a> <a href="javascript:rankdown()"><b>[등급내리기]</b></a> <a href="javascript:send()"><b>[메일보내기]</b></a></td>
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
