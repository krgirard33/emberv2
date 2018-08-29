package com.nosin.emberv2.controller;

import com.nosin.emberv2.model.data.AttendeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
