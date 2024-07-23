<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- search랑 매핑할 SearchServlet 생성
			search.jsp 결과 보여주기 --%>
	<h2>회원 조회</h2>
	<form action="search">
		검색할 회원 아이디를 입력해주세요<br>
		<input type="text" name="id">
		<input type="submit" value="조회">
	</form>
	<h1>전체 리스트</h1>
	<table border="1">
	<%@ page import = "java.util.ArrayList" %>
	<%@ page import = "com.kh.model.vo.Member" %>
	<%
	ArrayList<Member> memberList = (ArrayList<Member>) request.getAttribute("member");
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
		<%-- 리스트로 가지고 오시고 for문 활용! --%>
	</table>
</body>
</html>