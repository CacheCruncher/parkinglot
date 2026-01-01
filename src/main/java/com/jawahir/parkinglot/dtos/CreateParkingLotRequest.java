package com.jawahir.parkinglot.dtos;

import com.jawahir.parkinglot.generator.ParkingFloorId;
import com.jawahir.parkinglot.generator.ParkingLotId;
import com.jawahir.parkinglot.generator.ParkingSpotId;
import com.jawahir.parkinglot.models.*;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class CreateParkingLotRequest {
    private String name;
    private String address;
    private Integer numberOfFloors;
    private Integer numberOfSpotsPerFloor;
    private Integer numberOfEntryGates;
    private Integer numberOfExitGates;

    // DTO -> Model
    // Prototype pattern
    public ParkingLot toParkingLot() {

        // Create dummy parking spots and update their ids
        List<ParkingSpot> parkingSpotsPerFloor = Collections.nCopies(numberOfSpotsPerFloor, ParkingSpot.mediumAvailable());

        parkingSpotsPerFloor.forEach(spot -> {
            spot.setId(ParkingSpotId.nextId());
        });

        // Create dummy parking floors and update their ids
        List<ParkingFloor> parkingFloors = Collections.nCopies(numberOfFloors,
                ParkingFloor
                        .builder()
                        .id(ParkingFloorId.nextId())
                        .parkingSpots(parkingSpotsPerFloor)
                        .paymentCounter(PaymentCounter.builder().build())
                        .build());


        return ParkingLot
                .builder()
                .id(ParkingLotId.nextId())
                .name(name)
                .address(address)
                .floors(parkingFloors)
                .entryGates(Collections.nCopies(numberOfEntryGates, EntryGate.builder().build()))
                .exitGates(Collections.nCopies(numberOfExitGates, ExitGate.builder().build()))
                .build();
    }
}
