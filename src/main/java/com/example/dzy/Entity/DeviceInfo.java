package com.example.dzy.Entity;

import lombok.Data;

@Data
public class DeviceInfo {

  private long id;
  private String deviceName;
  private String manufacturer;
  private long deviceLife;
  private long deviceLeft;
  private String temperature;
  private String humidity;
  private String pm25;
  private String co;
  private String no2;
  private String so2;

}
