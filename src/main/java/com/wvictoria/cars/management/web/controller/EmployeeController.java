package com.wvictoria.cars.management.web.controller;

import com.wvictoria.cars.management.domain.dto.EmployeeDto;
import com.wvictoria.cars.management.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<EmployeeDto> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeDto> getEmployee(@PathVariable("id") int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/save")
    public EmployeeDto save(@RequestBody EmployeeDto employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int employeeId) {
        if (employeeService.delete(employeeId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}