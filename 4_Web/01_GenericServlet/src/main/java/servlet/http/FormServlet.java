package servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		char gender = request.getParameter("gender").charAt(0);
		String[] menues = request.getParameterValues("menu");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>정보를 출력합니다..</h1>");
		out.println("<p>당신의 아이디는 " + id + "</p>");
		out.println("<p>당신의 비밀번호는 " + pwd + "</p>");
		out.println("<p>당신의 성별은 " + (gender=='M' ? "남자" : "여자") + "</p>");
		out.println("<ul>");
		for(String menu : menues) {
			out.println("<li>" + menu + "</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
	}

}
