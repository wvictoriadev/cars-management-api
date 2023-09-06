package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.domain.dto.CarDto;
import com.wvictoria.cars.management.domain.repository.ICarRepository;
import com.wvictoria.cars.management.persistence.crud.CarroCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Carro;
import com.wvictoria.cars.management.persistence.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarroRepository implements ICarRepository {
    @Autowired
    private CarroCrudRepository carroCrudRepository;
    @Autowired
    private CarMapper carMapper;

    public List<CarDto> getAllCars() {
        List<Carro> carros = (List<Carro>) carroCrudRepository.findAll();
        return carMapper.toCars(carros);
    }

    @Override
    public Optional<CarDto> getCarById(int carId) {
        return carroCrudRepository.findById(carId).map(carro -> carMapper.toCar(carro));
    }

    @Override
    public CarDto createCar(CarDto car) {
        Carro carro = carMapper.toCarro(car);
        return carMapper.toCar(carroCrudRepository.save(carro));
    }

    @Override
    public void deleteCar(int carroId) {
        carroCrudRepository.deleteById(carroId);
    }
}