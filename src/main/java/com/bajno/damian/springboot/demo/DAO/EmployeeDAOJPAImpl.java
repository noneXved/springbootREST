package com.bajno.damian.springboot.demo.DAO;

import com.bajno.damian.springboot.demo.entity.Employee;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class EmployeeDAOJPAImpl implements EmployeeDAO {

    private EntityManager entityManager;

    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Query theQuery = entityManager.createQuery("from Employee");

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);

        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
        Query query = entityManager.createQuery("delete  from Employee where id=:employeeId");
        query.setParameter("employeeId", theId);

        query.executeUpdate();
    }
}
