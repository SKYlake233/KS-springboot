package com.example.dzy.Controller;

import com.example.dzy.Common.DataPage;
import com.example.dzy.Common.Result;
import com.example.dzy.Entity.DeviceInfo;
import com.example.dzy.Entity.DeviceItem;
import com.example.dzy.Mapper.DeviceItemMapper;
import com.example.dzy.Mapper.DeviceMapper;
import com.example.dzy.Service.DeviceItemService;
import com.example.dzy.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RequestMapping("/device")
@RestController
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @Autowired
    DeviceMapper deviceMapper;

    @Autowired
    DeviceItemMapper deviceItemMapper;


    @PostMapping("/page")
    public Result page(@RequestBody DataPage itemPage){
        return Result.success(deviceService.page(itemPage));
    }

    @PostMapping("/add")
    public Result add(@RequestBody DeviceInfo deviceInfo){
        return Result.success(deviceService.add(deviceInfo));
    }

    @PostMapping("/upd")
    public Result upd(@RequestBody DeviceInfo deviceInfo){
        return Result.success(deviceService.upd(deviceInfo));
    }

    @RequestMapping("/getData")
    public Result getData(){
        return Result.success(deviceMapper.selectList(null));
    }

    @RequestMapping("/addItem/{deviceId}/{insertData}")
    public Result addItem(@PathVariable("deviceId") int deviceId,@PathVariable("insertData") int insertData){
        deviceService.addItem(deviceId,insertData);
        for (int i  = 0 ; i < insertData ; i++){
            DeviceItem deviceItem = new DeviceItem();
            deviceItem.setDeviceCate(deviceId);
            deviceItem.setId(null);
            deviceItem.setInstallStatus(0);
            deviceItem.setInstallLocation(null);
            deviceItemMapper.insert(deviceItem);
        }
        return Result.success();
    }
}
