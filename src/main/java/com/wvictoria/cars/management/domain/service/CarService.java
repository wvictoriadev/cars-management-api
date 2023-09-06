package com.wvictoria.cars.management.domain.service;

import com.wvictoria.cars.management.domain.dto.Car;
import com.wvictoria.cars.management.domain.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.getAll();
    }

    public Optional<Car> getCar(int carId) {
        return carRepository.getCar(carId);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public boolean delete(int carId) {
        return getCar(carId).map(car -> {
            carRepository.delete(carId);
            return true;
        }).orElse(false);
    }
}