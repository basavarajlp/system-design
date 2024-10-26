package org.example.models;

import lombok.Data;

@Data
public class Bill {

    private Ticket ticket;
    private Gate gate;
    private long exitTime;
    private double cost;
}
