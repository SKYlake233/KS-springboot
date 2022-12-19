package com.example.dzy.Entity;

import lombok.Data;

@Data
public class AlarmRule {

  private double temperatrue;
  private double humidity;
  private double pm25;
  private double co;
  private double no2;
  private double so2;


  public double getTemperatrue() {
    return temperatrue;
  }

  public void setTemperatrue(double temperatrue) {
    this.temperatrue = temperatrue;
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
