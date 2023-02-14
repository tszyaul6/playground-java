package com.example.playground.dao;

import com.example.playground.model.Employee;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class EmployeeDao
{
	private final SessionFactory sessionFactory;

	public void save(Employee employee)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	public List<Employee> findAll()
	{
		String query = "SELECT * FROM employee";
		return sessionFactory.getCurrentSession().createNativeQuery(query, Employee.class).getResultList();
	}

}
