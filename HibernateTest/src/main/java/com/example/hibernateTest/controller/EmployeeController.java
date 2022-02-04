package com.example.hibernateTest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernateTest.entity.Employee;
import com.example.hibernateTest.serviceImpl.EmployeeService;
//@Controller
@RestController
public class EmployeeController {
	/*
	 * If annotation only Controller being used then these annotation are going to used
		@RequestMapping(value="/Employees", method = RequestMethod.GET)
		@ResponseBody*/
	@Autowired
	private EmployeeService emps;
	
	/*Get all the data handler*/
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployee()
	{
		List<Employee> e=emps.getEmployee();
		if(e.size()<=0){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(e);
		
	}
	
	/*get single data using id handler*/
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") int id)
	{
		Employee e=emps.getEmployeeById(id);
		if(e==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(e)); 
		
	}
	
	/*Adding data handler*/
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
	{
		Employee e= null;
		try
		{
			e=this.emps.addEmployee(emp);
			System.out.println(emp);
			return ResponseEntity.of(Optional.of(e));
			
		}catch(Exception ec)
		{
			System.out.println(ec);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*Delete data using id handler*/
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Object> deleteEmpById(@PathVariable("id") int id)
	{
		try
		{
			emps.deleteEmpById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	/*Update data using id handler*/
	@PutMapping("/employee/{id}")
	public ResponseEntity<List<Employee>> updateById(@RequestBody Employee emp,@PathVariable("id") int id)
	{
		List<Employee> l=null;
		try
		{
			l=emps.updateById(emp,id);
			return ResponseEntity.of(Optional.of(l));
		}
		catch(Exception e)
		{
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
