package com.wvictoria.cars.management.web.controller;

import com.wvictoria.cars.management.domain.Car;
import com.wvictoria.cars.management.domain.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable("id") int carId) {
        return carService.getCar(carId);
    }

    @PostMapping("/save")
    public Car save(@RequestBody Car car) {
        return carService.save(car);
    }
}