package com.nosin.emberv2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Attendee {

    /*private Ticket_List ticket_list;*/

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "ticket_num") private String ticket_num;
    @Column(name = "buyer_name") private String buyer_name;
    @Column(name = "buyer_email") private String buyer_email;
    @Column(name = "first_name") private String first_name;
    @Column(name = "last_name") private String last_name;
    @Column(name = "city") private String city;
    @Column(name = "state") private String state;
    @Column(name = "zipcode") private String zipcode;
    @Column(name = "country") private String country;
    @Column(name = "type") private String type;
    @Column(name = "address1") private String address1;
    @Column(name = "address2") private String address2;
    @Column(name = "age") private int age;
    @Column(name = "burner_name") private String burner_name;
    @Column(name = "email") private String email;
    @Column(name = "phone") private String phone;
    @Column(name = "placement_id") private int placement_id;
    @Column(name = "themecamp_id") private int themecamp_id;
    @Column(name = "vehicle_id") private int vehicle_id;
    @Column(name = "parent_id") private int parent_id;
    @Column(name = "trailer_id") private int trailer_id;

    /**
    @OneToOne(targetEntity = Ticket_List.class, mappedBy = "ticket_list", fetch = FetchType.EAGER)
    public Ticket_List getTicket_list() {
        return ticket_list;
    }

    public void setTicket_list(Ticket_List ticket_list) {
        this.ticket_list = ticket_list;
    }

    public Attendee(Ticket_List ticket_list) {
        this.ticket_list = ticket_list;
    }
    **/

    /* Constructors */

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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBurner_name() {
        return burner_name;
    }

    public void setBurner_name(String burner_name) {
        this.burner_name = burner_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(int placement_id) {
        this.placement_id = placement_id;
    }

    public int getThemecamp_id() {
        return themecamp_id;
    }

    public void setThemecamp_id(int themecamp_id) {
        this.themecamp_id = themecamp_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getTrailer_id() {
        return trailer_id;
    }

    public void setTrailer_id(int trailer_id) {
        this.trailer_id = trailer_id;
    }
}
