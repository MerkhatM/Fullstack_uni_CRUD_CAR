package com.example.CRUD.Fullstack.repositories;

import com.example.CRUD.Fullstack.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c "
            + "where c.mark ilike  concat('%',:search,'%') "
            + "or c.model ilike concat('%',:search,'%') "
            + "or cast(c.year as string ) = :search ")
    List<Car> search(String search);

    List<Car> findByYearBetween(int startYear, int endYear);
}
