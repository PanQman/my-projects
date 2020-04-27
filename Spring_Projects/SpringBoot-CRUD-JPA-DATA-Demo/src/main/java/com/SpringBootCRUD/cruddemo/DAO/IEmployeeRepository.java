package com.SpringBootCRUD.cruddemo.DAO;

import com.SpringBootCRUD.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    //I have acces to CRUD operations!!

}
