package com.greenfox.academy.palidaorientationexam.controllers;

import com.greenfox.academy.palidaorientationexam.services.LicencePlateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LicencePlateController {

  LicencePlateServiceImpl licencePlateService;

  @Autowired
  public LicencePlateController(LicencePlateServiceImpl licencePlateService) {
    this.licencePlateService = licencePlateService;
  }

  @GetMapping("/")
  public String viewIndexPage(Model model) {
    model.addAttribute("allPlates", licencePlateService.getAll());
    return "index";
  }
}
