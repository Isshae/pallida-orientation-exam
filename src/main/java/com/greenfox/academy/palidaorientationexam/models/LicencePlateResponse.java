package com.greenfox.academy.palidaorientationexam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LicencePlateResponse {

  private String result;
  private List<LicencePlate> data;

  public LicencePlateResponse(List<LicencePlate> data) {
    this.result = "ok";
    this.data = data;
  }
}
