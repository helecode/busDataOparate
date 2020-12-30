package com.bsth.busDataOperate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsth.busDataOperate.Mapper.RoadStopMapper;
import com.bsth.busDataOperate.bean.RoadStop;
import com.bsth.busDataOperate.service.RoadStopService;
@Service
public class RoadStopServiceImpl implements RoadStopService{
	@Autowired
	public RoadStopMapper roadStopMapper;

	@Override
	public int insertRoadStop(RoadStop roadStop) {
		return roadStopMapper.insertRoadStop(roadStop);
	}

	

}
