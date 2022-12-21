package com.example.dzy.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Alarm {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
  private String dataIndex;
  private long isRead;

}
