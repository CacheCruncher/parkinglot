package com.jawahir.parkinglot.repositories;

import com.jawahir.parkinglot.models.ParkingSpot;
import com.jawahir.parkinglot.models.SpotStatus;
import com.jawahir.parkinglot.models.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingSpotRepository {
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    private void save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    public void saveAll(List<ParkingSpot> parkingSpots) {
        parkingSpots.forEach(this::save);
    }

    public ParkingSpot findOneByVehicleTypeAndStatusAvailable(VehicleType vehicleType) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.getSpotStatus() == SpotStatus.AVAILABLE && parkingSpot.getVehicleType() == vehicleType) {
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot update(ParkingSpot filledSpot) {
        ParkingSpot currentSpot = parkingSpots.stream()
                .filter(spot -> spot.getId().equals(filledSpot.getId()))
                .findFirst().get();

        if(null == currentSpot){
            throw new RuntimeException("Invalid Spot");
        }

        parkingSpots.remove(currentSpot);
        parkingSpots.add(filledSpot);
        return filledSpot;
    }
}
