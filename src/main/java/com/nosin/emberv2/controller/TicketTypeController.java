package com.nosin.emberv2.controller;

import com.nosin.emberv2.model.TicketType;
import com.nosin.emberv2.model.data.TicketTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("type")
public class TicketTypeController {
    @Autowired
    TicketTypeDao ticketTypeDao;

    @RequestMapping(value = "")
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
    public String add(Model model, @ModelAttribute @Valid TicketType newTicketType, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Ember: Add TicketType");
            return "type/add";
        }

        ticketTypeDao.save(newTicketType);

        return "redirect:";
    }
}
