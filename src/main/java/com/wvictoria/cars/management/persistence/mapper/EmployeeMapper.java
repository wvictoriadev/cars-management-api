package com.wvictoria.cars.management.persistence.mapper;

import com.wvictoria.cars.management.domain.dto.EmployeeDto;
import com.wvictoria.cars.management.persistence.entity.Empleado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mappings({
            @Mapping(source="idEmpleado", target = "employeeId"),
            @Mapping(source="nombre", target = "name"),
            @Mapping(source="matricula", target = "registration")
    })
    EmployeeDto toEmployee(Empleado empleado);
    List<EmployeeDto> toEmployees(List<Empleado> empleados);

    @InheritInverseConfiguration
    @Mapping(target = "viajes", ignore = true)
    Empleado toEmpleado(EmployeeDto employee);
}