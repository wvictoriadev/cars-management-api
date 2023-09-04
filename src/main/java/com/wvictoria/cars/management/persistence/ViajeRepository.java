package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.persistence.crud.ViajeCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Viaje;

import java.util.List;

public class ViajeRepository {
    private ViajeCrudRepository viajeCrudRepository;

    public List<Viaje> getAll() {
        return (List<Viaje>) viajeCrudRepository.findAll();
    }
}