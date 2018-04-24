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

  @Override
  public List<LicencePlate> getByBrandContains(String brand) {
    return licencePlateRepo.findAllByPlateContaining(brand);
  }

  @Override
  public List<LicencePlate> getAllPolice() {
    return licencePlateRepo.findAllByPlateStartingWith("rb");
  }

  @Override
  public List<LicencePlate> getAllDiplomat() {
    return licencePlateRepo.findAllByPlateStartingWith("dt");
  }

  @Override
  public List<LicencePlate> getAllByPlate(String plate) {
    return licencePlateRepo.findAllByPlateContaining(plate);
  }

  public List<LicencePlate> searchedPlate(String plate) {
    if (plate == null) {
      return null;
    } else if (plate.equals("police")) {
      return getAllPolice();
    } else if (plate.equals("diplomat")) {
      return getAllDiplomat();
    } else {
      return getAllByPlate(plate);
    }

  }

  public boolean validateSearch(String search) {
    return search.matches("^[-a-zA-Z0-9._]+");
  }
}
