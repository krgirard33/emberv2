package com.nosin.emberv2.controller;

import com.nosin.emberv2.model.Attendee;
import com.nosin.emberv2.model.Themecamp;
import com.nosin.emberv2.model.data.AttendeeDao;
import com.nosin.emberv2.model.data.ThemecampDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Optional;

import javax.persistence.Id;

@Controller
@RequestMapping("attendee")
public class AttendeeController {

    @Autowired
    AttendeeDao attendeeDao;

    @RequestMapping(value = "all_attendees")
    public String all_attendees(Model model) {
        model.addAttribute("attendees", attendeeDao.findAll());
        model.addAttribute("title", "Ember: All Attendees");

        return "attendee/all_attendees";
    }

    @RequestMapping(value = "edit/{attendeeId}", method = RequestMethod.GET)
    public String displayEditAttendeeForm(Model model, @PathVariable int attendeeId) {

        Attendee editAttendee = attendeeDao.findById(attendeeId);

        model.addAttribute("attendee", editAttendee);
        model.addAttribute("title", "Edit Attendee");

        return "attendee/edit";
    }

    @RequestMapping(value = "edit/{attendeeId}", method = RequestMethod.POST)
    public String processEditattendeeForm(int attendee_id, String first_name, String last_name) {

        Attendee editAttendee = attendeeDao.findById(attendee_id);

        editAttendee.setFirst_name(first_name);
        editAttendee.setLast_name(last_name);
        attendeeDao.save(editAttendee);
        return "redirect:..";
    }

}
