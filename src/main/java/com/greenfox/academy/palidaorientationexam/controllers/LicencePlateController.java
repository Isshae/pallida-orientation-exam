package com.greenfox.academy.palidaorientationexam.controllers;

import com.greenfox.academy.palidaorientationexam.services.LicencePlateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/search")
  public String searchForLicencePlate(@RequestParam(name = "plate",required = false) String plate, Model model) {
    if (!licencePlateService.validateSearch(plate)) {
      model.addAttribute("error", "Sorry, the submitted licence plate is not valid");
      return "index";
    } else {
      model.addAttribute("allPlates", licencePlateService.searchedPlate(plate));
      return "index";
    }
  }

  @GetMapping("/search/{brand}")
  public String searchByBrand(@PathVariable(name = "brand",required = false) String brand, Model model){
    model.addAttribute("allPlates", licencePlateService.getByBrand(brand));
    return "index";
  }
}
