package com.jawahir.parkinglot.service;

import com.jawahir.parkinglot.models.ParkingLot;
import com.jawahir.parkinglot.repositories.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotService parkingSpotService;

    public ParkingLot create(ParkingLot parkingLot) {
        // Call your repository to save parking lot
        ParkingLot persistedLot = parkingLotRepository.save(parkingLot);
        parkingSpotService.createParkingSpot(parkingLot);
        return parkingLotRepository.save(persistedLot);
    }

    public ParkingLot get(Long id) {
        return parkingLotRepository.get(id);
    }
}
