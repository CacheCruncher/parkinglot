package com.jawahir.parkinglot.dtos;

import com.jawahir.parkinglot.generator.GateId;
import com.jawahir.parkinglot.generator.ParkingFloorId;
import com.jawahir.parkinglot.generator.ParkingLotId;
import com.jawahir.parkinglot.generator.ParkingSpotId;
import com.jawahir.parkinglot.models.*;
import lombok.Getter;

import java.util.ArrayList;
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

        // 1. Create Floors (and unique spots for each floor)
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {

            List<ParkingSpot> spotsForThisFloor = new ArrayList<>();
            for (int j = 0; j < numberOfSpotsPerFloor; j++) {
                ParkingSpot spot = ParkingSpot.mediumAvailable();
                spot.setId(ParkingSpotId.nextId());
                spotsForThisFloor.add(spot);
            }

            ParkingFloor floor = ParkingFloor.builder()
                    .id(ParkingFloorId.nextId())
                    .parkingSpots(spotsForThisFloor)
                    .paymentCounter(PaymentCounter.builder().build())
                    .build();

            parkingFloors.add(floor);
        }

        // 2. Create Entry Gates
        List<EntryGate> entryGates = new ArrayList<>();
        for (int i = 0; i < numberOfEntryGates; i++) {
            entryGates.add(EntryGate.builder().id(GateId.nextId()).build());
        }

        // 3. Create Exit Gates
        List<ExitGate> exitGates = new ArrayList<>();
        for (int i = 0; i < numberOfExitGates; i++) {
            exitGates.add(ExitGate.builder().id(GateId.nextId()).build());
        }

        return ParkingLot.builder()
                .id(ParkingLotId.nextId())
                .name(name)
                .address(address)
                .floors(parkingFloors)
                .entryGates(entryGates)
                .exitGates(exitGates)
                .build();
    }
}
