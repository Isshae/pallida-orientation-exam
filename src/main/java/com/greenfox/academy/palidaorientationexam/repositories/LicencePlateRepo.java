package com.greenfox.academy.palidaorientationexam.repositories;

import com.greenfox.academy.palidaorientationexam.models.LicencePlate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicencePlateRepo  extends CrudRepository<LicencePlate,String>{

  List<LicencePlate> findAll();

  List<LicencePlate> findAllByCarBrand(String brand);

  List<LicencePlate> findAllByCarBrandContaining(String brand);

  List<LicencePlate> findAllByPlateContaining(String plate);

  List<LicencePlate> findAllByPlateStartingWith(String plate);
}
