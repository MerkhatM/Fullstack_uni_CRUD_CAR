package com.example.CRUD.Fullstack.services;

import com.example.CRUD.Fullstack.models.Car;
import com.example.CRUD.Fullstack.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car getCar(Long id){
        return carRepository.findById(id).orElse(null);
    }

    public void addCar(Car car){
        carRepository.save(car);
    }

    public void editCar(Car car){
        carRepository.save(car);
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

    public List<Car> getRegisteredCars(){
        return carRepository.findAll().stream().filter(car -> car.isRegistrationKz()).toList();
    }

    public List<Car> getNonRegisteredCars(){
        return carRepository.findAll().stream().filter(car -> !car.isRegistrationKz()).toList();
    }
}
