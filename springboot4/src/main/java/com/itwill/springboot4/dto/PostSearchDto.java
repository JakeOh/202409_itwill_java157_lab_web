package com.itwill.springboot4.dto;

import lombok.Data;

@Data
public class PostSearchDto {
	private String category;  // 검색 카테고리
	private String keyword;  // 검색어
	private int p;  // 검색 결과 페이지 번호
}
