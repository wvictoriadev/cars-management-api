package com.wvictoria.cars.management.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "carros")
@Getter
@Setter
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro")
    private Integer idCarro;

    private String modelo;

    private String marca;

    @Column(name = "fecha_fabricacion")
    private LocalDateTime fechaFabricacion;

    @OneToMany(mappedBy = "carro")
    private List<Viaje> viajes;
}