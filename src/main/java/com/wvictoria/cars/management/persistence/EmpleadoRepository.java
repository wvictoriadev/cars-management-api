package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.domain.dto.EmployeeDto;
import com.wvictoria.cars.management.domain.repository.EmployeeRepository;
import com.wvictoria.cars.management.persistence.crud.EmpleadoCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Empleado;
import com.wvictoria.cars.management.persistence.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoRepository implements EmployeeRepository {
    @Autowired
    private EmpleadoCrudRepository empleadoCrudRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<EmployeeDto> getAll() {
        List<Empleado> empleados = (List<Empleado>) empleadoCrudRepository.findAll();
        return employeeMapper.toEmployees(empleados);
    }

    @Override
    public Optional<EmployeeDto> getEmployee(int employeeId) {
        return empleadoCrudRepository.findById(employeeId).map(empleado -> employeeMapper.toEmployee(empleado));
    }

    @Override
    public EmployeeDto save(EmployeeDto employee) {
        Empleado empleado = employeeMapper.toEmpleado(employee);
        return employeeMapper.toEmployee(empleadoCrudRepository.save(empleado));
    }

    @Override
    public void delete(int employeeId) {
        empleadoCrudRepository.deleteById(employeeId);
    }
}