package com.example.dzy.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dzy.Controller.VO.LatestDataVO;
import com.example.dzy.Entity.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataMapper extends BaseMapper<Data> {
    /*  根据id分组最近数据  ===>>>>>  最新数据
    SELECT
    place.*,
    ROUND( AVG( `data`.temperature ), 2 ) AS temperature,
    ROUND( AVG( `data`.humidity ), 2 ) AS humidity,
    ROUND( AVG( `data`.CO ), 2 ) AS CO,
    ROUND( AVG( `data`.NO2 ), 2 ) AS NO2,
    ROUND( AVG( `data`.PM25 ), 2 ) AS PM25,
    ROUND( AVG( `data`.SO2 ), 2 ) AS SO2
    FROM
            DATA,
            place
    WHERE
    place.id = `data`.collect_location
    AND `data`.collect_time >= CURRENT_TIMESTAMP - INTERVAL 10 MINUTE
    GROUP BY
	`data`.collect_location
	*/
    @Select("SELECT place.*,ROUND(AVG(`data`.temperature) , 2) AS temperature,ROUND(AVG(`data`.humidity) , 2) AS humidity,ROUND(AVG(`data`.CO) , 2) AS CO,ROUND(AVG(`data`.NO2) , 2) AS NO2,ROUND(AVG(`data`.PM25) , 2) AS PM25,ROUND(AVG(`data`.SO2) , 2) AS SO2 from data,place WHERE place.id = `data`.collect_location AND `data`.collect_time >= CURRENT_TIMESTAMP - INTERVAL 10 MINUTE GROUP BY `data`.collect_location")
    public List<LatestDataVO> getLatestDataVO();
}
