package com.wvictoria.cars.management.web.controller;

import com.wvictoria.cars.management.domain.dto.Car;
import com.wvictoria.cars.management.domain.service.AuthService;
import com.wvictoria.cars.management.domain.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    @Autowired
    private CarService carService;

    private AuthService authService;

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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int carId) {
        if (carService.delete(carId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}