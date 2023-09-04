package com.wvictoria.cars.management.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "viajes")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_viaje")
    private Integer idViaje;
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Column(name = "id_carro")
    private Integer idCarro;
    @Column(name = "fecha_retiro")
    private LocalDateTime fechaRetiro;
    @Column(name = "fecha_entrega")
    private LocalDateTime fechaEntrega;
}