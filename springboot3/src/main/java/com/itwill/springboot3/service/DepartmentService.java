package com.itwill.springboot3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartmentService {

	private final DepartmentRepository deptRepo;
	
	public List<Department> read() {
		log.info("read()");
		
		List<Department> list = deptRepo.findAll();
		
		return list;
	}
	
}
