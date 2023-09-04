package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.persistence.crud.ViajeCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Viaje;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ViajeRepository {
    private ViajeCrudRepository viajeCrudRepository;

    public List<Viaje> getAll() {
        return (List<Viaje>) viajeCrudRepository.findAll();
    }
}