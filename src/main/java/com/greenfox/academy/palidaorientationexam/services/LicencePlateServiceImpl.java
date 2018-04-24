package com.greenfox.academy.palidaorientationexam.services;

import com.greenfox.academy.palidaorientationexam.models.LicencePlate;
import com.greenfox.academy.palidaorientationexam.repositories.LicencePlateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicencePlateServiceImpl implements LicencePlateService {

  LicencePlateRepo licencePlateRepo;

  @Autowired
  public LicencePlateServiceImpl(LicencePlateRepo licencePlateRepo) {
    this.licencePlateRepo = licencePlateRepo;
  }

  @Override
  public List<LicencePlate> getAll() {
    return licencePlateRepo.findAll();
  }

  @Override
  public List<LicencePlate> getByBrand(String brand) {
    return licencePlateRepo.findAllByCarBrand(brand);
  }
}
