package com.jawahir.parkinglot.controller;

import com.jawahir.parkinglot.dtos.CreateParkingLotRequest;
import com.jawahir.parkinglot.models.ParkingLot;
import com.jawahir.parkinglot.service.ParkingLotService;
import org.springframework.web.bind.annotation.*;

// Step 1: Add rest-controller annotation: for spring to know this is controller
@RestController
@RequestMapping("/api/v1/parking-lot") // Step 2- Map all the request for this URL to this controller
public class ParkingLotController {
    ParkingLotService service = new ParkingLotService();
    // Create a parking lot
    // POST

    // 1. Request validation
    // 2. Data transformation
    // POST /api/vi/parking-lot
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request) {
        validate(request);
        ParkingLot parkingLot = transform(request);
        return parkingLot; //service.create(parkingLot);
    }

    // GET /api/v1/parking-lot/{id}
    @GetMapping("/{id}") // Step 3: Add method level mapping
    public ParkingLot getParkingLot(@PathVariable Long id){ // Step 4: Add path variable
        return ParkingLot.builder().id(id).build();
    }

    private ParkingLot transform(CreateParkingLotRequest request) {
        return request.toParkingLot();
    }

    private void validate(CreateParkingLotRequest request) {
        if(request.getNumberOfFloors()  == null)
            throw new RuntimeException("Invalid number of floors");
    }
}
