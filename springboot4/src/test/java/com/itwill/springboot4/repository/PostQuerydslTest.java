package com.itwill.springboot4.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.itwill.springboot4.domain.Post;
import com.itwill.springboot4.dto.PostSearchDto;

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
//		List<Post> result = null;

//		result = postRepo.searchByKeyword("DUM");
		
//		LocalDateTime start = LocalDateTime.of(2025, 3, 1, 0, 0);
//		LocalDateTime end = LocalDateTime.of(2025, 3, 10, 0, 0);
//		result = postRepo.searchByModifiedTime(start, end);
		
		PostSearchDto dto = new PostSearchDto();
		dto.setCategory("tc");
		dto.setKeyword("dum");
//		result = postRepo.searchByCategoryAndKeyword(dto);
		
		Pageable pageable = PageRequest.of(4, 10, Sort.by("id").descending());
		Page<Post> result = postRepo.searchByKeyword(dto, pageable);
		
		result.forEach(System.out::println);
	}

}
