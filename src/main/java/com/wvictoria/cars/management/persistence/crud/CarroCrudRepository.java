package com.wvictoria.cars.management.persistence.crud;

import com.wvictoria.cars.management.persistence.entity.Carro;
import org.springframework.data.repository.CrudRepository;

public interface CarroCrudRepository extends CrudRepository<Carro, Integer> {}
