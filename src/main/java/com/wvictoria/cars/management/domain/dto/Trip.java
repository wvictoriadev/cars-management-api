package com.wvictoria.cars.management.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Trip {
    private int tripId;
    private int employeeId;
    private int carId;
    private Employee employee;
    private CarDto car;
    private LocalDateTime endDate;
    private LocalDateTime deliverDate;
}
