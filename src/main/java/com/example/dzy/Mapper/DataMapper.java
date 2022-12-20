package com.example.dzy.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dzy.Controller.DataController;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataMapper extends BaseMapper<DataController> {
}
