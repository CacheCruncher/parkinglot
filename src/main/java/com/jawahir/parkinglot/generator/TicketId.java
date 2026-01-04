package com.jawahir.parkinglot.generator;

import java.util.concurrent.atomic.AtomicLong;

public class TicketId {
    private static final AtomicLong atomicLong = new AtomicLong();

    public static Long nextId() {
        return atomicLong.getAndIncrement();
    }
}
