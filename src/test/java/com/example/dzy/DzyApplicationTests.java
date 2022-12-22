package com.example.dzy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dzy.Controller.VO.DeviceItemVO;
import com.example.dzy.Controller.VO.LatestDataVO;
import com.example.dzy.Controller.VO.MapInfo;
import com.example.dzy.Entity.AlarmRule;
import com.example.dzy.Mapper.AlarmRuleMapper;
import com.example.dzy.Mapper.DataMapper;
import com.example.dzy.Mapper.DeviceItemMapper;
import com.example.dzy.Service.DeviceItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class DzyApplicationTests {

    @Autowired
    DataMapper dataMapper;

    @Test
    void contextLoads() {
        List<LatestDataVO> res = dataMapper.getLatestDataVO();
        System.out.println(res.toString());
    }

}
