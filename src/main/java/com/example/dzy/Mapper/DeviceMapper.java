package com.example.dzy.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dzy.Entity.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DeviceMapper extends BaseMapper<DeviceInfo> {
    default int getLife(long deviceCate){
        DeviceInfo deviceInfo = selectById(deviceCate);
        return (int) deviceInfo.getDeviceLife();
    }

    @Update("UPDATE device_info SET device_info.device_left = device_left - 1 WHERE device_info.id = #{id}")
    void modify(@Param("id")Integer deviceCate);
}
