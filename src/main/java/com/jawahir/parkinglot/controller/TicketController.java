package com.jawahir.parkinglot.controller;

import com.jawahir.parkinglot.dtos.CreateTicketRequest;
import com.jawahir.parkinglot.models.Ticket;
import com.jawahir.parkinglot.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticket")
@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;

    @PostMapping
    public Ticket create(@RequestBody CreateTicketRequest request){
        return ticketService.createTicket(request);
    }
}
