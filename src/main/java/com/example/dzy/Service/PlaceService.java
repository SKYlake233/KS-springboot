package com.example.dzy.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dzy.Common.DataPage;
import com.example.dzy.Entity.Place;
import com.example.dzy.Mapper.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PlaceService {

    @Autowired
    PlaceMapper placeMapper;

    public HashMap<String, Object> page(DataPage placePage) {
        String search = "";
        if(placePage.getParam().containsKey("search"))
            search = (String) placePage.getParam().get("search");
        Page<Place> page = new Page<Place>();
        page.setCurrent(placePage.getPageNum());
        page.setSize(placePage.getPageSize());
        QueryWrapper<Place> placeQueryWrapper = new QueryWrapper<Place>().like("place_name",search);
        HashMap<String , Object> map = new HashMap<String, Object>();
        map.put("total",placeMapper.selectPage(page , placeQueryWrapper).getTotal());
        map.put("data",placeMapper.selectPage(page , placeQueryWrapper).getRecords());
        return map;
    }


    public int add(Place place) {
        return placeMapper.insert(place);
    }

    public int upd(Place place) {
        return placeMapper.updateById(place);
    }
}
