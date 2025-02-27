package com.itwill.springboot4.dto;

import lombok.Data;

@Data
public class CommentUpdateDto {
	private Long id;  // 업데이트할 댓글 아이디
	private String text; // 업데이트할 댓글 내용
}
