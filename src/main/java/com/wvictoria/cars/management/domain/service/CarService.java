package com.wvictoria.cars.management.domain.service;

import com.wvictoria.cars.management.domain.dto.CarDto;
import com.wvictoria.cars.management.domain.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private ICarRepository carRepository;

    public List<CarDto> getAll() {
        return carRepository.getAllCars();
    }

    public Optional<CarDto> getCar(int carId) {
        return carRepository.getCarById(carId);
    }

    public CarDto save(CarDto car) {
        return carRepository.createCar(car);
    }

    public boolean delete(int carId) {
        return getCar(carId).map(car -> {
            carRepository.deleteCar(carId);
            return true;
        }).orElse(false);
    }
}