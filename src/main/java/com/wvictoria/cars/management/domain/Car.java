package com.wvictoria.cars.management.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Car {
    private int carId;
    private String reference;
    private String brand;
    private LocalDateTime fabricationDate;
}