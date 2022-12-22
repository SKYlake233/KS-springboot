package com.example.dzy.Controller.VO;

import com.example.dzy.Entity.Place;
import lombok.Data;

@Data
public class LatestDataVO extends Place {
    //数据信息
    private double temperature;
    private double humidity;
    private double pm25;
    private double co;
    private double no2;
    private double so2;
}
