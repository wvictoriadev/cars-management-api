package com.wvictoria.cars.management.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CarDto {
    private int carId;
    private String reference;
    private String brand;
    private LocalDateTime fabricationDate;
}