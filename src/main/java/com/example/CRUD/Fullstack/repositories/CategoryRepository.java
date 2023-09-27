package com.example.CRUD.Fullstack.repositories;

import com.example.CRUD.Fullstack.models.Car;
import com.example.CRUD.Fullstack.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
