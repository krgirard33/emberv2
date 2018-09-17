package com.nosin.emberv2.model;
/*
import javax.persistence.*;
import java.io.Serializable;
*/
/* @Entity
public class Ticket_List {
*/

    /* Start of getting fk to Attendee */
    /* private Attendee attendee; */
/*
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "ticket_num")private String ticket_num;
    @Column(name = "buyer_name")private String buyer_name;
    @Column(name = "buyer_email")private String buyer_email;
    @Column(name = "first_name")private String first_name;
    @Column(name = "last_name")private String last_name;
    @Column(name = "city")private String city;
    @Column(name = "state")private String state;
    @Column(name = "zip")private String zip;
    @Column(name = "country")private String country;
    @Column(name = "type")private String type;

    /* @OneToOne
    @JoinColumn(name = "attendee_id")
    private Attendee getAttendee() {
        return attendee;
    }
    */


    /* Constructors */
/*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicket_num() {
        return ticket_num;
    }

    public void setTicket_num(String ticket_num) {
        this.ticket_num = ticket_num;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String getBuyer_email() {
        return buyer_email;
    }

    public void setBuyer_email(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ticket_List{" +
                "id=" + id +
                ", ticket_num='" + ticket_num + '\'' +
                ", buyer_name='" + buyer_name + '\'' +
                ", buyer_email='" + buyer_email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
*/