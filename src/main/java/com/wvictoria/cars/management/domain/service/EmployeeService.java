package com.wvictoria.cars.management.domain.service;

import com.wvictoria.cars.management.domain.dto.Employee;
import com.wvictoria.cars.management.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    public Optional<Employee> getEmployee(int employeeId) {
        return employeeRepository.getEmployee(employeeId);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public boolean delete(int employeeId) {
        return getEmployee(employeeId).map(employee -> {
            employeeRepository.delete(employeeId);
            return true;
        }).orElse(false);
    }
}