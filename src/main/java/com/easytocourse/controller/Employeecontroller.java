package com.easytocourse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytocourse.model.Employee;
import com.easytocourse.service.Employeeservice;

@RestController
@RequestMapping("/Employee")
public class Employeecontroller {

	
	@Autowired
	Employeeservice empservice;

	@Value("${spring.message}")
	private String msg;
	
	@Value("${spring.welcome}")
	private String welcome;
	
	@RequestMapping("/")
	public String greeting() {
		return welcome+" "+msg;
	}
	
	@PostMapping("/addEmployee") // adding emp details into the table
	public Employee addemployee(@Valid @RequestBody Employee emp) {
		empservice.saveemp(emp);
		return emp;
	}

	@GetMapping("/getEmployees") // get the all rows form the table
	public List<Employee> getall() {
		return empservice.getallemloyees();
	}

	@GetMapping("/getEmployee/{id}") // get emp by id
	public Employee empbyid(@PathVariable int id) throws Exception {
		
		
		return empservice.getempbyid(id);
	}

	public String test() {
		// TODO Auto-generated method stub
		return empservice.test();
	}

}
