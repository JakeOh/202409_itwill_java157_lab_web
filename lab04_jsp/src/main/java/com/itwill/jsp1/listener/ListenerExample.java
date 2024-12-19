package com.itwill.jsp1.listener;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class ListenerExample
 *
 */
// WAS가 시작될 때 리스너 객체를 생성하고 관리할 수 있도록 설정:
// (1) web.xml 파일에서 <listener> 태그로 설정.
// (2) @WebListener 애너테이션으로 설정.
// (주의) 한 개의 리스너 클래스는 web.xml과 애너테이션을 둘 다 동시에 설정할 수는 없음.
public class ListenerExample 
	implements ServletRequestListener, ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public ListenerExample() {
        System.out.println("ListenerExample() 생성자 호출");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre)  { 
         System.out.println("요청이 초기화됨.");
         
         ServletRequest req = sre.getServletRequest();
         if (req instanceof HttpServletRequest) { // type checking
        	 HttpServletRequest httpReq = (HttpServletRequest) req; // casting
        	 String uri = httpReq.getRequestURI();
        	 System.out.println("[Request URI] " + uri);
        	 System.out.println("[Request URL] " + httpReq.getRequestURL());
         }
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre)  { 
         System.out.println("요청이 소멸됨.");
    }
	
    
    
}
