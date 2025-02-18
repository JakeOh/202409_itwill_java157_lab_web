package com.itwill.springboot2.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Test
	public void test() {
		Assertions.assertThat(empRepo).isNotNull();
		log.info("empRepo = {}", empRepo);
	}
	
}
