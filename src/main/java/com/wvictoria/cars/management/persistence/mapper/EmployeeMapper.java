package com.wvictoria.cars.management.persistence.mapper;

import com.wvictoria.cars.management.domain.Employee;
import com.wvictoria.cars.management.persistence.entity.Empleado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mappings({
            @Mapping(source="idEmpleado", target = "employeeId"),
            @Mapping(source="nombre", target = "name"),
            @Mapping(source="matricula", target = "registration")
    })
    Employee toEmployee(Empleado empleado);

    @InheritInverseConfiguration
    @Mapping(target = "viajes", ignore = true)
    Empleado toEmpleado(Employee employee);
}