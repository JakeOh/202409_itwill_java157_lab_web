package com.itwill.spring2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화할 수 있는 아규먼트를 갖는 생성자.
@Controller // 컨트롤러 컴포넌트
@RequestMapping("/post")
//-> PostController 클래스의 모든 메서드의 매핑 주소는 "/post"로 시작.
//-> GET/POST 등 모든 요청 방식(method)을 처리.
public class PostController {
	
	@GetMapping("/list") //-> GET 방식의 /post/list 주소를 처리하는 컨트롤러 메서드.
	public void list() {
		log.debug("list()");
		// 컨트롤러 메서드의 리턴 타입이 void
		// -> 뷰의 이름: /WEB-INF/views/post/list.jsp
	}

}
