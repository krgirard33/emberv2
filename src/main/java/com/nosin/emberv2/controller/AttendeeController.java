package com.nosin.emberv2.controller;

import com.nosin.emberv2.model.Attendee;
import com.nosin.emberv2.model.Placement;
import com.nosin.emberv2.model.Themecamp;
import com.nosin.emberv2.model.TicketType;
import com.nosin.emberv2.model.data.AttendeeDao;
import com.nosin.emberv2.model.data.PlacementDao;
import com.nosin.emberv2.model.data.ThemecampDao;
import com.nosin.emberv2.model.data.TicketTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("attendee")
public class AttendeeController {

    @Autowired
    AttendeeDao attendeeDao;

    @Autowired
    TicketTypeDao ticketTypeDao;

    @Autowired
    ThemecampDao themecampDao;

    @Autowired
    PlacementDao placementDao;

    @RequestMapping(value = {"", "all_attendees", "index"})
    public String all_attendees(Model model) {
        model.addAttribute("attendees", attendeeDao.findAll());
        model.addAttribute("title", "Ember: All Attendees");

        return "attendee/all_attendees";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddAttendeeForm(Model model) {
        model.addAttribute("title", "Ember: Add Attendee");
        model.addAttribute(new Attendee());
        model.addAttribute("ticketTypes", ticketTypeDao.findAll());
        model.addAttribute("themecamps", themecampDao.findAll());
        model.addAttribute("placements", placementDao.findAll());
        return "attendee/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddAttendeeForm(@ModelAttribute @Valid Attendee newAttendee,
                                         Errors errors, @RequestParam int ticketTypeId,
                                         @RequestParam int themecampId, @RequestParam int placementId,
                                         Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Ember: Add Attendee");
            model.addAttribute("ticketTypes", ticketTypeDao.findAll());
            model.addAttribute("themecamps", themecampDao.findAll());
            model.addAttribute("placements", placementDao.findAll());
            return "attendee/add";
        }
        /*
         * ask about ticketTypeDao.findById(ticketTypeId).isPresent().get();
         */
        TicketType type = ticketTypeDao.findById(ticketTypeId).get();
        Themecamp themecamp = themecampDao.findById(themecampId).get();
        Placement placement = placementDao.findById(placementId).get();

        newAttendee.setTicketType(type);
        newAttendee.setThemecamp(themecamp);
        newAttendee.setPlacement(placement);
        attendeeDao.save(newAttendee);
        return "redirect:";
    }

    @RequestMapping(value = "edit/{attendeeId}", method = RequestMethod.GET)
    public String displayEditAttendeeForm(Model model, @PathVariable Integer attendeeId) {

        Attendee editAttendee = attendeeDao.findById(attendeeId).get();

        model.addAttribute("attendee", editAttendee);
        model.addAttribute("title", "Edit Attendee");
        model.addAttribute("ticketTypes", ticketTypeDao.findAll());
        model.addAttribute("themecamps", themecampDao.findAll());
        model.addAttribute("placements", placementDao.findAll());

        return "attendee/edit";
    }

    @RequestMapping(value = "edit/{attendeeId}", method = RequestMethod.POST)
    public String processEditattendeeForm(@PathVariable Integer attendeeId, String first_name, String last_name,
                                          String burner_name, String address1, String address2, String city,
                                          String zipcode, String state, String country, String email, String phone, int age,
                                          String buyer_name, String buyer_email, String contact_name, String contact_phone,
                                          TicketType ticketType, Themecamp themecamp, int placementId, int themecampId,
                                          int ticketTypeId) {

        Attendee editAttendee = attendeeDao.findById(attendeeId).get();
        Placement editPlacement = placementDao.findById(placementId).get();
        Themecamp editThemecamp = themecampDao.findById(themecampId).get();
        TicketType editTicketType = ticketTypeDao.findById(ticketTypeId).get();


        editAttendee.setFirst_name(first_name);
        editAttendee.setLast_name(last_name);
        editAttendee.setBurner_name(burner_name);
        editAttendee.setAddress1(address1);
        editAttendee.setAddress2(address2);
        editAttendee.setCity(city);
        editAttendee.setZipcode(zipcode);
        editAttendee.setState(state);
        editAttendee.setCountry(country);
        editAttendee.setEmail(email);
        editAttendee.setPhone(phone);
        editAttendee.setAge(age);
        editAttendee.setContact_name(contact_name);
        editAttendee.setContact_phone(contact_phone);
        editAttendee.setTicketType(editTicketType);
        editAttendee.setThemecamp(editThemecamp);
        editAttendee.setPlacement(editPlacement);

        attendeeDao.save(editAttendee);
        return "redirect:..";
    }
}
