package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.persistence.crud.CarroCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Carro;
import com.wvictoria.cars.management.persistence.entity.Empleado;

import java.util.List;
import java.util.Optional;

public class CarroRepository {
    private CarroCrudRepository carroCrudRepository;

    public List<Carro> getAll() {
        return (List<Carro>) carroCrudRepository.findAll();
    }

    public Optional<Carro> getCarro(int idCarro) {
        return  carroCrudRepository.findById(idCarro);
    }
}