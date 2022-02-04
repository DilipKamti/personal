package com.example.hibernateTest.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.hibernateTest.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	public Employee findById(int id);
}
