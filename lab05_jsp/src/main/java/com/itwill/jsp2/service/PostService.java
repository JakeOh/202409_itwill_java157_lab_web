package com.itwill.jsp2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.domain.Post;
import com.itwill.jsp2.repository.PostDao;

// 웹 MVC 아키텍쳐에서 서비스/비즈니스 계층(service/business layer)을 담당하는 객체.
// 영속성 계층의 기능들을 사용해서 비즈니스 로직(서비스)을 구현하는 객체.
public enum PostService {
	INSTANCE; // 싱글톤 객체.
	
	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	private final PostDao postDao = PostDao.INSTANCE;

	public List<Post> read() {
		log.debug("read()");
		
		return postDao.select();
	}
	
}
