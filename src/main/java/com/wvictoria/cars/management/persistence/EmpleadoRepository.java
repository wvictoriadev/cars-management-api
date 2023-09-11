package com.wvictoria.cars.management.persistence;

import com.wvictoria.cars.management.domain.dto.EmployeeDto;
import com.wvictoria.cars.management.domain.repository.IEmployeeRepository;
import com.wvictoria.cars.management.persistence.crud.EmpleadoCrudRepository;
import com.wvictoria.cars.management.persistence.entity.Empleado;
import com.wvictoria.cars.management.persistence.mapper.IEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoRepository implements IEmployeeRepository {
    @Autowired
    private EmpleadoCrudRepository empleadoCrudRepository;
    @Autowired
    private IEmployeeMapper employeeMapper;

    public List<EmployeeDto> getAllEmployees() {
        List<Empleado> empleados = (List<Empleado>) empleadoCrudRepository.findAll();
        return employeeMapper.toEmployees(empleados);
    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(int employeeId) {
        return empleadoCrudRepository.findById(employeeId).map(empleado -> employeeMapper.toEmployee(empleado));
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) {
        Empleado empleado = employeeMapper.toEmpleado(employee);
        return employeeMapper.toEmployee(empleadoCrudRepository.save(empleado));
    }

    @Override
    public void deleteEmployee(int employeeId) {
        empleadoCrudRepository.deleteById(employeeId);
    }
}