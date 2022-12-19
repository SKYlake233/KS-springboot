package com.example.dzy.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dzy.Common.DataPage;
import com.example.dzy.Entity.DeviceInfo;
import com.example.dzy.Mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    public HashMap<String, Object> page(DataPage dataPage) {
        String search = "";
        if(dataPage.getParam().containsKey("search"))
            search = (String) dataPage.getParam().get("search");
        Page<DeviceInfo> page = new Page<DeviceInfo>();
        page.setCurrent(dataPage.getPageNum());
        page.setSize(dataPage.getPageSize());
        QueryWrapper<DeviceInfo> deviceInfoQueryWrapper = new QueryWrapper<DeviceInfo>().like("device_name",search);
        HashMap<String , Object> map = new HashMap<String, Object>();
        map.put("total",deviceMapper.selectPage(page , deviceInfoQueryWrapper).getTotal());
        map.put("data",deviceMapper.selectPage(page , deviceInfoQueryWrapper).getRecords());
        return map;
    }

    public int add(DeviceInfo deviceInfo) {
        return deviceMapper.insert(deviceInfo);
    }

    public int upd(DeviceInfo deviceInfo) {
        return deviceMapper.updateById(deviceInfo);
    }
}
