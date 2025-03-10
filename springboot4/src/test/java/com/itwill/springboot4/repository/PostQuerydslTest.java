package com.itwill.springboot4.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot4.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostQuerydslTest {
	
	@Autowired
	private PostRepository postRepo;
	
	@Test
	public void testSearchById() {
		Post entity = postRepo.searchById(61L);
		log.info("querydsl 결과: {}", entity);
	}

}
