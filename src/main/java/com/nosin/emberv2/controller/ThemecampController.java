package com.nosin.emberv2.controller;

import com.nosin.emberv2.model.Themecamp;
import com.nosin.emberv2.model.data.ThemecampDao;
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
@RequestMapping("themecamp")
public class ThemecampController {

    @Autowired
    ThemecampDao themecampDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Ember: Themecamps");
        model.addAttribute("themecamps", themecampDao.findAll());
        return "themecamp/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addThemecamp(Model model) {
        model.addAttribute(new Themecamp());
        model.addAttribute("title", "Ember: Add Themecamp");
        return "themecamp/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addThemecamp(Model model, @ModelAttribute @Valid Themecamp newThemecamp, Errors errors) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Ember: Add Themecamp");
            return "themecamp/add";
        }

        themecampDao.save(newThemecamp);

        return "redirect:";
    }

    @RequestMapping(value = "type/edit/(themecampId)", method = RequestMethod.GET)
    public String displayEditThemecampForm(Model model, @PathVariable int themecampId) {

        Themecamp editThemecamp = themecampDao.findById(themecampId).get();

        model.addAttribute("ticketType", editThemecamp);
        model.addAttribute("title", "Ember: Edit Themecamp");
        return "type/edit/(themecampId)";
    }

    @RequestMapping(value = "type/edit/(ticketTypeId)", method = RequestMethod.POST)
    public String processEditThemecampForm(int themecamp_id, String themecamp_name, String themecamp_type) {

        Themecamp editThemecamp = themecampDao.findById(themecamp_id).get();

        editThemecamp.setThemecampName(themecamp_name);
        editThemecamp.setThemecampType(themecamp_type);
        themecampDao.save(editThemecamp);
        return "redirect:";
    }
}

