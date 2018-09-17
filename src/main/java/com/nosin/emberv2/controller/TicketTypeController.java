package com.nosin.emberv2.controller;

import com.nosin.emberv2.model.TicketType;
import com.nosin.emberv2.model.data.TicketTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("type")
public class TicketTypeController {

    /*
    * There is the part of me that wonders if doing it as a enum might
    * not have been better, as there is only 4 types: under 15, 15-20, 21+
    */

    @Autowired
    TicketTypeDao ticketTypeDao;

    @RequestMapping(value = {"", "index"})
    public String index(Model model) {
        model.addAttribute("title", "Ember: Ticket Types");
        model.addAttribute("ticketTypes", ticketTypeDao.findAll());
        return "type/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public  String addTicketTyps(Model model) {
        model.addAttribute(new TicketType());
        model.addAttribute("title", "Ember: Add TicketType");
        return "type/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addTicketType(Model model, @ModelAttribute @Valid TicketType newTicketType, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Ember: Add TicketType");
            return "type/add";
        }

        ticketTypeDao.save(newTicketType);

        return "redirect:";
    }


    @RequestMapping(value = "type/edit/(ticketTypeId)", method = RequestMethod.GET)
    public String displayEditTicketTypeForm(Model model, @PathVariable int ticketTypeId) {
        TicketType editTicketType = ticketTypeDao.findById(ticketTypeId).get();

        model.addAttribute("ticketType", editTicketType);
        model.addAttribute("title", "Ember: Edit Ticket Type");
        return "type/edit/(ticketTypeId)";
    }

    @RequestMapping(value = "type/edit/(ticketTypeId)", method = RequestMethod.POST)
    public String processEditTicketTypeForm(int ticketType_id, String name) {

        TicketType editTicketType = ticketTypeDao.findById(ticketType_id).get();

        editTicketType.setName(name);
        ticketTypeDao.save(editTicketType);
        return "redirect:..";
    }
}
