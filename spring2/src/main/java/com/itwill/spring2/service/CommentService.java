package com.itwill.spring2.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.spring2.domain.Comment;
import com.itwill.spring2.dto.CommentItemDto;
import com.itwill.spring2.repository.CommentDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {
	
	// final 필드와 (필수 아규먼트를 갖는) 생성자를 사용한 의존성 주입
	private final CommentDao commentDao;
	
	// 해당 아이디의 댓글 (1개)를 검색하는 서비스
	public CommentItemDto readById(Integer id) {
		log.debug("readById(id={})", id);
		
		// 영속성 계층의 메서드를 호출해서 select 쿼리를 실행.
		Comment comment = commentDao.selectById(id);
		
		return CommentItemDto.fromEntity(comment);
	}

	// 특정 포스트에 달려 있는 모든 댓글 목록을 검색하는 서비스
	public List<CommentItemDto> readyByPostId(Integer postId) {
		log.debug("readByPostId(postId={})", postId);
		
		List<Comment> list = commentDao.selectByPostId(postId);
		
//		List<CommentItemDto> result = new ArrayList<>();
//		for (Comment c : list) {
//			result.add(CommentItemDto.fromEntity(c));
//		}
//		return result;
		
		return list.stream()
				.map(CommentItemDto::fromEntity) // .map(x -> CommentItemDto.fromEntity(x))
				.toList();
	}
	
}
