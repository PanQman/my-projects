package com.SpringBootCRUD.cruddemo.DAO;


import com.SpringBootCRUD.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

@Repository
public class EmployeeDAO implements IEmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null) {
            throw new RuntimeException("No employee");
        } else
            return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        dbEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee where id =: id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
