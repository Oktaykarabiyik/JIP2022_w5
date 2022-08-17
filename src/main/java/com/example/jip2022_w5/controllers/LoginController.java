package com.example.jip2022_w5.controllers;

import com.example.jip2022_w5.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
public class LoginController {

    @Autowired
    LoginService service;


    @RequestMapping(value={"/userLogin","/"}, method = RequestMethod.GET)
    public String showLoginPage(){
        return "userLogin";
    }

    @RequestMapping(value="/userLogin", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

        boolean isValidUser = service.validateUser(name, password);

        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "userLogin";
        }

        model.put("name", name);
        model.put("password", password);

        return "welcome";
    }

}
