package com.jawahir.parkinglot.generator;

import java.util.concurrent.atomic.AtomicLong;

public class GateId {
    private static final AtomicLong idCounter = new AtomicLong();

    public static Long nextId(){
        return idCounter.getAndIncrement();
    }
}
