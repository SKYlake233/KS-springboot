package com.example.dzy.Controller.VO;

import lombok.Data;
import java.util.List;

@Data
public class MapInfoVO {
    String placeName;
    float longitude;
    float latitude;
    List<device> deviceInfo;
}
