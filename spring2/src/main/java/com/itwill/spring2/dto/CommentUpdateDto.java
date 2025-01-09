package com.itwill.spring2.dto;

import com.itwill.spring2.domain.Comment;

import lombok.Data;

@Data
public class CommentUpdateDto {
	private Integer id;
	private String ctext;
	
	// DTO -> Entity 변환
	public Comment toEntity() {
		return Comment.builder().id(id).ctext(ctext).build();
	}
}
