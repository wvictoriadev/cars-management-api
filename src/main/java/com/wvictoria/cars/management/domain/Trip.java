package com.wvictoria.cars.management.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trip {
    private int tripId;
    private int employeeId;
    private int carId;
    private Employee employee;
    private Car car;
}
