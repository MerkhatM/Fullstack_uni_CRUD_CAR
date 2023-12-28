package com.example.eurekaclient.controllers;

import com.example.eurekaclient.models.Car;
import com.example.eurekaclient.repositories.CarRepository;
import com.example.eurekaclient.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http:://localhost:3000")
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
    public List<Car> searchCars(@RequestParam(name = "search", required = false, defaultValue = "") String search,
                                @RequestParam(name = "startYear", required = false, defaultValue = "1965") String startYear,
                                @RequestParam(name = "endYear", required = false, defaultValue = "2023") String endYear) {
        return carRepository.search(search, Integer.parseInt(startYear), Integer.parseInt(endYear));
    }


    @GetMapping("{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getCar(id);
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @PutMapping("{id}")
    public void editCar(@RequestBody Car car,@PathVariable Long id) {
        carService.editCar(car,id);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

}
