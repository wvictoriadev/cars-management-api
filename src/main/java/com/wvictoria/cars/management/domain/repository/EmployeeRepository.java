package com.wvictoria.cars.management.domain.repository;

import com.wvictoria.cars.management.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> getAll();
    Optional<Employee> getEmployee(int employeeId);
    Employee save(Employee employee);
    void delete(int employeeId);
}