package com.bsth.busDataOperate.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bsth.busDataOperate.Mapper.RoadStopMapper;
import com.bsth.busDataOperate.bean.LineChange;
import com.bsth.busDataOperate.bean.RoadLine;
import com.bsth.busDataOperate.bean.RoadLineStop;
import com.bsth.busDataOperate.bean.RoadStop;
import com.bsth.busDataOperate.constant.Constant;
import com.bsth.busDataOperate.service.LineChangeService;
import com.bsth.busDataOperate.service.RoadLineStopService;
import com.bsth.busDataOperate.service.RoadStopService;
import com.bsth.busDataOperate.util.Md532;
import com.bsth.busDataOperate.util.RequestURL;
import com.fasterxml.jackson.databind.util.JSONPObject;


@Controller
public class RoadLineStopController {
	private static final Logger log = LoggerFactory.getLogger(RoadLineStopController.class);
	@Autowired
	private RoadLineStopService roadLineStopService;

	@RequestMapping("/PudongRoadLineStop")
	@ResponseBody
	public String PudongLineChange() {
		JSONObject json=RequestURL.getRequestURLResult(Constant.PudongRoadLineStop);
		JSONObject jsonReturn=new JSONObject();
		JSONObject jsonReturnValue=new JSONObject();
		
		if(json==null) {
			jsonReturnValue.put("code", 0);
			jsonReturnValue.put("msg", "URL返回结果为空");
			jsonReturn.put("result", jsonReturnValue);
			return jsonReturn.toJSONString();
		}
		JSONArray  jsonArray=json.getJSONObject("result").getJSONArray("data");
		int sum=0;
		  for (int i=0; i<jsonArray.size(); i++) { 
			  String RunCompany=jsonArray.getJSONObject(i).getString("RunCompany");
				if(!(RunCompany.equals("上南公交")||RunCompany.equals("金高公交")||RunCompany.equals("杨高公交")||RunCompany.equals("南汇公交"))) {
					continue;
				}
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
			  	//log.info("j:"+j+"\troadLineStop"+roadLineStop);
			  	roadLineStopService.insertRoadLineStop(roadLineStop);  	
			  	}
			  	sum=sum+roadLineStopJSONArray.size();
	        }
		 log.info("sum:"+"sum");
		 log.info("RoadLineStop入库成功");
		 jsonReturnValue.put("code", 1);
		 jsonReturnValue.put("msg", "RoadLineStop入库成功");
		 jsonReturn.put("result", jsonReturnValue);
	   return jsonReturn.toJSONString();
	}
}
