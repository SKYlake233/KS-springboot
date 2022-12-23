package com.example.dzy.Entity;

import lombok.Data;


@Data
public class AlarmRule {

  private double temperature;
  private double humidity;
  private double pm25;
  private double co;
  private double no2;
  private double so2;


  private AlarmRule(){}
  private static AlarmRule _AlarmRule = null;
  public static AlarmRule getAlarmRule(){
    if(_AlarmRule == null){
    }
    return _AlarmRule;
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
