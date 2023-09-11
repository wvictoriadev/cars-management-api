package com.wvictoria.cars.management.domain.service;

import com.wvictoria.cars.management.domain.dto.TripDto;
import com.wvictoria.cars.management.domain.repository.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    private ITripRepository tripRepository;

    public List<TripDto> getAll() {
        return tripRepository.getAllTrips();
    }

    public Optional<TripDto> getTrip(int tripId) {
        return tripRepository.getTripById(tripId);
    }

    public TripDto save(TripDto trip) {
        return tripRepository.createTrip(trip);
    }

    public boolean delete(int tripId) {
        return getTrip(tripId).map(trip -> {
            tripRepository.deleteTrip(tripId);
            return true;
        }).orElse(false);
    }


}
