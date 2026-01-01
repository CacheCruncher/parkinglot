package com.jawahir.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ParkingSpot extends BaseModel{
    private Integer spotNumber;
    private Integer floorNumber;
    private VehicleType vehicleType;
    private SpotStatus spotStatus;

    public static ParkingSpot mediumAvailable() {
        return ParkingSpot.builder()
                .vehicleType(VehicleType.MEDIUM)
                .spotStatus(SpotStatus.AVAILABLE)
                .build();
    }
}
