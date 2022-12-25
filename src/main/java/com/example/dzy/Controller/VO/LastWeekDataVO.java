package com.example.dzy.Controller.VO;

import lombok.Data;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

@Data
public class LastWeekDataVO {
    private String install_location;
    private List temperature = new ArrayList();
    private List humidity = new ArrayList();
    private List pm25 = new ArrayList();
    private List co = new ArrayList();
    private List no2 = new ArrayList();
    private List so2 = new ArrayList();
}
