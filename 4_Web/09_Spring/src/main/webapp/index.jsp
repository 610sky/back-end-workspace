<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>회원 관리 기능</h1>

    <ul>
    	<c:choose>
    	<c:when test="${empty info}">
    		<!-- 로그인 되어 있지 않은 경우 -->
      <li><a href="/register">회원가입</a></li>
      <!-- 회원가입 : 아이디, 비밀번호, 이름 입력 받아서 -->
      <li><a href="/login">로그인</a></li>
      <!-- 로그인 : 아이디, 비밀번호 입력 받아서 -->
       </c:when>
       <c:otherwise>
    		<!-- 로그인 된 경우 -->
      <h2>${info.name}님</h2>
          <li><a href="/search">회원검색</a></li>
          <!-- 회원검색 : 검색할 아이디 입력받아서 -->
          <li><a href="/allMember">전체회원보기</a></li>
          <!-- 전체회원보기 : views/allMember.jsp에 리스트 출력 -->
          <li><a href="/logout">로그아웃</a></li>
          <!-- 로그아웃 : 로그아웃하고 index.jsp로! -->
       </c:otherwise>
       </c:choose>
    </ul>
  </body>
</html>
