package com.example.CRUD.Fullstack.repositories;

import com.example.CRUD.Fullstack.models.Car;
import com.example.CRUD.Fullstack.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
