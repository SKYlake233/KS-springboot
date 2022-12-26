package com.example.dzy.Controller;

import com.example.dzy.Common.DataPage;
import com.example.dzy.Common.Result;
import com.example.dzy.Entity.DeviceItem;
import com.example.dzy.Entity.Place;
import com.example.dzy.Mapper.DeviceMapper;
import com.example.dzy.Service.DeviceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/item")
@RestController
public class DeviceItemController {

    @Autowired
    DeviceItemService deviceItemService;

    @PostMapping("/page")
    public Result page(@RequestBody DataPage placePage){
        return Result.success(deviceItemService.page(placePage));
    }

    @PostMapping("/add")
    public Result add(@RequestBody DeviceItem deviceItem){
        return Result.success(deviceItemService.add(deviceItem));
    }

    @PostMapping("/upd")
    public Result upd(@RequestBody DeviceItem deviceItem){
        return Result.success(deviceItemService.upd(deviceItem));
    }



    @Transactional
    @RequestMapping("/modify/{itemId}/{placeId}")
    public Result modify(@PathVariable("itemId") int itemId,@PathVariable("placeId") int placeID){

        deviceItemService.modify(itemId , placeID);
        return Result.success();
    }



    @RequestMapping("/mapInfo")
    public Result getMapInfo(){
        return Result.success(deviceItemService.getMapInfo());
    }
}
