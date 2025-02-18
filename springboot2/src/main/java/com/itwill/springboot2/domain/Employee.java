package com.itwill.springboot2.domain;

import java.time.LocalDate;

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
@Table(name = "EMP")
public class Employee {

	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private LocalDate hiredate;
	private Double sal;
	private Double comm;
	private Integer deptno;
	
}
