package com.jawahir.parkinglot.service;

import com.jawahir.parkinglot.models.ParkingLot;
import com.jawahir.parkinglot.models.ParkingSpot;
import com.jawahir.parkinglot.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParkingSpotService {
    private ParkingSpotRepository parkingSpotRepository;

    public void createParkingSpot(ParkingLot parkingLot){
        List<ParkingSpot> parkingSpots = parkingLot.getFloors().stream().flatMap(floor -> floor.getParkingSpots().stream()).toList();

        parkingSpotRepository.saveAll(parkingSpots);
    }
}
