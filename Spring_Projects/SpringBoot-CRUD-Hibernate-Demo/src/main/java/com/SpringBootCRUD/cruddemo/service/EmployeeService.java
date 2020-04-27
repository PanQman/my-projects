package com.SpringBootCRUD.cruddemo.service;

import com.SpringBootCRUD.cruddemo.DAO.IEmployeeDAO;
import com.SpringBootCRUD.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    private IEmployeeDAO iEmployeeDAO;

    @Autowired
    public EmployeeService(IEmployeeDAO iEmployeeDAO){
        this.iEmployeeDAO = iEmployeeDAO;
    }


    @Override
    @Transactional
    public List<Employee> findAll() {
        return iEmployeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return iEmployeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        iEmployeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        iEmployeeDAO.deleteEmployee(id);
    }
}
