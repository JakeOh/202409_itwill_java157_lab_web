package com.itwill.spring1.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ExampleController {

	@GetMapping("/")
	public String home(Model model) {
		log.debug("home()");
		
		LocalDateTime now = LocalDateTime.now(); // 현재 시간
		model.addAttribute("now", now);
		
		return "home";
	}
	
}
