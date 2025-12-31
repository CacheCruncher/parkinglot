package com.jawahir.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
public class Ticket extends BaseModel {
    private Long vehicleId;
    private Date entryTIme;
    private Long spotId;

}
