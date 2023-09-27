package com.example.CRUD.Fullstack.services;

import com.example.CRUD.Fullstack.models.Car;
import com.example.CRUD.Fullstack.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll().stream().sorted(Comparator.comparing(Car::getId)).toList();
    }

    public Car getCar(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public void editCar(Car newCar,Long id) {
        Car car=carRepository.findById(id).orElse(null);
        car.setId(newCar.getId());
        car.setMark(newCar.getMark());
        car.setModel(newCar.getModel());
        car.setYear(newCar.getYear());
        car.setColor(newCar.getColor());
        car.setRegistrationKz(newCar.isRegistrationKz());
        carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public List<Car> getRegisteredCars() {
        return carRepository.findAll().stream().filter(car -> car.isRegistrationKz()).toList();
    }

    public List<Car> getUnRegisteredCars() {
        return carRepository.findAll().stream().filter(car -> !car.isRegistrationKz()).toList();
    }
}
