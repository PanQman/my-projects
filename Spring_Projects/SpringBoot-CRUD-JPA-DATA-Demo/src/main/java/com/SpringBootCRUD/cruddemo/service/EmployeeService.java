package com.SpringBootCRUD.cruddemo.service;

import com.SpringBootCRUD.cruddemo.DAO.IEmployeeRepository;
import com.SpringBootCRUD.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository iEmployeeRepository){
        this.iEmployeeRepository = iEmployeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = iEmployeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()){
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employee;
    }


    @Override
    public void saveEmployee(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        iEmployeeRepository.deleteById(id);
    }
}
