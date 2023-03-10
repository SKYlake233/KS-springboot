package com.example.dzy.Controller;

import com.example.dzy.Common.Result;
import com.example.dzy.Entity.Alarm;
import com.example.dzy.Entity.Data;
import com.example.dzy.Mapper.AlarmMapper;
import com.example.dzy.Mapper.DataMapper;
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
    DataMapper dataMapper;

    @Autowired
    AlarmMapper alarmMapper;

    @PostMapping("/upload")
    @Transactional
    public Result upload(@RequestBody Data data){
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

    @RequestMapping("/latestData")
    public Result getLatestData(){
        return Result.success(dataMapper.getLatestDataVO());
    }

    @RequestMapping("/history/{place_id}")
    public Result addItem(@PathVariable("place_id") int place_id){

        return Result.success(dataService.getHistoryWeekData(place_id));
    }

    @RequestMapping("/month/{place_id}")
    public Result ADDDATA(@PathVariable("place_id") int place_id){
        return Result.success(dataService.getHistoryMonthData(place_id));
    }
}
