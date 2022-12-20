package com.example.dzy.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dzy.Entity.AlarmRule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper
public interface AlarmRuleMapper extends BaseMapper<AlarmRule> {

    @Select("SELECT * FROM alarm_rule")
    public AlarmRule getdata();
}

