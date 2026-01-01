package com.jawahir.parkinglot.generator;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingLotId {
    private static AtomicLong atomicLong = new AtomicLong();
    public static Long nextId(){
        return atomicLong.getAndIncrement();
    }
}
