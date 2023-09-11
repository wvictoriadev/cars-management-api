package com.wvictoria.cars.management.domain.repository;

import com.wvictoria.cars.management.domain.dto.TripDto;

import java.util.List;
import java.util.Optional;

public interface ITripRepository {
    List<TripDto> getAllTrips();
    Optional<TripDto> getTripById(int tripId);
    TripDto createTrip(TripDto trip);
    void deleteTrip(int tripId);
    void updateEndDateTrip(int tripId, String endDate);
    void updateDeliverDateTrip(int tripId, String deliverDate);
}
