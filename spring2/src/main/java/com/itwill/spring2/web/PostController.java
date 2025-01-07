package com.itwill.spring2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.spring2.domain.Post;
import com.itwill.spring2.dto.PostCreateDto;
import com.itwill.spring2.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화할 수 있는 아규먼트를 갖는 생성자.
@Controller // 컨트롤러 컴포넌트
@RequestMapping("/post")
//-> PostController 클래스의 모든 메서드의 매핑 주소는 "/post"로 시작.
//-> GET/POST 등 모든 요청 방식(method)을 처리.
public class PostController {
	
	// final 필드와 생성자를 사용한 의존성 주입:
	private final PostService postService;
	
	@GetMapping("/list") //-> GET 방식의 /post/list 요청 주소를 처리하는 컨트롤러 메서드.
	public void list(Model model) {
		log.debug("list()");
		
		List<Post> list = postService.read();
		model.addAttribute("posts", list); //-> 뷰에 전달할 데이터.
		
		// 컨트롤러 메서드의 리턴 타입이 void
		// -> 뷰의 이름: /WEB-INF/views/post/list.jsp
	}

	@GetMapping("/create")
	public void create() {
		log.debug("GET create()");
	}
	
	@PostMapping("/create")
	public String create(PostCreateDto dto) {
		log.debug("POST create(dto={})", dto);
		
		// controller ==> service 메서드 호출 & DTO를 아규먼트로 전달.
		int result = postService.create(dto);
		
		return "redirect:/post/list";
	}
	
	@GetMapping("/details")
	public void details(@RequestParam Integer id, Model model) {
		log.debug("details(id={})", id);
		
		// 서비스 계층의 메서드를 호출해서 상세보기 화면에 필요한 데이터를 읽어옴.
		Post post = postService.read(id);
		// 상세보기 내용을 뷰에 전달하기 위해서 Model에 속성으로 추가.
		model.addAttribute("post", post);
	}
	
}
