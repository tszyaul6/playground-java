package com.example.playground.controller;

import com.example.playground.model.Employee;
import com.example.playground.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class EmployeeController
{
	private final EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}
	
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
	}
}
