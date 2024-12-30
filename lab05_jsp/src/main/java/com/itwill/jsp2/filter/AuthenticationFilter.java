package com.itwill.jsp2.filter;

import java.io.IOException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter extends HttpFilter {
    private static final long serialVersionUID = 1L;
    private final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

	/**
     * @see HttpFilter#HttpFilter()
     */
    public AuthenticationFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// 필터 객체를 소멸시킬 때(힙에서 삭제하기 전에) WAS가 호출하는 메서드.
		// 필터가 사용하던 리소스들을 해제.
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.debug("doFilter()");
		
		// 인증이 필요한 요청 주소들(새글, 상세보기, ...)에 대해서
		// 로그인 여부(세션에 signedInUser 속성이 있는 지)를 확인하고,
		// (1) 로그인되어 있으면, 컨트롤러(서블릿)으로 요청을 전달(chain.doFilter()를 호출).
		// (2) 로그인되어 있지 않으면, 컨트롤러로 요청을 전달하지 않고 로그인 페이지로 이동.
		// -> 로그인을 담당하는 컨트롤러에서 로그인 성공 후에 최초 요청 페이지로 이동할 수 
		// 있도록 설정.

		HttpServletRequest req = (HttpServletRequest) request; // casting
		HttpServletResponse resp = (HttpServletResponse) response;

		// URL(Uniform Resource Location)
		String reqUrl = req.getRequestURL().toString();
		log.debug("request URL = {}", reqUrl);
		
		// URI(Uniform Resource Identifier)
		String reqUri = req.getRequestURI();
		log.debug("request URI = {}", reqUri);
		
		String contextPath = req.getContextPath();
		log.debug("context path = {}", contextPath);
		
		String qs = req.getQueryString();
		log.debug("query string = {}", qs);
		
		// 로그인 이후에 이동할 페이지(타겟)
		String target = null;
		if (qs != null) { // 질의 문자열이 있는 경우
			target = URLEncoder.encode(reqUrl + "?" + qs, "UTF-8");
		} else { // 질의 문자열이 없는 경우
			target = URLEncoder.encode(reqUrl, "UTF-8");
		}
		log.debug("target = {}", target);
		
		// 세션에 signedInUser 속성이 있는 지 체크:
		HttpSession session = req.getSession();
		Object signedInUser = session.getAttribute("signedInUser");
		if (signedInUser != null) { // 로그인 상태
			log.debug("로그인 사용자: {}", signedInUser);
			
			// 필터 체인을 통해서(그 다음 필터 또는 서블릿으로) 요청을 전달.
			chain.doFilter(request, response);
			
		} else { // 로그아웃 상태
			log.debug("로그아웃 상태 --> 로그인 페이지로 이동 --> 로그인 성공 후 target으로 이동");
			
			String url = req.getContextPath() + "/user/signin?target=" + target;
			resp.sendRedirect(url);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// WAS가 필터 객체를 생성한 직후에 호출하는 메서드.
		// 필터에 필요한 초기화 작업들.
	}

}
