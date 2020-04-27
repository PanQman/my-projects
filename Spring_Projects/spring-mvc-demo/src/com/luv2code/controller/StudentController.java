package com.luv2code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model){
        Student student = new Student();
        model.addAttribute("theStudent", student);
        return "student-form";
    }

    @RequestMapping("/zapiszStudenta")
    public String processForm(@ModelAttribute("theStudent") Student student){
        System.out.println(student.getFirstName() + " " + student.getLastName());
        return "student-confirmation";
    }




}
