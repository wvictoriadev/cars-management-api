package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.domain.dto.TripDto;
import com.wvictoria.cars.management.domain.repository.ITripRepository;
import com.wvictoria.cars.management.persistence.crud.ViajeCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Viaje;
import com.wvictoria.cars.management.persistence.mapper.ITripMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ViajeRepository implements ITripRepository {
    @Autowired
    private ViajeCrudRepository viajeCrudRepository;
    @Autowired
    private ITripMapper tripMapper;
    public List<TripDto> getAllTrips() {
        List<Viaje> viajes = (List<Viaje>) viajeCrudRepository.findAll();
        return tripMapper.toTrips(viajes);
    }

    @Override
    public Optional<TripDto> getTripById(int tripId) {
        return viajeCrudRepository.findById(tripId).map(viaje -> tripMapper.toTrip((viaje)));
    }

    @Override
    public TripDto createTrip(TripDto trip) {
        Viaje viaje = tripMapper.toViaje(trip);
        return tripMapper.toTrip(viajeCrudRepository.save(viaje));
    }

    @Override
    public void deleteTrip(int tripId) {
        viajeCrudRepository.deleteById(tripId);
    }

    @Override
    public void updateEndDateTrip(int tripId, String endDate) {

    }

    @Override
    public void updateDeliverDateTrip(int tripId, String deliverDate) {

    }
}