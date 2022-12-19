package com.example.dzy.Entity;

@lombok.Data
public class Data {

  private long id;
  private long collectDevice;
  private long collectLocation;
  private java.sql.Timestamp collectTime;
  private double temperature;
  private double humidity;
  private double pm25;
  private double co;
  private double no2;
  private double so2;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCollectDevice() {
    return collectDevice;
  }

  public void setCollectDevice(long collectDevice) {
    this.collectDevice = collectDevice;
  }


  public long getCollectLocation() {
    return collectLocation;
  }

  public void setCollectLocation(long collectLocation) {
    this.collectLocation = collectLocation;
  }


  public java.sql.Timestamp getCollectTime() {
    return collectTime;
  }

  public void setCollectTime(java.sql.Timestamp collectTime) {
    this.collectTime = collectTime;
  }


  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }


  public double getHumidity() {
    return humidity;
  }

  public void setHumidity(double humidity) {
    this.humidity = humidity;
  }


  public double getPm25() {
    return pm25;
  }

  public void setPm25(double pm25) {
    this.pm25 = pm25;
  }


  public double getCo() {
    return co;
  }

  public void setCo(double co) {
    this.co = co;
  }


  public double getNo2() {
    return no2;
  }

  public void setNo2(double no2) {
    this.no2 = no2;
  }


  public double getSo2() {
    return so2;
  }

  public void setSo2(double so2) {
    this.so2 = so2;
  }

}
