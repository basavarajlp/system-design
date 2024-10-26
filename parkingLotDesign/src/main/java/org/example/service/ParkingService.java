package org.example.service;

import org.example.models.*;

import java.util.Objects;

public class ParkingService {

    private ParkingLot lot;

    public Ticket generateTicket(Vehicle vehicle, Gate gate){

        // assign Slot
        Slot slot = lot.assignSlot(vehicle);
        if(Objects.isNull(slot)) return null;

        // generate Ticket
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setSlot(slot);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(System.currentTimeMillis());
        return ticket;
    }
}
