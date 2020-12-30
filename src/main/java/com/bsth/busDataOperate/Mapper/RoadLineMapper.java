package com.bsth.busDataOperate.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bsth.busDataOperate.bean.RoadLine;
import com.bsth.busDataOperate.bean.RoadStop;
@Mapper
public interface RoadLineMapper {
    /**
     * 增加线路信息
     */
    public int insertRoadLine(RoadLine roadLine);
}
