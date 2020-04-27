package com.luv2code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String proccesForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersion2")
    public String capsLock(HttpServletRequest request, Model model){

        String theName = request.getParameter("yourName");
        theName = theName.toUpperCase();

        String result = "Yo! " + theName;

        model.addAttribute("messageForMe", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersion3")
    public String capsLockV2(@RequestParam("yourName") String theName, Model model){

        theName = theName.toUpperCase();

        String result = "Hey! " + theName;

        model.addAttribute("messageForMe", result);

        return "helloworld";
    }

}
