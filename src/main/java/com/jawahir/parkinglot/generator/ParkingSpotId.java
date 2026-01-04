package com.jawahir.parkinglot.generator;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingSpotId {
    private static final AtomicLong atomicLong = new AtomicLong();

    public static Long nextId() {
        return atomicLong.getAndIncrement();
    }
}
