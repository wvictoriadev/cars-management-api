package com.wvictoria.cars.management.persistence.mapper;

import com.wvictoria.cars.management.domain.Car;
import com.wvictoria.cars.management.domain.Employee;
import com.wvictoria.cars.management.persistence.entity.Carro;
import com.wvictoria.cars.management.persistence.entity.Empleado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mappings({
            @Mapping(source="idCarro", target = "carId"),
            @Mapping(source="modelo", target = "reference"),
            @Mapping(source="marca", target = "brand"),
            @Mapping(source="fechaFabricacion", target = "fabricationDate"),
    })
    Car toCar(Carro carro);
    List<Car> toCars(List<Carro> carros);

    @InheritInverseConfiguration
    @Mapping(target = "viajes", ignore = true)
    Carro toCarro(Car car);
}