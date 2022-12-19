package com.example.dzy.Entity;

import lombok.Data;

@Data
public class DeviceItem {

  private long id;
  private long deviceCate;
  private long installStatus;
  private long installLocation;
  private java.sql.Timestamp installTime;
  private java.sql.Timestamp endTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getDeviceCate() {
    return deviceCate;
  }

  public void setDeviceCate(long deviceCate) {
    this.deviceCate = deviceCate;
  }


  public long getInstallStatus() {
    return installStatus;
  }

  public void setInstallStatus(long installStatus) {
    this.installStatus = installStatus;
  }


  public long getInstallLocation() {
    return installLocation;
  }

  public void setInstallLocation(long installLocation) {
    this.installLocation = installLocation;
  }


  public java.sql.Timestamp getInstallTime() {
    return installTime;
  }

  public void setInstallTime(java.sql.Timestamp installTime) {
    this.installTime = installTime;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }

}
