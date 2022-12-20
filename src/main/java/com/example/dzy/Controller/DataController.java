package com.example.dzy.Controller;

import com.example.dzy.Common.Result;
import com.example.dzy.Entity.Data;
import com.example.dzy.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@CrossOrigin
@RequestMapping("/data")
@RestController
public class DataController {

    @Autowired
    DataService dataService;

    @PostMapping("/upload")
    @Transactional
    public Result upload(@RequestBody Data data){
        System.out.println(data.toString());
        data.setCollectTime(new Timestamp(System.currentTimeMillis()));
        dataService.check(data);
        dataService.upload(data);
        return Result.success();
    }
}
