package com.itwill.springboot4.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.springboot4.domain.Comment;
import com.itwill.springboot4.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comment")
public class CommentController {
	
	private final CommentService commentService;
	
	@GetMapping("/all/{postId}")
	public ResponseEntity<Page<Comment>> getCommentList(@PathVariable Long postId,
			@RequestParam(name = "p", defaultValue = "0") int pageNo) {
		log.info("getCommentList(postId={}, pageNo={})", postId, pageNo);
		
		// 서비스 메서드를 호출해서 최종 수정 시간의 내림차순으로 정렬된
		// 한 페이지에 출력할 댓글 목록을 가져옴.
		Page<Comment> page = commentService.read(postId, pageNo, Sort.by("modifiedTime").descending());
		log.info("페이지 수 = {}", page.getTotalPages());
		log.info("페이지 번호 = {}", page.getNumber());
		log.info("현재 페이지의 댓글 개수 = {}", page.getNumberOfElements());
		
		return ResponseEntity.ok(page);
	}

}
