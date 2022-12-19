package com.example.dzy.Controller;

import com.example.dzy.Common.DataPage;
import com.example.dzy.Common.Result;
import com.example.dzy.Entity.DeviceInfo;
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
}
