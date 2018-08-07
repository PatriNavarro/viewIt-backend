package com.patrinav.viewit.entities;

import main.resources.enumerations.TicketType;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ticket")
public class Ticket extends Product{
    @Column(name = "ticket_type")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    public Ticket() {
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
}
