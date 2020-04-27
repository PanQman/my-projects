package com.luv2code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HelloController {

    @RequestMapping("/home")
    public String homeTest(){
        return "home-page";
    }





}
