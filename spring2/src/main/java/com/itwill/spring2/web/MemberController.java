package com.itwill.spring2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

// 회원가입, 로그인, 로그아웃 컨트롤러
@Slf4j
@Controller
@RequestMapping("/user")
public class MemberController {
	
	@GetMapping("/signup")
	public void signUp() {
		log.debug("[GET] signUp()");
	}

}
