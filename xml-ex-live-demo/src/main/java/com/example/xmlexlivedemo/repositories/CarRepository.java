package com.example.xmlexlivedemo.repositories;

import com.example.xmlexlivedemo.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByMakeAndModelAndTravelledDistance(String name, String model, Integer distance);
}
