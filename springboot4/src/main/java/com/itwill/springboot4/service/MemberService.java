package com.itwill.springboot4.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itwill.springboot4.domain.Member;
import com.itwill.springboot4.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {
	
	private final MemberRepository memberRepo;
	private final PasswordEncoder passwordEncoder;
	
	// UserDetailsService 인터페이스의 추상 메서드 구현(재정의)
	// 스프링 시큐리티 필터들에서 loadUserByUsername() 메서드를 사용하기 때문에 반드시 구현.
	// 아규먼트 username으로 사용자 정보를 찾을 수 있으면 UserDetails (또는 그 하위 타입) 
	// 객체를 리턴하고, 사용자 정보를 찾을 수 없으면 UsernameNotFoundException 예외를 발생.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserByUsername(username={})", username);
		
		Optional<Member> entity = memberRepo.findByUsername(username);
		if (entity.isPresent()) {
			// Optional 객체가 null이 아닌 Member 객체를 가지고 있으면
			return entity.get();
		} else {
			throw new UsernameNotFoundException(username + "과 일치하는 사용자 정보가 없음.");
		}
	}

}
