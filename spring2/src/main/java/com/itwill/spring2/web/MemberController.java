package com.itwill.spring2.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.spring2.domain.Member;
import com.itwill.spring2.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// 회원가입, 로그인, 로그아웃 컨트롤러
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class MemberController {
	
	// final 필드와 생성자를 사용한 의존성 주입.
	private final MemberService memberService;
	
	@GetMapping("/signup")
	public void signUp() {
		log.debug("[GET] signUp()");
	}
	
	// username 중복체크
	// 중복되지 않은 username이면 "Y", 중복된 username이면 "N"을 전송(응답).
	@GetMapping("/checkusername")
	@ResponseBody
	public ResponseEntity<String> checkUsername(@RequestParam String username) {
		log.debug("checkUsername(username={})", username);
		
		boolean result = memberService.checkUsername(username);
		
		if (result) {
			return ResponseEntity.ok("Y");
		} else {
			return ResponseEntity.ok("N");
		}
	}
	
	// 이메일 중복 체크
	// 중복되지 않은 이메일이면 "Y", 중복된 이메일이면 "N"를 응답으로 전송.
	@GetMapping("/checkemail")
	@ResponseBody
	public ResponseEntity<String> checkEmail(@RequestParam String email) {
		log.debug("checkEmail(email={})", email);
		
		boolean result = memberService.checkEmail(email);
		
		return result ? ResponseEntity.ok("Y") : ResponseEntity.ok("N");
	}

}
