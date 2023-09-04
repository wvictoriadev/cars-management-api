package com.wvictoria.cars.management.domain.repository;

import com.wvictoria.cars.management.domain.Trip;

import java.util.List;
import java.util.Optional;

public interface TripRepository {
    List<Trip> getAll();
    Optional<List<Trip>> getByEmployee(int employeeId);
    Optional<List<Trip>> getByCar(int carId);
    Optional<Trip> getTrip(int tripId);
    Trip save(Trip trip);
    void delete(int tripId);
}
