package com.bsth.busDataOperate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsth.busDataOperate.Mapper.LineChangeMapper;
import com.bsth.busDataOperate.bean.LineChange;
import com.bsth.busDataOperate.service.LineChangeService;

@Service
public class LineChangeImpl implements LineChangeService{
	@Autowired
	private LineChangeMapper lineChangeMapper ;

	@Override
	public int insertRoadChange(LineChange lineChange) {
		// TODO Auto-generated method stub
		return lineChangeMapper.insertRoadChange(lineChange);
	}

	@Override
	public int selectRoadChange(LineChange lineChange) {
		// TODO Auto-generated method stub
		return lineChangeMapper.selectRoadChange(lineChange).size();
	}



	


	

}
