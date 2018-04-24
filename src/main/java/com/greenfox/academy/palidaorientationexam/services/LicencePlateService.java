package com.greenfox.academy.palidaorientationexam.services;

import com.greenfox.academy.palidaorientationexam.models.LicencePlate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LicencePlateService {

  List<LicencePlate> getAll();

  List<LicencePlate> getByBrand(String brand);
  List<LicencePlate> getByBrandContains(String brand);

  List<LicencePlate> getAllPolice();

  List<LicencePlate> getAllDiplomat();

  List<LicencePlate> getAllByPlate(String plate);
}
