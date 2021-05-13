package com.example.BlackHammerTestTask.controllers;

import com.example.BlackHammerTestTask.models.Lords;
import com.example.BlackHammerTestTask.models.Planets;
import com.example.BlackHammerTestTask.repo.LordRepository;
import com.example.BlackHammerTestTask.repo.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ModifyTableController {

    @Autowired
    private LordRepository lordRepository;
    @Autowired
    private PlanetRepository planetRepository;

    @RequestMapping(value = "/modifytable", method = RequestMethod.GET)
    public  String modTable(Model model) { return "modtable";}

    @RequestMapping(value = "/modifytable", params = "addLord", method = RequestMethod.POST)
    public  String addLord(@RequestParam String lord_name, @RequestParam Integer age, Model model) {
        Lords lord = new Lords(lord_name, age);
        lordRepository.save(lord);
        return "redirect:/modifytable";
    }

    @RequestMapping(value = "/modifytable", params = "addPlanet", method = RequestMethod.POST)
    public  String addPlanet(@RequestParam String planet_name, Model model) {
        Planets planet = new Planets(planet_name);
        planetRepository.save(planet);
        return "redirect:/modifytable";
    }

    @RequestMapping(value = "/modifytable", params = "setLordToPlanet", method = RequestMethod.POST)
    public  String setLordToPlanet(@RequestParam Long lord_id, @RequestParam Long id, Model model) {
        if (lordRepository.existsById(lord_id) && planetRepository.existsById(id)){
            planetRepository.setLordToPlanet(lord_id,id);
        }
        return "redirect:/modifytable";
    }

    @RequestMapping(value = "/modifytable", params = "delPlanet", method = RequestMethod.POST)
    public  String delPlanet(@RequestParam Long id, Model model) {
      //  planetRepository.deleteById(id);
        planetRepository.deletePlanetById(id);
        return "redirect:/modifytable";
    }


    @RequestMapping(value = "/modifytable", params = "top10", method = RequestMethod.GET)
    public  String viewTop10(Model model) {
        Iterable<Lords> lords = lordRepository.getTop10YangLords();
        model.addAttribute("lords", lords);
        return "top10";
    }

    @RequestMapping(value = "/modifytable", params = "lordsWithoutPlanets", method = RequestMethod.GET)
    public  String viewLordsWithoutPlanets(Model model) {
        Iterable<Lords> lords = lordRepository.lordsWithoutPlanets();
        model.addAttribute("lords", lords);
        return "lordswithoutplanets";
    }

}
