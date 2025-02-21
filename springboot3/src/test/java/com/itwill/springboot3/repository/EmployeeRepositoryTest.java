package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
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
	
//	@Test
	@Transactional
	public void testFindById() {
		Employee emp = empRepo.findById(101).orElseThrow();
		assertThat(emp.getFirstName()).isEqualTo("Neena");
		
		log.info("emp = {}", emp);
		log.info("emp.job = {}", emp.getJob());
		log.info("emp.manager = {}", emp.getManager());
		log.info("emp.department = {}", emp.getDepartment());
		log.info("emp.department.manager = {}", emp.getDepartment().getManager());
		log.info("emp.department.location = {}", emp.getDepartment().getLocation());
		log.info("emp.department.location.country = {}",
				emp.getDepartment().getLocation().getCountry());
		log.info("emp.department.location.country.region = {}",
				emp.getDepartment().getLocation().getCountry().getRegion());
	}
	
	@Test
	@Transactional
	public void testJpaQueryMethods() {
		List<Employee> list;
		
		// JPA Query Methods 테스트
//		list = empRepo.findByDepartmentId(100);
//		list = empRepo.findByFirstName("David");
//		list = empRepo.findByFirstNameIgnoreCase("david");
//		list = empRepo.findByFirstNameContaining("da");
//		list = empRepo.findByFirstNameLike("%da%");
//		list = empRepo.findByFirstNameContainingIgnoreCase("da");
//		list = empRepo.findByFirstNameContainingIgnoreCaseOrderByFirstNameDesc("da");
//		list = empRepo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase("da", "ad");
//		list = empRepo.findBySalaryGreaterThan(10_000);
//		list = empRepo.findBySalaryLessThan(5_000);
//		list = empRepo.findBySalaryBetween(2_000, 3_000);
//		list = empRepo.findByHireDateLessThan(LocalDate.of(2003, 1, 1));
//		list = empRepo.findByHireDateGreaterThan(LocalDate.of(2007, 1, 1));
//		list = empRepo.findByHireDateBetween(
//				LocalDate.of(2007, 1, 1), 
//				LocalDate.of(2007, 12, 31));
//		list = empRepo.findByDepartmentDepartmentName("Sales");
//		list = empRepo.findByDepartmentLocationCity("Seattle");
//		list = empRepo.findByDepartmentLocationCountryId("CA");
		
		// JPQL 테스트
//		list = empRepo.findByName("da", "ad");
//		list = empRepo.findByName("da");
//		list = empRepo.findByDeptName("IT");
//		list = empRepo.findByCity("Seattle");
		list = empRepo.findByCountry("Canada");
		
		list.forEach(System.out::println);
	}
	
}
