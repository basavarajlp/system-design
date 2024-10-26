package org.example.models;

import lombok.Data;

@Data
public class Ticket {

    private int id;
    private long entryTime;
    private Vehicle vehicle;
    private Slot slot;
    private Operator operator;

}
