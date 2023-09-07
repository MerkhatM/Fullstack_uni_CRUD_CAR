package com.example.CRUD.Fullstack.controllers;

import com.example.CRUD.Fullstack.models.Car;
import com.example.CRUD.Fullstack.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("{id}")
    public Car getCar(@PathVariable Long id){
        return carService.getCar(id);
    }

    @PostMapping
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }

    @PutMapping
    public void editCar(@RequestBody Car car){
        carService.editCar(car);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }

}
