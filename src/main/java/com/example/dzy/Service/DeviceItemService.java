package com.example.dzy.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dzy.Common.DataPage;
import com.example.dzy.Common.Result;
import com.example.dzy.Entity.DeviceInfo;
import com.example.dzy.Entity.DeviceItem;
import com.example.dzy.Mapper.DeviceItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DeviceItemService {

    @Autowired
    DeviceItemMapper deviceItemMapper;

    public HashMap<String, Object> page(DataPage dataPage) {
        String search = "";
        if(dataPage.getParam().containsKey("search"))
            search = (String) dataPage.getParam().get("search");
        Page<DeviceItem> page = new Page<DeviceItem>();
        page.setCurrent(dataPage.getPageNum());
        page.setSize(dataPage.getPageSize());
        QueryWrapper<DeviceItem> deviceItemQueryWrapper = new QueryWrapper<DeviceItem>().like("id",search);
        HashMap<String , Object> map = new HashMap<String, Object>();
        map.put("total",deviceItemMapper.selectPage(page , deviceItemQueryWrapper).getTotal());
        map.put("data",deviceItemMapper.selectPage(page , deviceItemQueryWrapper).getRecords());
        return map;
    }

    public int add(DeviceItem deviceItem) {
        return deviceItemMapper.insert(deviceItem);
    }

    public int upd(DeviceItem deviceItem) {
        return deviceItemMapper.updateById(deviceItem);
    }


}
