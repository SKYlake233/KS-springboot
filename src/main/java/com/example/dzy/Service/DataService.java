package com.example.dzy.Service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dzy.Controller.VO.DeviceItemVO;
import com.example.dzy.Entity.Alarm;
import com.example.dzy.Entity.AlarmRule;
import com.example.dzy.Entity.Data;
import com.example.dzy.Mapper.AlarmMapper;
import com.example.dzy.Mapper.AlarmRuleMapper;
import com.example.dzy.Mapper.DataMapper;
import com.example.dzy.Mapper.DeviceItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DataService {

    @Autowired
    DataMapper dataMapper;

    @Autowired
    AlarmRuleMapper alarmRuleMapper;

    @Autowired
    DeviceItemMapper deviceItemMapper;

    @Autowired
    AlarmMapper alarmMapper;

    AlarmRule alarmRule = null;

    //进行数据的插入工作
    public void upload(Data data){
        dataMapper.insert(data);
    }

    //超过预定值 进行报警   将设备同地点中绑定
    public void check(Data data){
        if(alarmRule == null){
            alarmRule = alarmRuleMapper.getdata();
        }
        //执行规则    然后将超过的信息组合一个字符串
        java.util.List<DeviceItemVO> res =deviceItemMapper.getDeviceItemVO(null , new QueryWrapper<DeviceItemVO>().eq("device_item.id",data.getCollectDevice()));
        data.setCollectLocation(res.get(0).getInstallLocation());
        String alarmData = "";
        if (data.getTemperature() != null && data.getTemperature() > alarmRule.getTemperatrue())
            alarmData += "温度超标，数值为" + data.getTemperature();
        if (data.getHumidity() != null && data.getHumidity() > alarmRule.getHumidity())
            alarmData += "   湿度超标，数值为" + data.getHumidity();
        if (data.getPm25() != null && data.getPm25() > alarmRule.getPm25())
            alarmData += "   pm2.5超标，数值为" + data.getPm25();
        if (data.getCo() != null && data.getCo() > alarmRule.getCo())
            alarmData += "   CO超标，数值为" + data.getCo();
        if (data.getNo2() != null && data.getNo2() > alarmRule.getNo2())
            alarmData += "   NO2超标，数值为" + data.getNo2();
        if (data.getSo2() != null && data.getSo2() > alarmRule.getSo2())
            alarmData += "   SO2超标，数值为" + data.getSo2();
        if(!alarmData.equals("")){
            String time_t ="报警时间" + DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss");
            alarmData = time_t + alarmData;
            Alarm alarm = new Alarm();
            alarm.setDataIndex(alarmData);
            alarm.setIsRead(0);
            alarmMapper.insert(alarm);
        }
    }
}
