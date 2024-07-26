package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.DAO.MemberDAO;
import model.vo.Member;

@WebServlet("/allMember.jsp")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. DAO
		MemberDAO dao = new MemberDAO();
		
		try {
			List<Member> member = dao.printMember();
			
			// 2. 바인딩 : list 전체
			request.setAttribute("member", member);
						
			// 3. 네비게이션
			request.getRequestDispatcher("/views/allMember.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
