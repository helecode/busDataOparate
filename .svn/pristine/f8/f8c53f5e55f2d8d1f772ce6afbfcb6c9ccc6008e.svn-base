package com.bsth.busDataOperate.service;

import java.util.List;

import com.bsth.busDataOperate.bean.LineChange;
import com.bsth.busDataOperate.bean.RoadLine;
import com.bsth.busDataOperate.bean.RoadLineStop;

public interface RoadLineStopService {
    /**
     * 增加线路站点信息
     */
    public int insertRoadLineStop(RoadLineStop lineChange);
    
    /**将旧的线路站点添加到归档表*/
    public int insertRoadLineStopHistory(String RoadLine);
   
    /*删除旧的线路站级数据**/
    public int deleteRoadLineStop(String RoadLine);
    
    /**将新的线路重新插入站级表*/
    public void insertNewRoadLineStop(List<String> RoadLines);
}
