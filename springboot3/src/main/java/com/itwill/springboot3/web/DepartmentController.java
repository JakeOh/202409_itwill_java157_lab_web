package com.itwill.springboot3.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.service.DepartmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/dept")
public class DepartmentController {

	private final DepartmentService deptService;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list()");
		
		List<Department> list = deptService.read();
		model.addAttribute("departments", list);
	}
	
}
