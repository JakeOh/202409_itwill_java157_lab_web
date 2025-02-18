package com.itwill.springboot2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot2.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {

	@Autowired  // 의존성 주입(Dependency Injection)
	private EmployeeRepository empRepo;
	
//	@Test
	public void test() {
		assertThat(empRepo).isNotNull();  // empRepo 객체가 null이 아니면 테스트 성공.
		log.info("empRepo = {}", empRepo);
	}
	
//	@Test
	public void testFindAll() {
		// findAll(): "select * from emp" SQL을 실행하는 메서드. 전체 검색.
		List<Employee> list = empRepo.findAll();
		assertThat(list.size()).isEqualTo(14);
		
		list.forEach(emp -> log.info("{}", emp));
	}
	
	@Test
	public void testFindById() {
		// findById(): PK로 검색하는 메서드. "select * from emp where empno = ?" SQL을 실행하는 메서드.
		Employee emp = empRepo.findById(7788).orElseThrow();
		assertThat(emp.getEname()).isEqualTo("SCOTT");
		log.info("{}", emp);
	}
	
}
