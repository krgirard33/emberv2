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
    public String displayEditAttendeeForm(Model model, @PathVariable Integer attendeeId, TicketType ticketType,
                                          Themecamp themecamp, Placement placement) {

        Attendee editAttendee = attendeeDao.findById(attendeeId).get();

        model.addAttribute("attendee", editAttendee);
        model.addAttribute("title", "Edit Attendee");
        model.addAttribute("ticketTypes", ticketTypeDao.findAll());
        model.addAttribute("themecamps", themecampDao.findAll());
        model.addAttribute("placements", placementDao.findAll());

        return "attendee/edit";
    }

    @RequestMapping(value = "edit/{attendeeId}", method = RequestMethod.POST)
    public String processEditattendeeForm(@PathVariable Integer attendeeId, String first_name, String last_name, String burner_name,
                                          TicketType ticketType, Themecamp themecamp, Placement placement) {

        Attendee editAttendee = attendeeDao.findById(attendeeId).get();

        editAttendee.setFirst_name(first_name);
        editAttendee.setLast_name(last_name);
        editAttendee.setBurner_name(burner_name);
        editAttendee.setTicketType(ticketType);
        editAttendee.setThemecamp(themecamp);
        editAttendee.setPlacement(placement);

        attendeeDao.save(editAttendee);
        return "redirect:";
    }
}
