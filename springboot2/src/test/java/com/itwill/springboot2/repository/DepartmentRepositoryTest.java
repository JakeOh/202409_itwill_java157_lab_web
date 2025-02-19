package com.itwill.springboot2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot2.domain.Department;
import com.itwill.springboot2.domain.Employee;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DepartmentRepositoryTest {
	
	@Autowired // 애너테이션을 사용한 의존성 주입
	private DepartmentRepository deptRepo;
	
	@Test
	public void testFindAll() {
		List<Department> list = deptRepo.findAll();
		assertThat(list.size()).isEqualTo(4);
		
		list.forEach(System.out::println);  // (x) -> System.out.println(x)
	}
	
	@Test
	@Transactional
	public void testFindById() {
		Department dept1 = deptRepo.findById(30).orElseGet(() -> null);
		assertThat(dept1.getDname()).isEqualTo("SALES");
		log.info("dept1 = {}", dept1);
		
		// 30번 부서에서 근무하는 모든 직원들의 정보를 출력
		List<Employee> employees = dept1.getEmployees();
		employees.forEach(System.out::println);
		
		Department dept2 = deptRepo.findById(0).orElseGet(() -> null);
		assertThat(dept2).isNull();
	}

}
