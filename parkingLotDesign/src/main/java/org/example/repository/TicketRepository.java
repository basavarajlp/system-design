package org.example.repository;

import org.example.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {


    private Map<Integer, Ticket> ticketDb;
    private int count;

    public TicketRepository() {
        this.ticketDb = new HashMap<>();
        this.count = 0;
    }

    public Ticket save(Ticket ticket){
        ticket.setId(count++);
        ticketDb.put(ticket.getId(), ticket);
        return ticket;
    }

    public Ticket getTicketById(int ticketId){
        return ticketDb.get(ticketId);
    }

}
