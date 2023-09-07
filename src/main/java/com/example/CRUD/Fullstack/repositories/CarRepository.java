package com.example.CRUD.Fullstack.repositories;

import com.example.CRUD.Fullstack.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

}
