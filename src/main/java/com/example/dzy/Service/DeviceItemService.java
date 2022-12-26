package com.example.dzy.Service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dzy.Common.DataPage;
import com.example.dzy.Controller.VO.DeviceItemVO;
import com.example.dzy.Controller.VO.MapInfo;
import com.example.dzy.Controller.VO.MapInfoVO;
import com.example.dzy.Controller.VO.device;
import com.example.dzy.Entity.DeviceInfo;
import com.example.dzy.Entity.DeviceItem;
import com.example.dzy.Mapper.DeviceItemMapper;
import com.example.dzy.Mapper.DeviceMapper;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class DeviceItemService {

    @Autowired
    DeviceItemMapper deviceItemMapper;

    @Autowired
    DeviceMapper deviceMapper;

    public HashMap<String, Object> page(DataPage dataPage) {
        String search = "";
        if(dataPage.getParam().containsKey("search"))
            search = (String) dataPage.getParam().get("search");

        Page<DeviceItemVO> page = new Page<DeviceItemVO>();
        page.setCurrent(dataPage.getPageNum());
        page.setSize(dataPage.getPageSize());

        QueryWrapper<DeviceItemVO> deviceItemQueryWrapper = new QueryWrapper<DeviceItemVO>().like("device_item.id",search);

        HashMap<String , Object> map = new HashMap<String, Object>();

        map.put("total",deviceItemMapper.getDeviceItemVO(page , deviceItemQueryWrapper).size());
        map.put("data",deviceItemMapper.getDeviceItemVO(page , deviceItemQueryWrapper));
        return map;
    }

    public int add(DeviceItem deviceItem) {
        return deviceItemMapper.insert(deviceItem);
    }

    public int upd(DeviceItem deviceItem) {
        return deviceItemMapper.updateById(deviceItem);
    }


    public void modify(int itemId, int placeId) {
        DeviceItem deviceItem = deviceItemMapper.selectById(itemId);
        //先check是否已经安装
        checkInstall(deviceItem);
        // 然后再更改地方place
        modifyPlace(deviceItem , placeId);
        deviceMapper.modify(deviceItem.getDeviceCate());
        deviceItemMapper.updateById(deviceItem);
    }

    private void modifyPlace(DeviceItem deviceItem, int placeId) {
        deviceItem.setInstallLocation(placeId);
    }

    private void checkInstall(DeviceItem deviceItem) {
        //如果未安装  计算安装日期   之前的总数减一
        if(deviceItem.getInstallStatus() == 0){
            deviceItem.setInstallTime(new Timestamp(System.currentTimeMillis()));
            //获得设备的使用年限  然后设置
            int off = deviceMapper.getLife(deviceItem.getDeviceCate());
            deviceItem.setInstallStatus(1);
            Timestamp timestamp0  = new Timestamp(System.currentTimeMillis());
            Calendar c = Calendar.getInstance();
            c.setTime(timestamp0);
            c.add(Calendar.YEAR, off);  //  加一  天
            //c.add(Calendar.MONTH, 1); //  加一个月
            //c.add(Calendar.YEAR,1);   //  加一  年
            Timestamp time1 = new Timestamp(c.getTimeInMillis());
            deviceItem.setEndTime(time1);
        }
    }

    public List<MapInfoVO> getMapInfo() {
        List<MapInfo> res = deviceItemMapper.getMapInfo();
        MapInfoVO resItemVO = null;
        List<MapInfoVO> retVO = new ArrayList<>();
        String tmp = "";
        for (int i = 0; i < res.size(); i++) {
            if(!res.get(i).getPlaceName().equals(tmp)){
                tmp = res.get(i).getPlaceName();
                resItemVO = new MapInfoVO();
                retVO.add(resItemVO);
                resItemVO.setPlaceName(res.get(i).getPlaceName());
                resItemVO.setLatitude(res.get(i).getLatitude());
                resItemVO.setLongitude(res.get(i).getLongitude());
                resItemVO.setDeviceInfo(new ArrayList<>());
                resItemVO.getDeviceInfo().add(new device(res.get(i).getId() , res.get(i).getDeviceName()));
            }
            else{
                resItemVO.getDeviceInfo().add(new device(res.get(i).getId() , res.get(i).getDeviceName()));
            }
        }
        return retVO;
    }
}
