package com.nosin.emberv2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TicketType {
    @Id
    @GeneratedValue
    private int id; // ID of ticket type

    @NotNull
    private String name; // Text for the ticket type (Adult, Child)

    @OneToMany
    @JoinColumn(name = "type_id")
    private List<Attendee> attendees = new ArrayList<>(); // Links attendee to their ticket type


    // CONSTRUCTORS

    public TicketType() { }

    public TicketType(int id, String name, List<Attendee> attendees) {
        this.id = id;
        this.name = name;
        this.attendees = attendees;
    }


    // GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

}