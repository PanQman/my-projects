package com.luv2code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping
public class HelloController {

    @RequestMapping("/home")
    public String homeTest(){
        return "home-page";
    }

    @RequestMapping("processForm")
    public String proccesForm(){
        return "helloworld";
    }

    @RequestMapping("processFormVersion2")
    public String capsLock(HttpServletRequest request, Model model){

        String theName = request.getParameter("yourName");
        theName = theName.toUpperCase();

        String result = "Yo! " + theName;

        model.addAttribute("messageForMe", result);

        return "helloworld";
    }



}
