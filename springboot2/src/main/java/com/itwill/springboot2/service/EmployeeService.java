package com.itwill.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot2.domain.Employee;
import com.itwill.springboot2.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {

	// 생성자와 final 필드를 사용한 의존성 주입
	private final EmployeeRepository empRepo;
	
	public List<Employee> read() {
		log.info("read()");
		
		// 영속성(persistence) 계층의 메서드를 호출해서 필요한 SQL을 실행.
		List<Employee> employees = empRepo.findAll();
		log.info("직원 수 = {}", employees.size());
		
		// 결과를 컨트롤러에게 리턴.
		return employees;
	}
	
}
