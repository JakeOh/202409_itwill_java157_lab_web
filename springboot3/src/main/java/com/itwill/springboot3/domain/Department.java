package com.itwill.springboot3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "departments")
public class Department {
	
	@Id
	@Column(name = "department_id")
	private Integer id;
	
	private String departmentName;
	
	private Integer managerId;
	
	private Integer locationId;

}
