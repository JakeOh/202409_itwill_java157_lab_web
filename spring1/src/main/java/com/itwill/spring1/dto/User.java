package com.itwill.spring1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data //-> @Getter, @Setter, @toString, @EqualsAndHashCode, @RequiredArgsConstructor
// @RequiredArgsConstructor: final 필드를 초기화할 수 있는 아규먼트(들)을 갖는 생성자.
@NoArgsConstructor //-> 기본 생성자.
@AllArgsConstructor //-> 모든 필드를 초기화할 수 있는 아규먼트들을 갖는 생성자.
@Builder //-> Builder 디자인 패턴을 적용.
public class User {
	private String username;
	private int age;
}
