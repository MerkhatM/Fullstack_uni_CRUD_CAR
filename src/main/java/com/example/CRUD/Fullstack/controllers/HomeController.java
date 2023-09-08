package com.example.CRUD.Fullstack.controllers;

import com.example.CRUD.Fullstack.repositories.CarRepository;
import com.example.CRUD.Fullstack.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private CarRepository carRepository;
    @GetMapping("/")
    public String homePage(){
        return "home";
    }


}
