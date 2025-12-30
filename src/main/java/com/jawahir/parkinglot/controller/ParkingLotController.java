package com.jawahir.parkinglot.controller;

import com.jawahir.parkinglot.dtos.CreateParkingLotRequest;
import com.jawahir.parkinglot.models.ParkingLot;
import com.jawahir.parkinglot.service.ParkingLotService;

public class ParkingLotController {
    ParkingLotService service = new ParkingLotService();
    // Create a parking lot
    // POST

    // 1. Request validation
    // 2. Data transformation
    public ParkingLot createParkingLot(CreateParkingLotRequest request) {
        validate(request);
        ParkingLot parkingLot = transform(request);
        return service.create(parkingLot);
    }

    private ParkingLot transform(CreateParkingLotRequest request) {
        return new ParkingLot();
    }

    private void validate(CreateParkingLotRequest request) {
        if(request.getNumberOfFloors() < 0)
            throw new RuntimeException("");
    }
}
