package com.example.eurekaclient.repositories;

import com.example.eurekaclient.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c "
            + "where (c.mark ilike  concat('%',:search,'%') "
            + "or c.model ilike concat('%',:search,'%') "
            + "or cast(c.year as string ) = :search) "
            + "and (c.year between :startYear and :endYear)")
    List<Car> search(String search, int startYear, int endYear);


}
