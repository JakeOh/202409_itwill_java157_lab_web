package com.itwill.spring1.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

//POCO(Plain Old C++(C#) Object)
//POJO(Plain Old Java Object): 간단한 오래된 자바 객체.
//특정 클래스를 상속(extends)하거나, 특정 인터페이스를 구현(implements)할 필요가 없는
//(상위 타입의 특정 메서드들을 반드시 재정의할 필요가 없는) 평범한 자바 객체.
//스프링 MVC 프레임워크에서는 POJO로 작성된 클래스를 컨트롤러로 사용할 수 있음!
//(비교) HttpServlet을 상속받는 클래스에서는 doGet(req, resp) 또는 doPost(req, resp)를
//반드시 재정의(override)해야 웹 서비스(요청 처리)가 가능.

@Slf4j
//-> private static final Logger log = LoggerFactory.getLogger(ExampleController.class);
// 코드를 애너테이션으로 처리.
@Controller
//-> 클래스가 컨트롤러 컴포넌트임을 설정하는 애너테이션.
// servlet-context.xml 파일에서 <context:component-scan ... /> 태그에서 설정된 패키지와 
// 그 하위 패키지에서 @Controller 애너테이션을 사용한 클래스를 찾음.
public class ExampleController {

	@GetMapping("/")
	//-> GET 방식, 요청 주소가 컨텍스트 루트(예: /spring1/)인 요청을 처리하는 메서드임을 설정하는 애너테이션.
	public String home(Model model) {
		log.debug("home()");
		
		LocalDateTime now = LocalDateTime.now(); // 현재 시간
		model.addAttribute("now", now);
		
		return "home";
		//-> 컨트롤러 메서드가 문자열을 리턴하면, 디스패쳐 서블릿이 뷰의 이름을 찾는 데 사용.
		// servlet-context.xml 파일에서 <bean> 태그에서 설정된 ViewResolver 설정을 사용함.
		// 디스패쳐 서블릿이 뷰 리졸버를 이용해서 요청을 포워드할
		// 뷰의 경로(/WEB-INF/view/returnValue.jsp)를 찾을 수 있음.
	}
	
}
