package org.example.service;

import org.example.models.Ticket;
import org.example.repository.TicketRepository;

import java.util.HashMap;

public class TicketService {

    TicketRepository repo;

    public Ticket save(Ticket ticket){
        return repo.save(ticket);
    }

    public Ticket getTicketById(int ticketId){
        return repo.getTicketById(ticketId);
    }
}
