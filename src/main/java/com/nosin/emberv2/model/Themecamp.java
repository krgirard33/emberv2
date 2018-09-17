package com.nosin.emberv2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Themecamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // ID of theme camp

    @NotNull
    private String themecampName; // Name of theme camp

    @NotNull
    private String themecampType; // Type of camp - Sound, art, service, etc

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "themecamp_id")
    private List<Attendee> attendees = new ArrayList<>(); // Links attendee to their themecamp


    // CONSTRUCTORS

    public Themecamp() { }

    public Themecamp(int id, String themecampName, String themecampType, List<Attendee> attendees) {
        this.id = id;
        this.themecampName = themecampName;
        this.themecampType = themecampType;
        this.attendees = attendees;
    }


    // GETTERS & SETTERS

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getThemecampName() { return themecampName; }

    public void setThemecampName(String themecampName) { this.themecampName = themecampName; }

    public String getThemecampType() { return themecampType; }

    public void setThemecampType(String themecampType) { this.themecampType = themecampType; }

    public List<Attendee> getAttendees() { return attendees; }

    public void setAttendees(List<Attendee> attendees) { this.attendees = attendees; }
}
