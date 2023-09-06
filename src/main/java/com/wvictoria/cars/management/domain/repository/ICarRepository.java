package com.wvictoria.cars.management.domain.repository;

import com.wvictoria.cars.management.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {
    List<CarDto> getAllCars();
    Optional<CarDto> getCarById(int carId);
    CarDto createCar(CarDto car);
    void deleteCar(int carId);
}