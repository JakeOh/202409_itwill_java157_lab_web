package com.itwill.springboot2.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * ORM(Object Relation Mapping, 객체 관계 매핑):
 *   객체와 테이블(데이터)를 매핑시키는 기술(표준) 스펙.
 * JPA(Java Persistence API):
 *   자바에서 ORM을 정의한 기술(표준) 스펙.
 * Hibernate: JPA를 구현한 프레임워크.
 */

@NoArgsConstructor
@Getter
// 엔터티 클래스가 setter 메서드를 가지고 있지 않아도,
// JPA/Hibernate 프레임워크는 Reflection을 사용해서 private 필들 값들을 직접 설정할 수 있음.
@ToString
@EqualsAndHashCode
@Entity  // DB의 테이블에 매핑되는 자바 객체
@Table(name = "EMP")  // 엔터티 클래스 이름과 매핑되는 테이블의 이름이 다를 때.
public class Employee {
	
	@Id  // Primary Key. Repository 인터페이스를 선언할 때 사용할 ID 타입.
	@Column(name = "EMPNO")  // 엔터티 필드 이름과 매핑되는 컬럼 이름이 다를 때.
	private Integer id;
	
	private String ename;
	private String job;
	
	@Column(name = "MGR")
	private Integer manager;
	
	private LocalDate hiredate;
	private Double sal;
	private Double comm;
	private Integer deptno;
	
}
