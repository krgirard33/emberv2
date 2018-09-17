package com.nosin.emberv2.model;

import javax.persistence.*;

@Entity
public class Attendee {

    /*private Ticket_List ticket_list;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ticket_num")
    private String ticket_num;
    @Column(name = "buyer_name")
    private String buyer_name;
    @Column(name = "buyer_email")
    private String buyer_email;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "country")
    private String country;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "age")
    private int age;
    @Column(name = "burner_name")
    private String burner_name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;


    @ManyToOne(cascade = {CascadeType.ALL})
    private TicketType ticketType;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Themecamp themecamp;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Placement placement;

    public Attendee() {
    }

    public Attendee(Integer id, String ticket_num, String buyer_name,
                    String buyer_email, String first_name, String last_name,
                    String city, String state, String zipcode, String country,
                    String address1, String address2, int age, String burner_name,
                    String email, String phone, TicketType ticketType, Themecamp themecamp, Placement placement) {
        this.id = id;
        this.ticket_num = ticket_num;
        this.buyer_name = buyer_name;
        this.buyer_email = buyer_email;
        this.first_name = first_name;
        this.last_name = last_name;

        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.address1 = address1;
        this.address2 = address2;
        this.age = age;
        this.burner_name = burner_name;
        this.email = email;
        this.phone = phone;
        this.ticketType = ticketType;
        this.themecamp = themecamp;
        this.placement = placement;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Themecamp getThemecamp() { return themecamp; }

    public void setThemecamp(Themecamp themecamp) { this.themecamp = themecamp; }

    public Placement getPlacement() { return placement; }

    public void setPlacement(Placement placement) { this.placement = placement; }

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

}