package com.bsth.busDataOperate.service;

import java.util.List;

import com.bsth.busDataOperate.bean.LineChange;
import com.bsth.busDataOperate.bean.RoadLine;


public interface LineChangeService {
    /**
     * 增加线路改变信息
     */
    public int insertRoadChange(LineChange lineChange);
    
    /**
     * 通过线路名和更新时间查找
     */
    
    public int selectRoadChange(LineChange lineChange);
}
