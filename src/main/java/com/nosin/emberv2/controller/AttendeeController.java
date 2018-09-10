package com.nosin.emberv2.controller;

import com.nosin.emberv2.model.Attendee;
import com.nosin.emberv2.model.TicketType;
import com.nosin.emberv2.model.data.AttendeeDao;
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

    @RequestMapping(value = "all_attendees")
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
        return "attendee/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddAttendeeForm(@ModelAttribute @Valid Attendee newAttendee,
                                         Errors errors, @RequestParam int ticketTypeId,
                                         Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Ember: Add Attendee");
            model.addAttribute("ticketTypes", ticketTypeDao.findAll());
            return "attendee/add";
        }
        /*
         * ask about ticketTypeDao.findById(ticketTypeId).isPresent().get();
         */
        TicketType type = ticketTypeDao.findById(ticketTypeId).get();

        newAttendee.setTicketType(type);


        attendeeDao.save(newAttendee);
        return "redirect:";
    }

    @RequestMapping(value = "edit/{attendeeId}", method = RequestMethod.GET)
    public String displayEditAttendeeForm(Model model, @PathVariable int attendeeId, TicketType ticketType) {

        Attendee editAttendee = attendeeDao.findById(attendeeId).get();

        model.addAttribute("attendee", editAttendee);
        model.addAttribute("title", "Edit Attendee");
        model.addAttribute("ticketTypes", ticketTypeDao.findAll());

        return "attendee/edit";
    }

    @RequestMapping(value = "edit/{attendeeId}", method = RequestMethod.POST)
    public String processEditattendeeForm(int attendeeId, String first_name, String last_name, TicketType ticketType) {

        Attendee editAttendee = attendeeDao.findById(attendeeId).get();

        editAttendee.setFirst_name(first_name);
        editAttendee.setLast_name(last_name);
        attendeeDao.save(editAttendee);
        return "redirect:";
    }
}
