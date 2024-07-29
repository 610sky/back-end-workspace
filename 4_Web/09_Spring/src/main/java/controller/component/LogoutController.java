package controller.component;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.kh.model.DAO.MemberDAO;
import com.kh.model.vo.Member;

/*
 * 컴포넌트
 * - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스
 * */
public class LogoutController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse respone) throws Exception {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("info");
		
		if(member!=null) {
			session.invalidate();
		}
		
		return new ModelAndView("index.jsp",true);
	}
	
}
