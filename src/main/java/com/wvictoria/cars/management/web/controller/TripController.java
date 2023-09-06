package com.wvictoria.cars.management.web.controller;

import com.wvictoria.cars.management.domain.dto.Trip;
import com.wvictoria.cars.management.domain.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping("/all")
    public List<Trip> getAll() {
        return tripService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Trip> getTrip(@PathVariable("id") int tripId) {
        return tripService.getTrip(tripId);
    }

    @PostMapping("/save")
    public Trip save(@RequestBody Trip trip) {
        return tripService.save(trip);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int tripId) {
        if (tripService.delete(tripId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}