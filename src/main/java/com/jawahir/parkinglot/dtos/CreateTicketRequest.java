package com.jawahir.parkinglot.dtos;

import com.jawahir.parkinglot.models.VehicleType;
import lombok.Getter;

@Getter
public class CreateTicketRequest {
    private Long parkingLotId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long entryGateId;
    private Long issuerId;
}
