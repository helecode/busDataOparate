package com.bsth.busDataOperate.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bsth.busDataOperate.bean.RoadStop;
@Mapper
public interface RoadStopMapper {
	/**
     * 新增站点信息
     */
    public int insertRoadStop(RoadStop roadStop);
}
