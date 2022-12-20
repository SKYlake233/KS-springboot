package com.example.dzy.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.dzy.Controller.VO.DeviceItemVO;
import com.example.dzy.Entity.DeviceItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.Wrapper;
import java.util.List;

@Mapper
public interface DeviceItemMapper extends BaseMapper<DeviceItem> {

    @Select("SELECT device_item.*,device_info.device_name,place.place_name FROM device_item LEFT JOIN device_info ON device_item.device_cate = device_info.id LEFT JOIN place ON device_item.install_location = place.id")
    List<DeviceItemVO> getDeviceItemVO(IPage page , QueryWrapper queryWrapper);
}
