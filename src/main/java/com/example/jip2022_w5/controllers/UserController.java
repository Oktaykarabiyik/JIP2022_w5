package com.example.jip2022_w5.controllers;


import com.example.jip2022_w5.entities.User;
import com.example.jip2022_w5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/userLogin", "/"}, method = RequestMethod.GET)
    public String showLoginPage() {
        return "userLogin";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

        User loggedInUser = userService.getFindUser(name, password);

        if (loggedInUser == null) {
            model.put("errorMessage", "Invalid Credentials");
            return "userLogin";
        }

        model.put("name", name);
        model.put("password", password);

        return "welcome";
    }

    @RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
    public String showRegistrationPage() {
        return "Registration";

    }

    @RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
    public String userRegistration(ModelMap model, @RequestParam String username, @RequestParam String email,
                                   @RequestParam Date birthday, @RequestParam String sexsmall, @RequestParam String password,
                                   @RequestParam String confirmpassword) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        User usernameControl = userService.getFindUsername(username);
        User emailControl = userService.getFindEmail(email);
        if (usernameControl != null) {
            model.put("errorMessage", "Username Exist!");
            return "Registration";
        }
        if (emailControl != null) {
            model.put("errorMessage", "Email Exist!");
            return "Registration";
        }

        user.setBirthday(birthday);
        user.setSexsmall(Integer.valueOf(sexsmall));
        user.setPassword(password);
        user.setEnabled(false);
        userService.createUser(user);

        return "userLogin";


    }



   /* @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {

        return userService.getOneUser(userId);

    }*/


}
