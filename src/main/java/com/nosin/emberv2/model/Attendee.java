package com.nosin.emberv2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Attendee {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private int ticket_num;

    @NotNull
    @Size(min=3, max=35)
    private String buyer_name;

    private String buyer_email;

    @NotNull
    @Size(min=3, max=25)
    private String first_name;

    @NotNull
    @Size(min=3, max=25)
    private String last_name;

    @Size(min=0, max=25)
    private String burner_name;

    @NotNull
    @Size(min=3, max=50)
    private String address1;

    @Size(min=0, max=50)
    private String address2;

    @NotNull
    @Size(min=3, max=25)
    private String city;

    @NotNull
    @Size(min=1, max=5)
    private String state;

    @NotNull
    @Size(min=3, max=10)
    private String zipcode;

    @NotNull
    @Size(min=3, max=25)
    private String country;

    @Size(min=0, max=25)
    private String email;

    @Size(min=0, max=10)
    private String phone;

    @NotNull
    @Size(min=1,max=3)
    private int age;

    private String placement;

    private String themecamp;



    /* Constructors */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicket_num() {
        return ticket_num;
    }

    public void setTicket_num(int ticket_num) {
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

    public String getBurner_name() {
        return burner_name;
    }

    public void setBurner_name(String burner_name) {
        this.burner_name = burner_name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getThemecamp() {
        return themecamp;
    }

    public void setThemecamp(String themecamp) {
        this.themecamp = themecamp;
    }
}
