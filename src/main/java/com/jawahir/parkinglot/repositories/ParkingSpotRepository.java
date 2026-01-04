package com.jawahir.parkinglot.repositories;

import com.jawahir.parkinglot.models.ParkingSpot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingSpotRepository {
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    private void save(ParkingSpot parkingSpot){
        parkingSpots.add(parkingSpot);
    }

    public void saveAll(List<ParkingSpot> parkingSpots) {
        parkingSpots.forEach(this::save);
    }
}
