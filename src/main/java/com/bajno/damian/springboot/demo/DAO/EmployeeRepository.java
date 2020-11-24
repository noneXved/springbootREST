package com.bajno.damian.springboot.demo.DAO;

import com.bajno.damian.springboot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
