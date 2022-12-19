package com.example.dzy.Entity;

import lombok.Data;

@Data
public class Place {

  private long id;
  private double longitude;
  private double latitude;
  private String placeName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }


  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }


  public String getPlaceName() {
    return placeName;
  }

  public void setPlaceName(String placeName) {
    this.placeName = placeName;
  }

}
