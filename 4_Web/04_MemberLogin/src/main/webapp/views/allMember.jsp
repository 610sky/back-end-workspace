<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 회원 목록</h1>
	<a href="/">메인 페이지로 이동</a>
	<table border="1">
	<%@ page import = "model.vo.Member" %>
	<%
	List<Member> memberList = (List<Member>) request.getAttribute("member");
	%>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
	<%
	for(Member member : memberList) { %>
		<tr>
			<td><%= member.getId() %></td>
			<td><%= member.getPassword() %></td>
			<td><%= member.getName() %></td>
		</tr>
<%	}	%>
	</table>
</body>
</html>