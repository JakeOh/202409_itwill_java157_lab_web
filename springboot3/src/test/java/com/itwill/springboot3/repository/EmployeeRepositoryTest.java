package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot3.domain.Employee;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {
	
	@Autowired
	private EmployeeRepository empRepo;
	
//	@Test
	public void testDependencyInjection() {
		assertThat(empRepo).isNotNull();
		log.info("empRepo = {}", empRepo);
	}
	
//	@Test
	public void testCount() {
		// select count(*) from employees
		long count = empRepo.count();
		assertThat(count).isEqualTo(107);
	}

//	@Test
	public void testFindAll() {
		List<Employee> list = empRepo.findAll();
		assertThat(list.size()).isEqualTo(107);
		
		log.info("index 0 : {}", list.get(0));
	}
	
	@Test
	@Transactional
	public void testFindById() {
		Employee emp = empRepo.findById(101).orElseThrow();
		assertThat(emp.getFirstName()).isEqualTo("Neena");
		
		log.info("emp = {}", emp);
		log.info("emp.job = {}", emp.getJob());
		log.info("emp.manager = {}", emp.getManager());
		log.info("emp.department = {}", emp.getDepartment());
		log.info("emp.department.manager = {}", emp.getDepartment().getManager());
	}
	
}
