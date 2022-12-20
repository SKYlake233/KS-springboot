package com.example.dzy.Controller.VO;

import com.example.dzy.Entity.DeviceItem;
import lombok.Data;

@Data
public class DeviceItemVO extends DeviceItem {

    public String deviceName;
    public String placeName;
}
