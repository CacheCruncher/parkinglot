package com.jawahir.parkinglot.models;

import tools.jackson.core.ObjectReadContext;

import java.util.Date;

public class Ticket extends BaseModel {
    private Long vehicleId;
    private Date entryTIme;
    private Long spotId;

}
