package com.wvictoria.cars.management.domain.service;

import com.wvictoria.cars.management.domain.dto.CarDto;
import com.wvictoria.cars.management.domain.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<CarDto> getAll() {
        return carRepository.getAll();
    }

    public Optional<CarDto> getCar(int carId) {
        return carRepository.getCar(carId);
    }

    public CarDto save(CarDto car) {
        return carRepository.save(car);
    }

    public boolean delete(int carId) {
        return getCar(carId).map(car -> {
            carRepository.delete(carId);
            return true;
        }).orElse(false);
    }
}