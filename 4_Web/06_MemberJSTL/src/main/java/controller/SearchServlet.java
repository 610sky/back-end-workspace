package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import model.DAO.MemberDAO;
import model.vo.Member;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼 값 받기
		String id = request.getParameter("id");
		
		// 2. DAO 호출
		MemberDAO dao = new MemberDAO();
		
		try {
			Member member = dao.searchMember(id);
			
			if(member != null) {
				// 3. 바인딩
				request.setAttribute("member", member);
				// 4. 네비게이션
				request.getRequestDispatcher("/views/search_ok.jsp").forward(request, response);
			} else
				response.sendRedirect("/views/search_fail.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
