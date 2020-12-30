package com.bsth.busDataOperate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bsth.busDataOperate.Mapper.RoadLineStopMapper;
import com.bsth.busDataOperate.Mapper.RoadStopMapper;
import com.bsth.busDataOperate.bean.RoadLine;
import com.bsth.busDataOperate.bean.RoadLineStop;
import com.bsth.busDataOperate.bean.RoadStop;
import com.bsth.busDataOperate.constant.Constant;
import com.bsth.busDataOperate.service.RoadLineStopService;
import com.bsth.busDataOperate.service.RoadStopService;
import com.bsth.busDataOperate.util.RequestURL;
@Service
public class RoadLineStopServiceImpl implements RoadLineStopService{
	@Autowired
	public RoadLineStopMapper roadLineStopMapper;

	@Override
	public int insertRoadLineStop(RoadLineStop roadLineStop) {
		// TODO Auto-generated method stub
		return roadLineStopMapper.insertRoadLineStop(roadLineStop);
	}

	@Override
	public int insertRoadLineStopHistory(String RoadLine) {
		// TODO Auto-generated method stub
		return roadLineStopMapper.insertRoadLineStopHistory(RoadLine);
	}

	@Override
	public void insertNewRoadLineStop(List<String> RoadLines) {
		JSONObject json=RequestURL.getRequestURLResult(Constant.PudongRoadLineStop);;
		JSONArray  jsonArray=json.getJSONObject("result").getJSONArray("data");
		  for (int i=0; i<jsonArray.size(); i++) { 
			  String RunCompany=jsonArray.getJSONObject(i).getString("RunCompany");
				if(!(RunCompany.equals("上南公交")||RunCompany.equals("金高公交")||RunCompany.equals("杨高公交")||RunCompany.equals("南汇公交"))) {
					continue;
				}
				if(!RoadLines.contains(jsonArray.getJSONObject(i).getString("RoadLine"))) {
					continue;
				}
				System.out.println("jsonArray.getJSONObject(i).getString(\"RoadLine\"):"+jsonArray.getJSONObject(i).getString("RoadLine"));
			  	JSONArray roadLineStopJSONArray=jsonArray.getJSONObject(i).getJSONArray("listdata");
			  	for(int j=0;j<roadLineStopJSONArray.size();j++) {
			  	RoadLineStop roadLineStop=new RoadLineStop(); 	
			  	roadLineStop.setRoadLine(new RoadLine(roadLineStopJSONArray.getJSONObject(j).getString("RoadLine")));
			  	roadLineStop.setLineStandardCode(jsonArray.getJSONObject(i).getString("LineStandardCode"));
			  	roadLineStop.setStationStandardCode(new RoadStop(roadLineStopJSONArray.getJSONObject(j).getString("StationStandardCode")));
			  	roadLineStop.setStationName(roadLineStopJSONArray.getJSONObject(j).getString("StationName"));
			  	roadLineStop.setLevelName(roadLineStopJSONArray.getJSONObject(j).getString("LevelName"));
			  	roadLineStop.setUpStream(roadLineStopJSONArray.getJSONObject(j).getBoolean("UpStream"));
			  	roadLineStop.setPathDirection(roadLineStopJSONArray.getJSONObject(j).getString("PathDirection"));
			  	String LevelId=roadLineStopJSONArray.getJSONObject(j).getString("LevelId");
			  	roadLineStop.setLevelId(LevelId);
			  	if(LevelId.equals("1")) {
			  		roadLineStop.setStationType("B");
			  	}else if(LevelId.equals(String.valueOf(roadLineStopJSONArray.size()))) {
			  		roadLineStop.setStationType("E");
			  	}else {
			  		roadLineStop.setStationType("Z");
			  	}
			  	//System.out.println("roadLineStop:"+roadLineStop);
			  	insertRoadLineStop(roadLineStop);  	
			  	}
			  	
			  	
	        }
	}

	@Override
	public int deleteRoadLineStop(String RoadLine) {
		// TODO Auto-generated method stub
		return roadLineStopMapper.deleteRoadLineStop(RoadLine);
	}

	

}
