package com.wvictoria.cars.management.domain.repository;

import com.wvictoria.cars.management.domain.dto.TripDto;

import java.util.List;
import java.util.Optional;

public interface TripRepository {
    List<TripDto> getAll();
    Optional<TripDto> getTrip(int tripId);
    TripDto save(TripDto trip);
    void delete(int tripId);
    void updateEndDateTrip(int tripId, String endDate);
    void updateDeliverDateTrip(int tripId, String deliverDate);
}
