package com.itwill.spring2.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.spring2.domain.Post;
import com.itwill.spring2.repository.PostDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 초기화할 수 있는 아규먼트(들)을 갖는 생성자.
@Service // 스프링 컨테이너에 서비스 컴포넌트로 등록.
public class PostService {
	// 의존성 주입 방법:
	// (1) 애너테이션을 사용한 의존성 주입
	// (2) final 필드와 생성자를 사용한 의존성 주입 -> 스프링 공식 문서에서 권장하는 방법.
	
	// (1) 애너테이션을 사용한 의존성 주입(DI: Dependency Injection)
	// @Autowired private PostDao postDao;

	// (2) final 필드와 생성자를 사용한 의존성 주입
	private final PostDao postDao;
	
//	public PostService(PostDao postDao) {
//		this.postDao = postDao;
//	}
	
	// 목록 보기 서비스
	public List<Post> read() {
		log.debug("read()");
		
		List<Post> list = postDao.selectOrderByIdDesc();
		
		return list;
	}
	
	// 상세보기 서비스
	public Post read(Integer id) {
		// TODO
		return null;
	}
	
	// 새글작성 서비스
	public int create(Post post) {
		// TODO
		return 0;
	}
	
	// 수정하기 서비스
	public int update(Post post) {
		// TODO
		return 0;
	}
	
	// 삭제하기 서비스
	public int delete(Integer id) {
		// TODO
		return 0;
	}
	
}
