package org.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String showAccesDenied(){
        return "acces-denied";
    }

}
