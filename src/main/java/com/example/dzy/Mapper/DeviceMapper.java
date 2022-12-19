package com.example.dzy.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dzy.Entity.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceMapper extends BaseMapper<DeviceInfo> {
}
