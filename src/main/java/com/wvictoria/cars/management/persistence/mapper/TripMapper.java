package com.wvictoria.cars.management.persistence.mapper;

import com.wvictoria.cars.management.domain.Trip;
import com.wvictoria.cars.management.persistence.entity.Viaje;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, CarMapper.class})
public interface TripMapper {
    @Mappings({
            @Mapping(source="idViaje", target = "tripId"),
            @Mapping(source="idEmpleado", target = "employeeId"),
            @Mapping(source="idCarro", target = "carId"),
            @Mapping(source="empleado", target = "employee"),
            @Mapping(source="carro", target = "car"),
            @Mapping(source="fechaRetiro", target = "endDate"),
            @Mapping(source="fechaEntrega", target = "deliverDate")
    })
    Trip toTrip(Viaje viaje);
    List<Trip> toTrips(List<Viaje> viajes);

    @InheritInverseConfiguration
    Viaje toViaje(Trip trip);
}