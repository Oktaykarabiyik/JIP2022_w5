package com.example.jip2022_w5.controllers;


import com.example.jip2022_w5.dto.UserDTO;
import com.example.jip2022_w5.entities.Authorities;
import com.example.jip2022_w5.entities.User;
import com.example.jip2022_w5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/userLogin", "/"}, method = RequestMethod.GET)
    public String showLoginPage() {
        return "userLogin";
    }


    @RequestMapping(value = "/userList", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody List<UserDTO> getUserList() {
        List<User> userList = userService.getAllUsers();
        List<UserDTO> userDTOList = new ArrayList<>();

        for(User user:userList) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            userDTO.setBirthday(user.getBirthday());
            userDTO.setSexsmall(user.getSexsmall());
            userDTOList.add(userDTO);
        }
        return userDTOList ;
    }

    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public String showlistUserPage() {
        return "listUser";
    }


    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password) {

        User loggedInUser = userService.getUser(username, password);
        Authorities isAuthorities = userService.getAuthoritiesUsername(username);

        if (loggedInUser == null) {
            model.put("errorMessage", "Invalid Credentials");
            return "userLogin";
        }

        model.put("username", username);
        model.put("password", password);

        if (isAuthorities != null) {
            return "Home";
        }
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
        User usernameControl = userService.getUsername(username);
        if (usernameControl != null) {
            model.put("errorMessage", "Username Exist!");
            return "Registration";
        }
        user.setEmail(email);
        User emailControl = userService.getEmail(email);
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
