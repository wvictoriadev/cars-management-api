package com.wvictoria.cars.management.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "empleados")
@Getter
@Setter
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    private String nombre;

    private String matricula;

    @OneToMany(mappedBy = "empleado")
    private List<Viaje> viajes;
}