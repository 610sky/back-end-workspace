<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 검색</h2>
	<form action="/front">
	<input type="hidden" name="command" value="search">
		검색할 회원 아이디를 입력해주세요<br>
		<input type="text" name="id">
		<input type="submit" value="검색">
	</form>
</body>
</html>