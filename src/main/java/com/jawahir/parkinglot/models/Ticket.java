package com.jawahir.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
public class Ticket extends BaseModel {
    private Vehicle vehicle;

    private Date entryTime;
    private Long spotId;
    private Long entryGateId;
}
