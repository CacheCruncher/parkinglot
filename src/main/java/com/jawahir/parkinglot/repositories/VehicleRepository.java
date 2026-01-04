package com.jawahir.parkinglot.repositories;

import com.jawahir.parkinglot.models.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();

    private Vehicle save(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    public Vehicle find(Vehicle vehicle){
        for (Vehicle v:vehicles){
            if(v.getLicenseNumber().equals(vehicle.getLicenseNumber())){
                return vehicle;
            }
        }
        return save(vehicle);
    }
}
