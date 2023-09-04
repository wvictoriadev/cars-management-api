package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.persistence.crud.EmpleadoCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Empleado;

import java.util.List;

public class EmpleadoRepository {
    private EmpleadoCrudRepository empleadoCrudRepository;

    public List<Empleado> getAll() {
        return (List<Empleado>) empleadoCrudRepository.findAll();
    }
}
