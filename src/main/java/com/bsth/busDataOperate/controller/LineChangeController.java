package com.bsth.busDataOperate.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.quartz.DisallowConcurrentExecution;
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
import com.bsth.busDataOperate.bean.LineChange;
import com.bsth.busDataOperate.bean.RoadLine;
import com.bsth.busDataOperate.bean.RoadStop;
import com.bsth.busDataOperate.constant.Constant;
import com.bsth.busDataOperate.service.LineChangeService;
import com.bsth.busDataOperate.service.RoadLineStopService;
import com.bsth.busDataOperate.service.RoadStopService;
import com.bsth.busDataOperate.util.Md532;
import com.bsth.busDataOperate.util.RequestURL;
import com.fasterxml.jackson.databind.util.JSONPObject;



@Controller
@EnableScheduling
@DisallowConcurrentExecution
public class LineChangeController {
	private static final Logger log = LoggerFactory.getLogger(LineChangeController.class);
	@Autowired
	private LineChangeService lineChangeService;
	@Autowired
	private RoadLineStopService roadLineStopService;
	@RequestMapping("/PudongLineChange")
	@ResponseBody
	public String PudongLineChange(){
		JSONObject json=RequestURL.getRequestURLResult(Constant.LineChange);
		JSONObject jsonReturn=new JSONObject();
		JSONObject jsonReturnValue=new JSONObject();
		
		if(json==null) {
			jsonReturnValue.put("code", 0);
			jsonReturnValue.put("msg", "URL返回结果为空");
			jsonReturn.put("result", jsonReturnValue);
			return jsonReturn.toJSONString();
		}
			
		JSONArray  jsonArray=json.getJSONObject("result").getJSONArray("data");
		  for (int i=0; i <jsonArray.size(); i++) {
			  	LineChange lineChange=new LineChange(); 
			  	RoadLine roadLine=new RoadLine();
			  	lineChange.setRoadLine(jsonArray.getJSONObject(i).getString("RoadLine"));
			  	try {
					lineChange.setChangeDate(new SimpleDateFormat("yyyy-MM-dd").parse(jsonArray.getJSONObject(i).getString("ChangeDate")));
				} catch (ParseException e) {
					log.info("data格式错误，应为yyyy-MM-dd");
					e.printStackTrace();
				}
			  //	System.out.println("i:"+i+"\tlineChnange:"+lineChange);
			  	lineChangeService.insertRoadChange(lineChange);
	        }
		  	log.info("size:"+jsonArray.size());
			jsonReturnValue.put("code", 1);
			jsonReturnValue.put("msg", "LineChange入库成功");
			jsonReturn.put("result", jsonReturnValue);
		  return jsonReturn.toJSONString();
	}
	//lineChange更新
	@RequestMapping("/PudongLineChangeUpdate")
	@ResponseBody
	@Scheduled(cron = "${cron.timer}")	
	public String PudongLineChangeUpdate(){
		JSONObject json=RequestURL.getRequestURLResult(Constant.LineChange);
		JSONObject jsonReturn=new JSONObject();
		JSONObject jsonReturnValue=new JSONObject();
		
		if(json==null) {
			jsonReturnValue.put("code", 0);
			jsonReturnValue.put("msg", "URL返回结果为空");
			jsonReturn.put("result", jsonReturnValue);
			return jsonReturn.toJSONString();
		}
		List<String> RoadLines=new ArrayList<String>();
		JSONArray  jsonArray=json.getJSONObject("result").getJSONArray("data");
		  for (int i=0; i <jsonArray.size(); i++) {
			  	LineChange lineChange=new LineChange(); 
			  	RoadLine roadLine=new RoadLine();
			  	lineChange.setRoadLine(jsonArray.getJSONObject(i).getString("RoadLine"));
			  	try {
					lineChange.setChangeDate(new SimpleDateFormat("yyyy-MM-dd").parse(jsonArray.getJSONObject(i).getString("ChangeDate")));
				} catch (ParseException e) {
					log.info("data格式错误，应为yyyy-MM-dd");
					e.printStackTrace();
				}
			  	Calendar calendar = Calendar.getInstance();  //得到日历
				calendar.setTime(new Date());//把当前时间赋给日历
				calendar.add(Calendar.DATE, -5);  //设置为5天前
				Date beforedays = calendar.getTime();   //得到5天前的时间
				if(lineChange.getChangeDate().getTime()<beforedays.getTime()) {//判断该时间是否为5天内的时间
					continue;
				}
			  	if(lineChangeService.selectRoadChange(lineChange)!=0) {//判断linechange是否存在该条变更记录
			  		continue;
				}
			  	log.info("i:"+i+"\tlineChnange:"+lineChange);
			  	lineChangeService.insertRoadChange(lineChange);
			  	log.info("更新RoadChange");
			  	roadLineStopService.insertRoadLineStopHistory(lineChange.getRoadLine());
			  	log.info("更新RoadLineStopHistory");
			  	roadLineStopService.deleteRoadLineStop(lineChange.getRoadLine());
			  	log.info("删除旧数据RoadLineStop");
			  	RoadLines.add(lineChange.getRoadLine()); 	
	        }
		    log.info("RoadLines:"+RoadLines.size()+"\t"+RoadLines);
		    if(RoadLines.size()>0) {
			roadLineStopService.insertNewRoadLineStop(RoadLines);
			log.info("增加新数据RoadLineStop");
		    }
			jsonReturnValue.put("code", 1);
			jsonReturnValue.put("msg", "LineChange更新成功");
			jsonReturn.put("result", jsonReturnValue);
		  return jsonReturn.toJSONString();
	}
}
