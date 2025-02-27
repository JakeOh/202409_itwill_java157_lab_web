package com.itwill.springboot4.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.itwill.springboot4.domain.Comment;
import com.itwill.springboot4.dto.CommentRegisterDto;
import com.itwill.springboot4.dto.CommentUpdateDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CommentServiceTest {
	
	@Autowired
	private CommentService commentService;
	
//	@Test
	public void testCreateComment() {
		CommentRegisterDto dto = new CommentRegisterDto(57L, "comment register test", "admin");
		Comment entity = commentService.create(dto);
	}
	
//	@Test
	public void testReadById() {
		// 댓글 아이디가 DB에 있는 경우
		Comment comment1 = commentService.read(21L);
		assertThat(comment1).isNotNull();
		log.info("comment1 = {}", comment1);
		
		// 댓글 아이디가 DB에 없는 경우
		Comment comment2 = commentService.read(11L);
		assertThat(comment2).isNull();
	}
	
//	@Test
	public void makeDummyComments() {
		for (int i = 1; i <= 10; i++) {
			CommentRegisterDto dto = new CommentRegisterDto(57L, "댓글 놀이 #" + i, "admin");
			Comment entity = commentService.create(dto);
			assertThat(entity).isNotNull();
		}
	}
	
//	@Test
	public void testReadByPostId() {
		Page<Comment> page = commentService.read(57L, 2, Sort.by("id").descending());
		page.forEach(System.out::println);
	}
	
//	@Test
	public void testDelete() {
		commentService.delete(30L);
	}
	
	@Test
	public void testUpdate() {
		CommentUpdateDto dto = new CommentUpdateDto();
		dto.setId(32L);
		dto.setText("JPA를 사용한 댓글 업데이트 서비스");
		
		commentService.update(dto);
	}

}
