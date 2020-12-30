package com.bsth.busDataOperate.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bsth.busDataOperate.Mapper.RoadStopMapper;
import com.bsth.busDataOperate.bean.RoadStop;
import com.bsth.busDataOperate.constant.Constant;
import com.bsth.busDataOperate.service.RoadStopService;
import com.bsth.busDataOperate.util.Md532;
import com.bsth.busDataOperate.util.RequestURL;
import com.fasterxml.jackson.databind.util.JSONPObject;


@Controller
public class RoadStopController {
	private static final Logger log = LoggerFactory.getLogger(RoadLineStopController.class);
	@Autowired
	public RoadStopService roadStopService;

	@RequestMapping("/PudongRoadStop")
	@ResponseBody
	
	public String PudongRoadStop() {
		JSONObject json=RequestURL.getRequestURLResult(Constant.PudongRoadStop);
		JSONObject jsonReturn=new JSONObject();
		JSONObject jsonReturnValue=new JSONObject();
		
		if(json==null) {
			jsonReturnValue.put("code", 0);
			jsonReturnValue.put("msg", "URL返回结果为空");
			jsonReturn.put("result", jsonReturnValue);
			return jsonReturn.toJSONString();
		}
		JSONArray  jsonArray=json.getJSONObject("result").getJSONArray("data");
		  for (int i = 0; i < jsonArray.size(); i++) {
			  	RoadStop roadStop=new RoadStop();
			  	roadStop.setStopId(jsonArray.getJSONObject(i).getString("StopId"));
	            roadStop.setStationStandardCode(jsonArray.getJSONObject(i).getString("StationStandardCode"));
	            roadStop.setArea(jsonArray.getJSONObject(i).getString("Area"));
	            roadStop.setDistrict(jsonArray.getJSONObject(i).getString("District"));
	            roadStop.setQuyu(jsonArray.getJSONObject(i).getString("Quyu"));
	            roadStop.setRoadName(jsonArray.getJSONObject(i).getString("RoadName"));
	            roadStop.setStationName(jsonArray.getJSONObject(i).getString("StationName"));
	            roadStop.setPathDirection(jsonArray.getJSONObject(i).getString("PathDirection"));
	            roadStop.setStationAddress(jsonArray.getJSONObject(i).getString("StationAddress"));
	            roadStop.setStopType(jsonArray.getJSONObject(i).getString("StopType"));
	            roadStop.setLineList(jsonArray.getJSONObject(i).getString("LineList"));
	            roadStop.setStopState(jsonArray.getJSONObject(i).getString("StopState"));
	            roadStop.setSidewalkWidth(jsonArray.getJSONObject(i).getString("SidewalkWidth"));
	            roadStop.setAfterCondition(jsonArray.getJSONObject(i).getString("AfterCondition"));
	            roadStop.setSurfaceProperty(jsonArray.getJSONObject(i).getString("SurfaceProperty"));
	            roadStop.setIsMainRoad(jsonArray.getJSONObject(i).getInteger("IsMainRoad"));
	            roadStop.setLandmark(jsonArray.getJSONObject(i).getString("Landmark"));
	            roadStop.setRideMetroRoadName(jsonArray.getJSONObject(i).getString("RideMetroRoadName"));
	            roadStop.setTransporthub(jsonArray.getJSONObject(i).getString("Transporthub"));
	            roadStop.setCityCoordinate(jsonArray.getJSONObject(i).getString("CityCoordinate"));
	            roadStop.setUpDataTime(jsonArray.getJSONObject(i).getString("UpDataTime"));
	            roadStopService.insertRoadStop(roadStop);
	        }
		  	log.info("size:"+jsonArray.size());
		  	log.info("RoadStop入库成功");
		  	jsonReturnValue.put("code", 1);
			jsonReturnValue.put("msg", "RoadStop入库成功");
			jsonReturn.put("result", jsonReturnValue);
		return jsonReturn.toJSONString();
	}
}
