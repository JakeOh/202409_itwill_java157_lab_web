package com.itwill.jsp1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class SessionController
 */
@WebServlet(name = "sessionController", urlPatterns = { "/session" })
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionController() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		System.out.println("SessionController::doGet() 호출");
		
		HttpSession session = request.getSession();
		session.setAttribute("nickname", "관리자");
		
		// 뷰로 이동.
		request.getRequestDispatcher("/WEB-INF/views/session.jsp")
				.forward(request, response);
	}

}
