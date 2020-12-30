package com.bsth.busDataOperate.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bsth.busDataOperate.bean.LineChange;
import com.bsth.busDataOperate.bean.RoadLineStop;

@Mapper
public interface RoadLineStopMapper {
	 /**
     * 增加线路站点信息
     */
    public int insertRoadLineStop(RoadLineStop roadLineStop);
    
    /*
     * roadlinestop删除旧线路站级信息
     */
    public int deleteRoadLineStop(String RoadLine);
    
    /**将旧的线路站点添加到归档表*/
    public int insertRoadLineStopHistory(String RoadLine);
    

}
