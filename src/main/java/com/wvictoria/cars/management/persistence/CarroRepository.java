package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.persistence.crud.CarroCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Carro;
import com.wvictoria.cars.management.persistence.entity.Empleado;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarroRepository {
    private CarroCrudRepository carroCrudRepository;

    public List<Carro> getAll() {
        return (List<Carro>) carroCrudRepository.findAll();
    }

    public Optional<Carro> getCarro(int idCarro) {
        return  carroCrudRepository.findById(idCarro);
    }

    public Carro save(Carro carro) {
        return carroCrudRepository.save(carro);
    }

    public void delete(int idCarro) {
        carroCrudRepository.deleteById(idCarro);
    }

}