package com.itwill.jsp2.web.user;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.domain.Member;
import com.itwill.jsp2.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserSignUpController
 */
@WebServlet(name = "userSignUpController", urlPatterns = { "/user/signup" })
public class UserSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UserSignUpController.class);
	private final MemberService memberService = MemberService.INSTANCE;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUpController() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		log.debug("doGet()");
		
		// /WEB-INF/views/user/signup.jsp 로 이동(forward)
		request.getRequestDispatcher("/WEB-INF/views/user/signup.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 양식 데이터(username, password, email)의 값들을 읽음.
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		log.debug("doPost(username={}, password={}, email={})", username, password, email);
		
		// 서비스 계층의 메서드를 호출해서 DB members 테이블에 회원정보를 삽입.
		Member member = Member.builder()
				.username(username).password(password).email(email)
				.build();
		memberService.signUp(member);
		
		// 홈 페이지 이동(redirect)
		String url = request.getContextPath() + "/";
		response.sendRedirect(url);
	}

}
