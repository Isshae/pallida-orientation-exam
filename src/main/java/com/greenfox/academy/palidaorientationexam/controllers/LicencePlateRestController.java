package com.greenfox.academy.palidaorientationexam.controllers;

import com.greenfox.academy.palidaorientationexam.models.LicencePlateResponse;
import com.greenfox.academy.palidaorientationexam.repositories.LicencePlateRepo;
import com.greenfox.academy.palidaorientationexam.services.LicencePlateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicencePlateRestController {

 LicencePlateServiceImpl licencePlateService;

 @Autowired
  public LicencePlateRestController(LicencePlateServiceImpl licencePlateService) {
    this.licencePlateService = licencePlateService;
  }

  @GetMapping("/api/search/{brand}")
  public LicencePlateResponse searchByBrand(@PathVariable(name = "brand")String brand){
    return new LicencePlateResponse(licencePlateService.getByBrand(brand));
  }
}

