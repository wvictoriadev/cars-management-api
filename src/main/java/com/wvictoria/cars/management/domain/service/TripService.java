package com.wvictoria.cars.management.domain.service;

import com.wvictoria.cars.management.domain.dto.TripDto;
import com.wvictoria.cars.management.domain.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public List<TripDto> getAll() {
        return tripRepository.getAll();
    }

    public Optional<TripDto> getTrip(int tripId) {
        return tripRepository.getTrip(tripId);
    }

    public TripDto save(TripDto trip) {
        return tripRepository.save(trip);
    }

    public boolean delete(int tripId) {
        return getTrip(tripId).map(trip -> {
            tripRepository.delete(tripId);
            return true;
        }).orElse(false);
    }


}
