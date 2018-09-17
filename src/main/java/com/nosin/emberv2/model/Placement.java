package com.nosin.emberv2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // ID of placement

    @NotNull
    private String placementName; // Name of placement

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "placement_id")
    private List<Attendee> attendees = new ArrayList<>(); // Links attendee to their placement

    public Placement() { }

    public Placement(int id, String placementName, List<Attendee> attendees) {
        this.id = id;
        this.placementName = placementName;
        this.attendees = attendees;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlacementName() {
        return placementName;
    }

    public void setPlacementName(String placementName) {
        this.placementName = placementName;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

}
