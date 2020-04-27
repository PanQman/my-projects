package com.SpringBootCRUD.cruddemo.DAO;

import com.SpringBootCRUD.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    //I have acces to CRUD operations!!

}
