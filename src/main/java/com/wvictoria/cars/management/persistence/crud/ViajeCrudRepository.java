package com.wvictoria.cars.management.persistence.crud;

import com.wvictoria.cars.management.persistence.entity.Viaje;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ViajeCrudRepository extends CrudRepository<Viaje, Integer> {
    List<Viaje> findByIdEmpleadoOrderByNombreAsc(int idEmpleado);
}

