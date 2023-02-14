package com.example.playground.service;

import com.example.playground.dao.EmployeeDao;
import com.example.playground.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService
{
	private final EmployeeDao employeeDao;

	public void saveOrUpdate(Employee employee)
	{
		employeeDao.save(employee);
	}

	public List<Employee> findAll()
	{
		return employeeDao.findAll();
	}
}
