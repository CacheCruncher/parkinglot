package com.jawahir.parkinglot.service;

import com.jawahir.parkinglot.models.Vehicle;
import com.jawahir.parkinglot.models.VehicleType;
import com.jawahir.parkinglot.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleService {
    private VehicleRepository vehicleRepository;

    public Vehicle findOrCreate(String vehicleNumber, VehicleType vehicleType){
        Vehicle vehicle = Vehicle.builder()
                .licenseNumber(vehicleNumber)
                .type(vehicleType)
                .build();
        return vehicleRepository.find(vehicle);
    }
}
