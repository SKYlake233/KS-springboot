package com.example.dzy.Service;

import com.example.dzy.Mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    DataMapper dataMapper;

    //进行数据的插入工作
    public void upload(){

    }

    //超过预定值 进行报警
    public void check(){

    }
}
