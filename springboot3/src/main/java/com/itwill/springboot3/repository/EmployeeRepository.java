package com.itwill.springboot3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot3.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// JPA Query Method:
	// JPA에서 미리 약속된 키워드들과 엔터티의 필드 이름들을 사용해서
	// 메서드 이름을 (camel 표기법으로) 작성.
	
	// 부서 번호가 일치하는 직원들 검색:
	// select * from employees where department_id = ?
	List<Employee> findByDepartmentId(Integer id);
	
	// 이름(first_name)이 일치하는 직원(들) 검색:
	// select * from employees where first_name = ?
	List<Employee> findByFirstName(String firstName);
	
	// 이름(first_name)이 일치하는 직원(들), 대/소문자는 구분없이 검색:
	// select * from employees where upper(first_name) = upper(?)
	List<Employee> findByFirstNameIgnoreCase(String firstName);
	
	// 이름(first_name)에 포함된 문자열로 검색:
	// select * from employees where first_name like '%' || ? || '%'
	List<Employee> findByFirstNameContaining(String keyword);
	
	// 비교:
	// Containing을 사용하면 아규먼트의 앞/뒤에 "%"를 붙이고 like 검색을 수행.
	// Like를 사용할 때는 아규먼트가 "%"를 포함하고 있어야 함.
	List<Employee> findByFirstNameLike(String keyword);
}
