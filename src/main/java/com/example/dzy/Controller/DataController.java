package com.example.dzy.Controller;

import com.example.dzy.Common.Result;
import com.example.dzy.Entity.Alarm;
import com.example.dzy.Entity.Data;
import com.example.dzy.Mapper.AlarmMapper;
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

    @Autowired
    AlarmMapper alarmMapper;

    @PostMapping("/upload")
    @Transactional
    public Result upload(@RequestBody Data data){
        System.out.println(data.toString());
        data.setCollectTime(new Timestamp(System.currentTimeMillis()));
        dataService.check(data);
        dataService.upload(data);
        return Result.success();
    }

    @RequestMapping("/alarmData")
    public Result getAlarm(){
        return Result.success(alarmMapper.selectList(null));
    }

    @PostMapping("/modifyAlarm")
    public Result modifyAlarm(@RequestBody Alarm alarm){
        alarm.setIsRead(1);
        alarmMapper.updateById(alarm);
        return Result.success();
    }
}
