<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="login">
		이름 : <input type="text" name="irum" value=""><br>
		비번 : <input type="password" name="pass"><br>
		성별 : <input type="radio" name="gender">남자<input type="radio" name="gender">여자<br>
		취미 : <input type="checkbox" name="chk">야구<input type="checkbox" name="chk">축구<br>
		<input type="button" value="등록"><input type="button" value="취소"><br>
		학력 : <select name="job">
				<option value="">대졸</option>
				<option value="">초대졸</option>
				<option value="">고졸</option>
			</select><br>
		글내용 : <textarea name="contents" rows="10" cols="50"></textarea><br>
		<input type="submit" value="등록하기"><input type="reset" value="삭제하기">
	</form>
</body>
</html>