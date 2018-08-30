package com.nosin.emberv2.controller;

import com.nosin.emberv2.model.data.AttendeeDao;
import com.nosin.emberv2.model.data.Ticket_ListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    Ticket_ListDao ticket_listDao;

    @RequestMapping(value = "all_tickets")
    public String all_tickets(Model model) {
        model.addAttribute("tickets", ticket_listDao.findAll());
        model.addAttribute("title", "Ember: All Tickets");

        return "ticket/all_tickets";
    }


}
