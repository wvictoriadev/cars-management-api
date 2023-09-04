package com.wvictoria.cars.management.persistence.crud;

import com.wvictoria.cars.management.persistence.entity.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoCrudRepository extends CrudRepository<Empleado, Integer> {
}
