package com.bsth.busDataOperate.util;
//发起url请求得到返回结果并转换成json对象

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

import com.alibaba.fastjson.JSONObject;
import com.bsth.busDataOperate.constant.Constant;

public class RequestURL {
	public static JSONObject getRequestURLResult(String info) {
		//获取当前日期并指定格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString=sdf.format(new Date());
		String uidParam1="uid="+Constant.username+"_"+dateString;
		String pwdParam2="pwd="+Md532.md532encryption(Constant.username+dateString+Constant.password);
		String appidParam3="appid="+Constant.appid;
		String url=Constant.prefix+info+Constant.suffix+"?"+uidParam1+"&"+pwdParam2+"&"+appidParam3;
		System.out.println("url:"+url);
		//发起url请求并得到返回结果
		URL realUrl=null;
		URLConnection connection=null;
		BufferedReader bufferedReader=null;
		String line = "";
		String result="";
		try {
			realUrl = new URL(url);
			connection=realUrl.openConnection();
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			connection.connect();
		bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
		while(null != (line = bufferedReader.readLine())) {
			result += line;
		}
		if(bufferedReader!=null)bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jsonObject=resultFormatJSON(result);
		String msg=jsonObject.getJSONObject("result").getString("msg");
		System.out.println("msg:"+msg);
		if(msg.contains("成功"))
			return resultFormatJSON(result);
		return null;
	}
	//将json格式的字符串转换为json对象
	public static JSONObject resultFormatJSON(String result) {
		JSONObject jsonResult=JSONObject.parseObject(result);
		return jsonResult;
		
	}
	
}
