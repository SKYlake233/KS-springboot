package com.example.dzy.Controller;

import com.example.dzy.Common.DataPage;
import com.example.dzy.Common.Result;
import com.example.dzy.Entity.DeviceInfo;
import com.example.dzy.Entity.Place;
import com.example.dzy.Mapper.PlaceMapper;
import com.example.dzy.Service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/place")
@RestController
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @Autowired
    PlaceMapper placeMapper;

    @PostMapping("/page")
    public Result page(@RequestBody DataPage placePage){
        return Result.success(placeService.page(placePage));
    }

    @PostMapping("/add")
    public Result add(@RequestBody Place place){
        return Result.success(placeService.add(place));
    }

    @PostMapping("/upd")
    public Result upd(@RequestBody Place place){
        return Result.success(placeService.upd(place));
    }
    @RequestMapping("/getData")
    public Result getData(){
        return Result.success(placeMapper.selectList(null));
    }

}
