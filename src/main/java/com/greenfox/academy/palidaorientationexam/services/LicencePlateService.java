package com.greenfox.academy.palidaorientationexam.services;

import com.greenfox.academy.palidaorientationexam.models.LicencePlate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LicencePlateService {

  List<LicencePlate> getAll();

  List<LicencePlate> getByBrand(String brand);
}
