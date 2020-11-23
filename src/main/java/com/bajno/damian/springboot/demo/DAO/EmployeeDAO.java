package com.bajno.damian.springboot.demo.DAO;

import com.bajno.damian.springboot.demo.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
