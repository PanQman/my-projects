package com.springrest.rest;

import com.springrest.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRESTController {

    private ArrayList<Student> studentList;

    @PostConstruct
    public void loadData(){
        studentList = new ArrayList<>();
        studentList.add(new Student("Adam", "Paz"));
        studentList.add(new Student("Kamil", "Wysocki"));
        studentList.add(new Student("Konrad", "Mackowiak"));
    }


    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if ( (studentId >= studentList.size() || studentId < 0) ){
            throw new StudentNotFoundException("Student id is not found " + studentId);
        } else
            return studentList.get(studentId);
    }



}
