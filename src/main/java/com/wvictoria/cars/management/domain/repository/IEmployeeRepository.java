package com.wvictoria.cars.management.domain.repository;

import com.wvictoria.cars.management.domain.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {
    List<EmployeeDto> getAllEmployees();
    Optional<EmployeeDto> getEmployeeById(int employeeId);
    EmployeeDto createEmployee(EmployeeDto employee);
    void deleteEmployee(int employeeId);
}