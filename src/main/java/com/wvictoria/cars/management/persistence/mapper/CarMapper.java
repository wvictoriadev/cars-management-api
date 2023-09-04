package com.wvictoria.cars.management.persistence.mapper;

import com.wvictoria.cars.management.domain.Car;
import com.wvictoria.cars.management.persistence.entity.Carro;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mappings({
            @Mapping(source="idCarro", target = "carId"),
            @Mapping(source="modelo", target = "reference"),
            @Mapping(source="marca", target = "brand"),
            @Mapping(source="fechaFabricacion", target = "fabricationDate"),
    })
    Car toCar(Carro carro);

    @InheritInverseConfiguration
    @Mapping(target = "viajes", ignore = true)
    Carro toCarro(Car car);
}