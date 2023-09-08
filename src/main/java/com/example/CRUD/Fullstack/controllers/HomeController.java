package com.example.CRUD.Fullstack.controllers;

import com.example.CRUD.Fullstack.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }


}
