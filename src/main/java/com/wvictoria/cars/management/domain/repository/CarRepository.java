package com.wvictoria.cars.management.domain.repository;

import com.wvictoria.cars.management.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<CarDto> getAll();
    Optional<CarDto> getCar(int carId);
    CarDto save(CarDto car);
    void delete(int carId);
}