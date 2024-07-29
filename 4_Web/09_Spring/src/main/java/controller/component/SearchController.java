package controller.component;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.kh.model.DAO.MemberDAO;
import com.kh.model.vo.Member;

/*
 * 컴포넌트
 * - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스
 * */
public class SearchController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		String id = request.getParameter("id");

		MemberDAO dao = new MemberDAO();
		Member member = dao.searchMember(id);
		
		if(member != null) {
			request.setAttribute("member", member);
			return new ModelAndView("views/search_ok.jsp");
		} else {
			return new ModelAndView("views/search_fail.jsp",true);
		}
	}
	
}
