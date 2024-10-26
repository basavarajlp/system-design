package org.example.controllers;

import org.example.models.*;
import org.example.service.BillingService;
import org.example.service.ParkingService;
import org.example.service.TicketService;

public class Controller {

    private ParkingService parkingService;
    private TicketService ticketService;
    private BillingService billingService;

    //POST - generate Ticket with vehicle
    public Ticket generateTicket(Vehicle vehicle,Gate gate){
        return parkingService.generateTicket(vehicle,gate);
    }

    //GET - Ticket Info by ticket id
    public Ticket getTicketInfo(int ticketId){
        return ticketService.getTicketById(ticketId);
    }

    //GET - get bill by ticket ID
    public Bill getBillForTicket(int ticketId,long exitTime,Gate gate){
        Ticket ticket = getTicketInfo(ticketId);
        return billingService.getBillForTicket(ticket,exitTime,gate);
    }

}
