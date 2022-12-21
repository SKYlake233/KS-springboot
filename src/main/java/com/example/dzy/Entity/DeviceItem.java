package com.example.dzy.Entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class DeviceItem {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
  private Integer deviceCate;
  private Integer installStatus;
  private Integer installLocation;
  @JsonFormat(timezone = "GMT+8",pattern = "yyyy年MM月dd日 HH:mm")
  private java.sql.Timestamp installTime;
  @JsonFormat(timezone = "GMT+8",pattern = "yyyy年MM月dd日 HH:mm")
  private java.sql.Timestamp endTime;


}
