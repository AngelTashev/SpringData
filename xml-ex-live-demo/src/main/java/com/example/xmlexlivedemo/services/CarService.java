package com.example.xmlexlivedemo.services;

import com.example.xmlexlivedemo.models.dtos.CarSeedDto;
import com.example.xmlexlivedemo.models.entities.Car;

import java.util.List;

public interface CarService {
    void seedCars(List<CarSeedDto> carSeedDtos);

    Car getRandomCar();
}
