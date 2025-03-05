package com.itwill.springboot4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//-> 스프링 컨테이너에서 생성하고 관리하는 설정 컴포넌트.
//-> 스프링 컨테이너에서 필요한 곳에 의존성을 주입해 줄 수 있음.

public class SecurityConfig {
	
	// Spring Security 5 버전부터 비밀번호는 반드시 암호화(encoding)를 해야만 함.
	// 만약 비밀번호를 암호화하지 않으면 HTTP 403(access denied, 접근 거부) 또는
	// HTTP 500 (internal server error, 내부 서버 오류) 에러가 발생.
	// 비밀번호를 암호화하는 객체를 스프링 컨테이너가 빈으로 관리해야 함.
	@Bean //-> 스프링 컨테이너에서 관리하는 객체(빈) -> 의존성 주입.
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 사용자(User) 엔터티, 리포지토리와 사용자 서비스를 구현하기 전에 테스트 용도로 사용할 코드.
	@Bean
	UserDetailsService inMemoryUserDetailsService() {
		// 애플리케이션 동작 중에 메모리에 임시 저장할 사용자 객체를 생성
		UserDetails user1 = User.withUsername("user1")  // 로그인 사용자 아이디
				.password(passwordEncoder().encode("1111"))  // 암호화된 로그인 사용자 비밀번호
				.roles("USER")  // 사용자 권한
				.build();
		UserDetails user2 = User.withUsername("user2")
				.password(passwordEncoder().encode("2222"))
				.roles("ADMIN")
				.build();
		UserDetails user3 = User.withUsername("user3")
				.password(passwordEncoder().encode("3333"))
				.roles("USER", "ADMIN")
				.build();
		
		// User 타입 객체 3개를 메모리에서만 관리하는 사용자 상세정보 매니저 객체를 생성하고 리턴.
		return new InMemoryUserDetailsManager(user1, user2, user3);
	}

}
