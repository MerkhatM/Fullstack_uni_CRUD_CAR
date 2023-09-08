package com.example.CRUD.Fullstack.controllers;

import com.example.CRUD.Fullstack.models.Car;
import com.example.CRUD.Fullstack.repositories.CarRepository;
import com.example.CRUD.Fullstack.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping(value = "/registeredInKz")
    public List<Car> getRegisteredCars() {
        return carService.getRegisteredCars();
    }

    @GetMapping(value = "/unRegisteredInKz")
    public List<Car> getNoRegisteredCars() {
        return carService.getUnRegisteredCars();
    }

    @GetMapping(value = "/search")
    public List<Car> searchCars(@RequestParam(name = "search", required = false, defaultValue = "") String search) {
        return carRepository.search(search);
    }

    @GetMapping(value = "/rangeYear")
    public List<Car> findByRangeYear(@RequestParam(name = "startYear", required = false, defaultValue = "") String startYear,
                                     @RequestParam(name = "endYear", required = false, defaultValue = "") String endYear) {
        return carRepository.findByYearBetween(Integer.parseInt(startYear), Integer.parseInt(endYear));
    }

    @GetMapping("{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getCar(id);
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @PutMapping
    public void editCar(@RequestBody Car car) {
        carService.editCar(car);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

}
