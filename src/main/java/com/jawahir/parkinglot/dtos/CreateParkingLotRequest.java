package com.jawahir.parkinglot.dtos;

import lombok.Getter;

@Getter
public class CreateParkingLotRequest {
    private String name;
    private String address;
    private Integer numberOfFloors;
    private Integer numberOfEntryGates;
    private Integer numberOfExitGates;
    private Integer numberOfSpotsPerFloor;
}
