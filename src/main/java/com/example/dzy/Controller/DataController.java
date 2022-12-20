package com.example.dzy.Controller;

import com.example.dzy.Entity.Data;
import com.example.dzy.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@CrossOrigin
@RequestMapping("/data")
@RestController
public class DataController {

    @Autowired
    DataService dataService;

    @PostMapping("/upload")
    public void upload(@RequestBody Data data){
        data.setCollectTime(new Timestamp(System.currentTimeMillis()));
        dataService.check();
        dataService.upload();
    }
}
