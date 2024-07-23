package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.DAO.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		
		Member member = null;
		
		// 1. 폼 값 받기
		String id = request.getParameter("id");
		
		// 2. DAO 호출
		try {
			member = dao.searchMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. 바인딩
		request.setAttribute("member", member);
		
		// 4. 네비게이션
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

}
