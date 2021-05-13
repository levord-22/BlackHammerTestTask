package com.example.BlackHammerTestTask.controllers;

import com.example.BlackHammerTestTask.models.Lords;
import com.example.BlackHammerTestTask.models.Planets;
import com.example.BlackHammerTestTask.repo.LordRepository;
import com.example.BlackHammerTestTask.repo.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTableController {

    @Autowired
    private LordRepository lordRepository;
    @Autowired
    private PlanetRepository planetRepository;

    @GetMapping("/viewtable")
    public  String home(Model model) {
        Iterable<Lords> lords = lordRepository.findAll();
        Iterable<Planets> planets = planetRepository.findAll();
        model.addAttribute("lords", lords);
        model.addAttribute("planets", planets );
        return "viewtable";
    }
}
