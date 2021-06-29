package com.easytocourse.dao;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easytocourse.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
   
}
