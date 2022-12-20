package com.example.dzy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dzy.Controller.VO.DeviceItemVO;
import com.example.dzy.Controller.VO.MapInfo;
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
    DeviceItemService deviceItemService;

    @Test
    void contextLoads() {
        List<com.example.dzy.Controller.VO.MapInfoVO> res = deviceItemService.getMapInfo();
        System.out.printf(res.toString());
    }

}
