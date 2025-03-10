package com.itwill.springboot4.repository;

import java.time.LocalDateTime;
import java.util.List;

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
	
//	@Test
	public void testSearchById() {
		Post entity = postRepo.searchById(61L);
		log.info("querydsl 결과: {}", entity);
	}
	
	@Test
	public void testSearch() {
		List<Post> result = null;

//		result = postRepo.searchByKeyword("DUM");
		
		LocalDateTime start = LocalDateTime.of(2025, 3, 1, 0, 0);
		LocalDateTime end = LocalDateTime.of(2025, 3, 10, 0, 0);
		result = postRepo.searchByModifiedTime(start, end);
		
		result.forEach(System.out::println);
	}

}
