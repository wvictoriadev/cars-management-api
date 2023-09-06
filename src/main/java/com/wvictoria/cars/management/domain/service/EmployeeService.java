package com.wvictoria.cars.management.domain.service;

import com.wvictoria.cars.management.domain.dto.EmployeeDto;
import com.wvictoria.cars.management.domain.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    public List<EmployeeDto> getAll() {
        return employeeRepository.getAll();
    }

    public Optional<EmployeeDto> getEmployee(int employeeId) {
        return employeeRepository.getEmployee(employeeId);
    }

    public EmployeeDto save(EmployeeDto employee) {
        return employeeRepository.save(employee);
    }

    public boolean delete(int employeeId) {
        return getEmployee(employeeId).map(employee -> {
            employeeRepository.delete(employeeId);
            return true;
        }).orElse(false);
    }
}