package com.nosin.emberv2.controller;

import com.nosin.emberv2.model.Placement;
import com.nosin.emberv2.model.data.PlacementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("placement")
public class PlacementController {

    @Autowired
    PlacementDao placementDao;

    @RequestMapping(value = {"", "index"})
    public String index(Model model) {
        model.addAttribute("title", "Ember: Placements");
        model.addAttribute("placements", placementDao.findAll());
        return "placement/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addPlacement(Model model) {
        model.addAttribute(new Placement());
        model.addAttribute("title", "Ember: Add Placement");
        return "placement/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addPlacement(Model model, @ModelAttribute @Valid Placement newPlacement, Errors errors) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Ember: Add Placement");
            return "placement/add";
        }

        placementDao.save(newPlacement);

        return "redirect:";
    }

    @RequestMapping(value = "placement/edit/(placementId)", method = RequestMethod.GET)
    public String displayEditPlacementForm(Model model, @PathVariable int placementId) {

        Placement editPlacement = placementDao.findById(placementId).get();

        model.addAttribute("placement", editPlacement);
        model.addAttribute("title", "Ember: Edit Placement");
        return "placement/edit/(placementId)";
    }

    @RequestMapping(value = "placement/edit/(placementId)", method = RequestMethod.POST)
    public String processEditPlacementForm(int placement_id, String placement_name) {

        Placement editPlacement = placementDao.findById(placement_id).get();

        editPlacement.setPlacementName(placement_name);
        placementDao.save(editPlacement);
        return "redirect:";
    }
}
