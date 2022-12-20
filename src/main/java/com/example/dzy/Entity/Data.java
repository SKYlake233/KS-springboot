package com.example.dzy.Entity;

@lombok.Data
public class Data {

  private long id;
  private long collectDevice;
  private long collectLocation;
  private java.sql.Timestamp collectTime;
  private double temperature;
  private double humidity;
  private int pm25;
  private double co;
  private int no2;
  private int so2;
}
