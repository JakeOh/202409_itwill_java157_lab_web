package com.itwill.jsp1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// WAS(Web Application Server)
// - 웹 요청(request)과 응답(response)을 처리하는 프로그램. (예) Tomcat
// - WAS는 시작될 때 web.xml 파일을 읽어서 웹 서비스 준비(초기화)를 진행함.
// web.xml 파일: 배포 설명자(deployment descriptor).
// 클라이언트에서 요청이 왔을 때 WAS는 web.xml에 작성된 서블릿 설정을 보고,
// 요청 주소에 매핑된 서블릿 클래스의 doGet() 또는 doPost() 메서드를 호출함.
// Servlet: Server + Applet. 서버에서 실행되는 작은 자바 프로그램.

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // GET 방식의 요청일 때 WAS가 호출하는 메서드.
    // 파라미터 request: 클라이언트에서 서버로 보낸 요청의 정보 등을 저장하고 있는 객체.
    // 파라미터 response: 서버가 클라이언트로 보낼 응답의 데이터, 기능 등을 갖는 객체.
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		System.out.println("FirstServlet::doGet() 호출");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.append("<!doctype html>")
				.append("<html>")
				.append("	<head>")
				.append("		<meta charset='UTF-8' />")
				.append("		<title>Servlet</title>")
				.append("	</head>")
				.append("	<body>")
				.append("		<h1>첫번째 서블릿</h1>")
				.append("		<a href='/jsp1'>목차</a>")
				.append("	</body>")
				.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// POST 방식의 요청일 때 WAS가 호출하는 메서드.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
