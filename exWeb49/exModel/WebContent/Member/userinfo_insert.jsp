<%@ page contentType="text/html; charset=UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<title>회원등록</title>
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000; BACKGROUND-POSITION: left top; BACKGROUND-REPEAT: no-repeat;}
-->
.formbox {
	BACKGROUND-COLOR: #F0F0F0; FONT-FAMILY: "Verdana", "Arial", "Helvetica", "돋움"; FONT-SIZE:9pt
} 
--->
</STYLE>
<script>
	function send() {
		if(member.name.value == "") {
			alert("이름을 입력하세요.");
			member.name.focus();
			return;
		}
		if(member.userid.value == "") {
			alert("아이디를 입력하세요.");
			member.userid.focus();
			return;
		} else {
			var useridExp = /^([a-zA-Z]{1})([a-zA-Z0-9]{4,9})$/;
			if(!useridExp.test(member.userid.value)) {
				alert("아이디 유효하지 않음");
				member.userid.focus();
				return;
			}
		}
		if(member.passwd.value == "") {
			alert("비밀번호를 입력하세요.");
			member.passwd.focus();
			return;
		}
		if(member.repasswd.value == "") {
			alert("비밀번호를 확인하세요.");
			member.repasswd.focus();
			return;
		}
		if(member.passwd.value != member.repasswd.value) {
			alert("비밀번호가 다릅니다 다시 입력하세요.");
			member.repasswd.focus();
			return;
		}
		if(member.tel.value == "") {
			alert("전화번호를 입력하세요.");
			member.tel.focus();
			return;
		} else {
			var usertelExp = /^(010[0-9]{8})$/;
			if(!usertelExp.test(member.tel.value)) {
				alert("전화번호 유효하지 않음");
				member.tel.focus();
				return;
			}
		}
		if(member.email.value==""){
	         alert("이메일을 입력하세요");
	         member.email.focus();
	         return;
	      }else{
	         var emailExp = /([\w~\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	         if(!emailExp.test(member.email.value)){
	            alert("이메일이 유효하지 않음");
	            member.email.focus();
	            return;
	         }
	      }
		var flag = 0;
		for (x = 0; x < member.fa.length; x++) {
			if(member.fa[x].checked) {
				flag = 1;
				break;
			}
		}
		if(!flag) {
			alert("관심분야를 체크하세요");
			return;
		}
		if(member.job.selectedIndex == 0) {
			alert("직업을 선택하세요");
			member.job.focus();
			return;
		}
		alert("회원정보를 저장합니다.");
		member.action = "userinfo_insert_pro.jsp";
		member.submit();
	}
	// 아이디 중복검사 스크립트
	function id_check() {
		window.open("id_check.jsp", "아이디 중복체크", "width=330, height=220");
	}
	// 우편번호 검색 창
	function post_check() {
		var url = "post_check.jsp";
		window.open(url, "우편번호검색", "width = 350 height = 250 scrollbars = yes");
	}
	// 다시쓰기
	function del() {
		location.reload();
	}
</script>
</head>

<body bgcolor="#FFFFFF" LEFTMARGIN=0  TOPMARGIN=0 >
 
 <!-- 탑 메뉴 영역 삽입-->


<table border="0" width="800">
<tr>
  <td width="20%"  bgcolor="#ecf1ef" valign="top" style="padding-left:0;">
	
	<!--로그인 영역 삽입-->

  </td>
  <td width="80%" valign="top">&nbsp;<img src="./img/title1.gif" ><br>    
	<form name = "member" method = "post">
	<table border=0 cellpadding=0 cellspacing=0 border=0 width=730 valign=top>
		<tr><td align=center><br>                            
			<table cellpadding=0 cellspacing=0 border=0 width=650 align=center>       
				<tr>
					<td bgcolor="#7AAAD5">            
						<table cellpadding=0 cellspacing=0 border=0 width=100%>
							<tr bgcolor=#7AAAD5>
								<td align=left BORDER="0" HSPACE="0" VSPACE="0"><img src="./img/u_b02.gif"></td>
								<td align=center bgcolor="#7AAAD5"><FONT COLOR="#FFFFFF"><b>사용자등록&nbsp;</b><font color=black>(</font><font color=red>&nbsp;*&nbsp;</font><font color=black>표시항목은 반드시 입력하십시요.)</font></FONT></td>
								<td align=right BORDER="0" HSPACE="0" VSPACE="0"><img src="./img/u_b03.gif"></td>
							</tr>
						</table>
						<table cellpadding=3 cellspacing=1 border=0 width=100%>
							<tr>
								<td width=110 bgcolor=#EFF4F8>&nbsp;회원 성명<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=name size=16 maxlength=20 value="">성명은 빈칸없이 입력하세요.
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;회원 ID<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<table cellspacing=0 cellpadding=0>
										<tr>
											<td align=absmiddle>
												<input type=text name=userid size=12 maxlength=16 value="" placeholder = "중복검사를 해주세요." style="width:180" readonly>
											</td>
											<td><a href = "javascript:id_check()"><img src="./img/u_bt01.gif" hspace=2 border=0 name=img1  align=absmiddle></a>
                   										5~16자 이내의 영문이나 숫자만 가능합니다.
                  							</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<input type=password name=passwd size=8 maxlength=12 style="width:80">
											6~12자 이내의 영문이나 숫자만 가능합니다.
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;비밀번호확인<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE><input type=password name=repasswd size=8 maxlength=12 value="" style="width:80">비밀번호 확인을 위해서 비밀번호를 한번 더 입력해주세요. </td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;주소구분<font color=red>&nbsp;</font></td>
								<TD BGCOLOR=WHITE>
									<input type=radio name=gubun checked value = "직장">직장&nbsp;&nbsp;
									<input type=radio name=gubun value = "자택">자택 
								</td>
							</tr>
							
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;우편번호<font color=red>&nbsp;</font></td>
								<TD BGCOLOR=WHITE>
									<table cellspacing=0 cellpadding=0>
										<tr>
											<td><input type=text name=zipcode size=6 placeholder = "우편번호검색" style="width:100" maxlength=6 readonly></td>
                  							<td><a href = "#" onClick = "post_check()"><img src="./img/u_bt07.gif" hspace=2 border=0 name=img2 align=absmiddle></a></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;주소<font color=red>&nbsp;</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=addr1 size=50 maxlength=100 value="" readonly>
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;나머지 주소<font color=red>&nbsp;</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=addr2 size=50 maxlength=100 value="">
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;전화번호<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=tel size=13 maxlength=13 value="">
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;E-mail<font color=red>&nbsp;*</font>
								</td>
								<td bgcolor=WHITE valign=middle>
									<input type=text name=email size=30 maxlength=30 value="">
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;관심분야
                					<font color=red>&nbsp;*</font>
								</td>
								<td bgcolor=WHITE valign=middle> 
									<input type="checkbox" name="fa" value="건강">건강 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="fa" value="문화예술">문화예술 &nbsp;&nbsp;
									<input type="checkbox" name="fa" value="경제">경제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="fa" value="연예오락">연예오락 &nbsp;
									<input type="checkbox" name="fa" value="뉴스">뉴스
									<br><input type="checkbox" name="fa" value="여행레져">여행레져 &nbsp;&nbsp;
									<input type="checkbox" name="fa" value="생활">생활 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="fa" value="스포츠">스포츠 &nbsp;&nbsp;
									<input type="checkbox" name="fa" value="교육">교육 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="fa" value="컴퓨터">컴퓨터 &nbsp;&nbsp;
									<input type="checkbox" name="fa" value="학문">학문 &nbsp;&nbsp;
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;직업<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<select name=job class="formbox">
 										<option value="0">선택하세요 ---
 										<option value="회사원">회사원
 										<option value="연구전문직">연구전문직
 										<option value="교수학생">교수학생
 										<option value="일반자영업">일반자영업
 										<option value="공무원">공무원
 										<option value="의료인">의료인
 										<option value="법조인">법조인
 										<option value="종교,언론,예술인">종교.언론/예술인
 										<option value="농,축,수산,광업인">농/축/수산/광업인
 										<option value="주부">주부
 										<option value="무직">무직
 										<option value="기타">기타
									</select>
								</td>                
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;자기소개<font color=red>&nbsp;</font></td>
								<TD BGCOLOR=WHITE>
									<textarea cols=65 rows=5 name="intro"></textarea>
								</td>
							</tr>
						</table>
						<table cellpadding=0 cellspacing=0 border=0 width=100%>
							<tr bgcolor=#7AAAD5>
								<td valign=bottom>
									<img src="./img/u_b04.gif" align=left hspace=0 vspace=0 border=0>
								</td>
								<td align=center></td>
								<td valign=bottom>
									<img src="./img/u_b05.gif" align=right hspace=0 vspace=0 border=0>
								</td>
							</tr>
							<tr bgcolor=#ffffff>
								<td colspan=3 align=center>
									<a href="javascript:send()"><img src="./img/u_bt06.gif" vspace=3 border=0 name=img3></a>
									<a href="javascript:del()"><img src="./img/u_bt05.gif" border=0 hspace=10 vspace=3 name=img4></a>
								</td>
							 </tr>
						</table> 
					</td>
				</tr>
			</td>
		</tr>
	</table>
	</form>
	</td>
</tr>
</table>

 <!-- copyright 영역 삽입-->
  

</body>
</html>
