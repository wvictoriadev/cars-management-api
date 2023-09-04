package com.wvictoria.cars.management.domain.repository;

import com.wvictoria.cars.management.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<Car> getAll();
    Optional<Car> getCar(int carId);
    Car save(Car car);
    void delete(int carId);
}