package com.luv2code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stupid")
public class SillyControler {

    @RequestMapping("/showForm")
    public String displayTheForm(){
        return "silly";
    }
}
