package com.wvictoria.cars.management.domain.repository;

import com.wvictoria.cars.management.domain.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<EmployeeDto> getAll();
    Optional<EmployeeDto> getEmployee(int employeeId);
    EmployeeDto save(EmployeeDto employee);
    void delete(int employeeId);
}