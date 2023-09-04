package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.domain.Trip;
import com.wvictoria.cars.management.domain.repository.TripRepository;
import com.wvictoria.cars.management.persistence.crud.ViajeCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Viaje;
import com.wvictoria.cars.management.persistence.mapper.TripMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ViajeRepository implements TripRepository {
    @Autowired
    private ViajeCrudRepository viajeCrudRepository;
    @Autowired
    private TripMapper tripMapper;
    public List<Trip> getAll() {
        List<Viaje> viajes = (List<Viaje>) viajeCrudRepository.findAll();
        return tripMapper.toTrips(viajes);
    }

    @Override
    public Optional<Trip> getTrip(int tripId) {
        return viajeCrudRepository.findById(tripId).map(viaje -> tripMapper.toTrip((viaje)));
    }

    @Override
    public Trip save(Trip trip) {
        Viaje viaje = tripMapper.toViaje(trip);
        return tripMapper.toTrip(viajeCrudRepository.save(viaje));
    }

    @Override
    public void delete(int tripId) {
        viajeCrudRepository.deleteById(tripId);
    }
}