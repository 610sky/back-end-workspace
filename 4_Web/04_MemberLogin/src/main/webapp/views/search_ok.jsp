<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import = "model.vo.Member" %>
	<%
	Member member = (Member) request.getAttribute("member");
	%>

	<h1>회원 검색 결과</h1>
	<ul>
		<li>아이디 : <%=member.getId() %></li>
		<li>비밀번호 : <%=member.getPassword() %></li>
		<li>이름 : <%=member.getName() %></li>
	</ul>
	<a href="/">메인 페이지로 이동</a>
</body>
</html>