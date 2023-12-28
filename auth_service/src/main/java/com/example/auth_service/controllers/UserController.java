package com.example.auth_service.controllers;

import com.example.auth_service.dto.UserCreate;
import com.example.auth_service.dto.UserUpdate;
import com.example.auth_service.dto.UserView;
import com.example.auth_service.models.User;
import com.example.auth_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http:://localhost:3000")
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("{id}")
    public UserView getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PostMapping(value = "/addUser")
    public UserView saveUser(@RequestBody UserCreate userCreate){
        return userService.addUser(userCreate);
    }
    @PutMapping(value = "/editUser")
    public User editUser(@RequestBody UserUpdate userUpdate){
        return userService.editUser(userUpdate);
    }

    @DeleteMapping(value = "/deleteUser")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
