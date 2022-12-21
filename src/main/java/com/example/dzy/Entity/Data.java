package com.example.dzy.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@lombok.Data
public class Data {

  private long id;
  private long collectDevice;
  private long collectLocation;
  @JsonFormat(timezone = "GMT+8",pattern = "yyyy年MM月dd日 HH:mm")
  private java.sql.Timestamp collectTime;
  private Double temperature;
  private Double humidity;
  private Integer pm25;
  private Double co;
  private Integer no2;
  private Integer so2;
}
