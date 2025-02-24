package com.itwill.springboot4.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "posts")
public class Post {
	
	@Id
	private Long id;
	
	private String title;
	
	private String content;
	
	private String author;
	
	private LocalDateTime createdTime;
	
	private LocalDateTime modifiedTime;
	
}
