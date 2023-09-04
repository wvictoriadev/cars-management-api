package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.persistence.crud.CarroCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Carro;

import java.util.List;

public class CarroRepository {
    private CarroCrudRepository carroCrudRepository;

    public List<Carro> getAll() {
        return (List<Carro>) carroCrudRepository.findAll();
    }
}