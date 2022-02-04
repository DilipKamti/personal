package com.example.hibernateTest;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.example.hibernateTest.entity.Employee;
import com.example.hibernateTest.repository.EmployeeRepo;

@SpringBootApplication
public class HibernateTestApplication {

	public static void main(String[] args) {
	ApplicationContext context=SpringApplication.run(HibernateTestApplication.class, args);
		System.out.println("Hello World");
	EmployeeRepo repo=context.getBean(EmployeeRepo.class);
	
	//----------INSERT entity in table----------------
	
	
	/*Employee e=new Employee();
	e.setFirstName("Dilip");
	e.setLastName("Kamti");
	e.setEmail("dilipkamti@gmail.com");
	Employee e1= repo.save(e);
	System.out.println(e1);
	System.out.println("saved");*/
	
	//-------------------------------------------
	/*Employee e1=new Employee();
	e1.setFirstName("Dilip");
	e1.setLastName("Kamti");
	e1.setEmail("dilipkamti@gmail.com");
	
	Employee e2=new Employee();
	e2.setFirstName("Usha");
	e2.setLastName("Kamti");
	e2.setEmail("ushakamti@gmail.com");
	
	
	/* To save a Single entity
	 * Employee result=repo.save(e1);
	System.out.println(result.toString());*/
	
	/* To save multiple entities
	 * List<Employee> e=List.of(e1,e2);
	Iterable<Employee> saveall= repo.saveAll(e);
	
	saveall.forEach(user->{
		System.out.println(user);
	});
	System.out.println("Done");
	*/
	
	
	
	//------------------UPDATE the entity using id--------------------
	
	/*Optional<Employee> optional= repo.findById(4);
	Employee e=optional.get();
	e.setFirstName("Shiv Charan");
	repo.save(e);
	System.out.println(e);*/
	
	
	
	//------------------------- how to get DATA-------------------------
	/* 1.Using findById()*/
	/*2.
	 * Iterable<Employee> itr=repo.findAll();
	Iterator<Employee> iterator=itr.iterator();
	while(iterator.hasNext())
	{
		Employee e=iterator.next();
		System.out.println(e);
	}*/
	
	/*3.
	 * itr.forEach(user->System.out.println(user););
	 * */
	
	
	
	//-----------------Delete the entity -----------------------
		/*deleted by using id
		 * repo.deleteById(3);
		 * */
	/*Iterable<Employee> e=repo.findAll();
	e.forEach(emp->System.out.println(emp));
	repo.deleteAll();*/
	
	
	}

}
