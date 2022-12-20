package com.example.dzy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dzy.Controller.VO.DeviceItemVO;
import com.example.dzy.Mapper.DeviceItemMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class DzyApplicationTests {

    @Autowired
    DeviceItemMapper deviceItemMapper;

    @Test
    void contextLoads() {
        Page<DeviceItemVO> page = new Page<DeviceItemVO>();

        page.setCurrent(2);
        page.setSize(1);
        List<DeviceItemVO> res = deviceItemMapper.getDeviceItemVO(page, (new QueryWrapper<DeviceItemVO>()).like("id",""));
        System.out.printf(res.toString());
    }

}
