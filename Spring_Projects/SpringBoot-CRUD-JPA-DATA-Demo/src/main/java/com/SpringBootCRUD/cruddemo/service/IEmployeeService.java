package com.SpringBootCRUD.cruddemo.service;

import com.SpringBootCRUD.cruddemo.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);

}
