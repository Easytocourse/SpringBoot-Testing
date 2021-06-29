package com.easytocourse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Employee {
    
	@Id
	@GeneratedValue
	private int id;
	
	
	@NotBlank(message="Name should not null or empty")
	private String name;
	
	@NotBlank(message="Tech should not null or empty")
    private String tech;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public Employee()
	{
		
	}
	public Employee(String name, String tech) {
		super();
		this.name = name;
		this.tech = tech;
	}
	public Employee(int i, String name, String tech) {
		this(name,tech);
		this.id=i;
		
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", tech=" + tech + "]";
	}
}