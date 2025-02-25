package com.itwill.springboot4.domain;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@MappedSuperclass
//-> 다른 엔터티 클래스의 상위 클래스로 사용됨. 분리된 테이블과 매핑되는 엔터티는 아님. 
public class BaseTimeEntity {
	
	private LocalDateTime createdTime;
	
	private LocalDateTime modifiedTime;

}
