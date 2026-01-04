package com.jawahir.parkinglot.service;


import com.jawahir.parkinglot.dtos.CreateTicketRequest;
import com.jawahir.parkinglot.generator.TicketId;
import com.jawahir.parkinglot.models.ParkingSpot;
import com.jawahir.parkinglot.models.SpotStatus;
import com.jawahir.parkinglot.models.Ticket;
import com.jawahir.parkinglot.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class TicketService {
    private TicketRepository ticketRepository;
    private VehicleService vehicleService;
    private ParkingSpotService parkingSpotService;


    public Ticket createTicket(CreateTicketRequest request) {
        // Create if parking lot is full
        ParkingSpot parkingSpot = parkingSpotService.allocateSlot(request.getParkingLotId(), request.getVehicleType());
        if(null == parkingSpot){
            throw new RuntimeException("Slot not available");
        }
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
        parkingSpotService.update(parkingSpot);

        Ticket ticket = Ticket.builder()
                .id(TicketId.nextId())
                .entryTime(new Date())
                .vehicle(vehicleService.findOrCreate(request.getVehicleNumber(),request.getVehicleType()))
                .spotId(parkingSpot.getId())
                .entryGateId(request.getEntryGateId())
                .build();
        return ticketRepository.save(ticket);
    }
}
