package com.jawahir.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder
public class ParkingFloor extends BaseModel{
    private Integer floorNumber;
    private List<ParkingSpot> parkingSpots = new ArrayList<>();
    private DisplayBoard displayBoard;
    private PaymentCounter paymentCounter;
}

