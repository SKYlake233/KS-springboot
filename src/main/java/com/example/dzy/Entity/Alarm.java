package com.example.dzy.Entity;

import lombok.Data;

@Data
public class Alarm {

  private long id;
  private long dataIndex;
  private long read;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getDataIndex() {
    return dataIndex;
  }

  public void setDataIndex(long dataIndex) {
    this.dataIndex = dataIndex;
  }


  public long getRead() {
    return read;
  }

  public void setRead(long read) {
    this.read = read;
  }

}
