package com.SpringBootCRUD.cruddemo.rest;

import com.SpringBootCRUD.cruddemo.entity.Employee;
import com.SpringBootCRUD.cruddemo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private IEmployeeService iEmployeeService;

    @Autowired
    public EmployeeRestController(IEmployeeService iEmployeeService){
        this.iEmployeeService = iEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return iEmployeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = iEmployeeService.findById(employeeId);
        if (employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        } else
            return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        iEmployeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        iEmployeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = iEmployeeService.findById(employeeId);
        if (employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        } else {
            iEmployeeService.deleteEmployee(employeeId);
            return "Deleted employee id - " + employeeId;
        }
    }


}
