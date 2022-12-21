package com.example.dzy.Entity;

@lombok.Data
public class Data {

  private long id;
  private long collectDevice;
  private long collectLocation;
  private java.sql.Timestamp collectTime;
  private Double temperature;
  private Double humidity;
  private Integer pm25;
  private Double co;
  private Integer no2;
  private Integer so2;
}
