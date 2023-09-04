package com.wvictoria.cars.management.web.controller;

import com.wvictoria.cars.management.domain.Employee;
import com.wvictoria.cars.management.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}