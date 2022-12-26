package com.example.dzy.Service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dzy.Controller.VO.DeviceItemVO;
import com.example.dzy.Controller.VO.LastMonthDataVO;
import com.example.dzy.Controller.VO.LastWeekDataVO;
import com.example.dzy.Controller.VO.LatestDataVO;
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
import java.util.List;

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

        if (data.getTemperature() != null && data.getTemperature() > alarmRule.getTemperature())
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

    public LastWeekDataVO getHistoryWeekData(int place_id) {
        //先通过mapper返回数据
        List<LatestDataVO> lastWeekData = dataMapper.getLastWeekDataVO(place_id);
        LastWeekDataVO lastWeekDataVO = new LastWeekDataVO();
        lastWeekDataVO.setInstall_location(lastWeekData.get(0).getPlaceName());
        for (int i = 0 ; i < 7 ; i++){
            lastWeekDataVO.getTemperature().add(lastWeekData.get(i).getTemperature());
            lastWeekDataVO.getHumidity().add(lastWeekData.get(i).getHumidity());
            lastWeekDataVO.getCo().add(lastWeekData.get(i).getCo());
            lastWeekDataVO.getSo2().add(lastWeekData.get(i).getSo2());
            lastWeekDataVO.getPm25().add(lastWeekData.get(i).getPm25());
            lastWeekDataVO.getNo2().add(lastWeekData.get(i).getNo2());
        }
        return lastWeekDataVO;
    }

    public LastMonthDataVO getHistoryMonthData(int place_id) {
        //先通过mapper返回数据
        List<LatestDataVO> lastMonthData = dataMapper.getLastMonthDataVO(place_id);
        LastMonthDataVO lastMonthDataVO = new LastMonthDataVO();
        lastMonthDataVO.setInstall_location(lastMonthData.get(0).getPlaceName());
        for (int i = 0 ; i < 4 ; i++){
            lastMonthDataVO.getTemperature().add(lastMonthData.get(i).getTemperature());
            lastMonthDataVO.getHumidity().add(lastMonthData.get(i).getHumidity());
            lastMonthDataVO.getCo().add(lastMonthData.get(i).getCo());
            lastMonthDataVO.getSo2().add(lastMonthData.get(i).getSo2());
            lastMonthDataVO.getPm25().add(lastMonthData.get(i).getPm25());
            lastMonthDataVO.getNo2().add(lastMonthData.get(i).getNo2());
        }
        return lastMonthDataVO;
    }
}
