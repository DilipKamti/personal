package com.example.hibernateTest.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernateTest.entity.Employee;
import com.example.hibernateTest.repository.EmployeeRepo;
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
	/*private static List<Employee> list=new ArrayList<>();
	static {
		list.add(new Employee(1,"Dk","k","dkk@gmail.com"));
		list.add(new Employee(2,"u","k","uk@gmail.com"));
		list.add(new Employee(3,"sc","k","sck@gmail.com"));
		list.add(new Employee(4,"m","k","mk@gmail.com"));
	}*/
	/*Get all the employee*/
	public List<Employee> getEmployee()
	{
		//return list;
		List<Employee> emp=(List<Employee>)this.repo.findAll();
		return emp;
	}
	
	/*get single employee using id*/
	public Employee getEmployeeById(int id)
	{
		Employee e=null;
		try
		{
			//e=list.stream().filter(b->b.getId()==id).findFirst().get();
			e=repo.findById(id);
		}
		catch(Exception ec)
		{
			System.out.println(ec);
		}
		
		return e;
	}
	
	public Employee addEmployee(Employee e)
	{
		Employee em=repo.save(e);
		//list.add(e);
		System.out.println("Employee added");
		return em;
	}
	public void deleteEmpById(int id)
	{
		//list=list.stream().filter(emp->emp.getId()!=id).collect(Collectors.toList());
		repo.deleteById(id);
		//return e;
	}


	public List<Employee> updateById(Employee e, int id) {
		
		/*list=list.stream().map(emp->{
			if(emp.getId()==id)
			{
				emp.setFirstName(e.getFirstName());
				emp.setLastName(e.getLastName());
				emp.setEmail(e.getEmail());
			}
			return emp;
		}).collect(Collectors.toList());
		return list;*/
		e.setId(id);
		List<Employee> em=(List<Employee>) repo.save(e);
		return em;
	}
}
