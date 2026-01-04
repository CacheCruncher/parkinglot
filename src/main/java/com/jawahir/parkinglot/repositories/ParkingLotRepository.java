package com.jawahir.parkinglot.repositories;

import com.jawahir.parkinglot.models.ParkingLot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingLotRepository {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingLot save(ParkingLot parkingLot){
        parkingLots.add(parkingLot);
        return parkingLot;
    }

    public List<ParkingLot> findAll() {
        return parkingLots;
    }

    public ParkingLot get(Long id) {
        for(ParkingLot lot:parkingLots){
            if(lot.getId().equals(id)){
                return lot;
            }
        }
        return null;
    }
}
