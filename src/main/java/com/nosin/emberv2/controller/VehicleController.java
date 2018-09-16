package com.nosin.emberv2.controller;

import com.nosin.emberv2.model.Vehicle;
import com.nosin.emberv2.model.data.VehicleDao;
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
@RequestMapping(value = "vehicle")
public class VehicleController {

    @Autowired
    VehicleDao vehicleDao;

    @RequestMapping(value = {"", "index"})
    public String index(Model model) {
        model.addAttribute("title", "Ember: Vehicle");
        model.addAttribute("vehicles", vehicleDao.findAll());
        return "vehicle/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public  String addVehicle(Model model) {
        model.addAttribute(new Vehicle());
        model.addAttribute("title", "Ember: Add Vehicle");
        return "vehicle/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Vehicle newVehicle, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Ember: Add Vehicle");
            return "vehicle/add";
        }

        vehicleDao.save(newVehicle);

        return "redirect:";
    }

    @RequestMapping(value = "vehicle/edit/(vehicleId)", method = RequestMethod.GET)
    public String displayEditVehicleForm(Model model, @PathVariable int vehicleId) {
        Vehicle editVehicle = vehicleDao.findById(vehicleId).get();

        model.addAttribute("vehicle", editVehicle);
        model.addAttribute("title", "Ember: Edit Vehicle");
        return "vehicle/edit/(vehicleId)";
    }

    @RequestMapping(value = "vehicle/edit/(vehicleId)", method = RequestMethod.POST)
    public String processEditVehicleForm(int vehicle_id, String licensePlate, String make, String model, String color) {

        Vehicle editVehicle = vehicleDao.findById(vehicle_id).get();

        editVehicle.setLicensePlate(licensePlate);
        editVehicle.setMake(make);
        editVehicle.setModel(model);
        editVehicle.setColor(color);
        vehicleDao.save(editVehicle);
        return "redirect:..";
    }
}
