package com.example.dzy.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dzy.Controller.VO.DeviceItemVO;
import com.example.dzy.Entity.AlarmRule;
import com.example.dzy.Entity.Data;
import com.example.dzy.Mapper.AlarmRuleMapper;
import com.example.dzy.Mapper.DataMapper;
import com.example.dzy.Mapper.DeviceItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    DataMapper dataMapper;

    @Autowired
    AlarmRuleMapper alarmRuleMapper;

    @Autowired
    DeviceItemMapper deviceItemMapper;

    AlarmRule alarmRule = null;

    //进行数据的插入工作
    public void upload(Data data){
        dataMapper.insert(data);
    }

    //超过预定值 进行报警   将设备同地点中绑定
    public void check(Data data){
        if(alarmRule == null){
            alarmRule = AlarmRule.getAlarmRule();
        }
        //执行规则    然后将超过的信息组合一个字符串
        java.util.List<DeviceItemVO> res =deviceItemMapper.getDeviceItemVO(null , new QueryWrapper<DeviceItemVO>().eq("device_item.id",data.getCollectDevice()));
        data.setCollectLocation(res.get(0).getInstallLocation());
        dataMapper.insert(data);
    }
}
