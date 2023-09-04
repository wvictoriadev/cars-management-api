package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.persistence.crud.EmpleadoCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Empleado;

import java.util.List;
import java.util.Optional;

public class EmpleadoRepository {
    private EmpleadoCrudRepository empleadoCrudRepository;

    public List<Empleado> getAll() {
        return (List<Empleado>) empleadoCrudRepository.findAll();
    }

    public Optional<Empleado> getEmpleado(int idEmpleado) {
        return  empleadoCrudRepository.findById(idEmpleado);
    }

    public Empleado save(Empleado empleado) {
        return empleadoCrudRepository.save(empleado);
    }
}