package com.itwill.springboot4.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.itwill.springboot4.domain.Post;
import com.itwill.springboot4.dto.PostSearchDto;

public interface PostQuerydsl {
	
	// 포스트 아이디(id)가 일치하는 엔터티 검색
	Post searchById(Long id);
	
	// 제목 또는 내용에 포함된 단어로 검색, id의 내림차순 정렬.
	List<Post> searchByKeyword(String keyword);
	
	// 수정시간이 start와 end 사이인 포스트 목록 검색, 수정시간 내림차순 정렬.
	List<Post> searchByModifiedTime(LocalDateTime start, LocalDateTime end);

	// Dynamic query(동적 쿼리)
	List<Post> searchByCategoryAndKeyword(PostSearchDto dto);
	
	// Page<T> 객체를 리턴하는 Querydsl
	Page<Post> searchByKeyword(PostSearchDto dto, Pageable pageable);
	
}
