package com.SpringBootCRUD.cruddemo.DAO;

import com.SpringBootCRUD.cruddemo.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);

}
