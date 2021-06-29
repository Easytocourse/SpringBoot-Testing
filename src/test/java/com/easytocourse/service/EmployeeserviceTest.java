package com.easytocourse.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.easytocourse.dao.EmployeeRepository;
import com.easytocourse.exception.Employeenotfound;
import com.easytocourse.model.Employee;

class EmployeeserviceTest {
	
	
	@InjectMocks
	Employeeservice empservice;
	
	@Mock
	EmployeeRepository emprepo;

	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveemp() {
		
		Employee reqemp=new Employee("bharath","java");
		Employee resemp=new Employee(1,"bharath","java");
		
		when(emprepo.save(reqemp)).thenReturn(resemp);
		assertEquals(resemp, empservice.saveemp(reqemp));
	}

	@Test
	void testGetempbyid() throws Exception {
		Employee resemp=new Employee(1,"bharath","java");
		
		Optional<Employee> emp=Optional.ofNullable(resemp);
		
		when(emprepo.findById(anyInt())).thenReturn(emp);
		
		assertEquals(resemp,empservice.getempbyid(anyInt()));
		
	}
	
	@Test
	void testempbyidfornull()
	{
		when(emprepo.findById(anyInt())).thenThrow(Employeenotfound.class);
		
		assertThrows(Employeenotfound.class, ()->{
			empservice.getempbyid(anyInt());
			
		});
	}

}
