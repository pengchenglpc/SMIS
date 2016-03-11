package com.smis.service.production.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smis.dao.production.IProcedureDao;
import com.smis.service.production.IProcedureService;

import net.sf.json.JSONObject;

@Service("procedureService")
public class ProcedureServiceImpl implements IProcedureService {

	@Autowired
	private IProcedureDao procedureDao;
	@Override
	public List<JSONObject> statisticalAnalysis(String comtinueNo, String working) {
		List list = procedureDao.statisticalAnalysis(comtinueNo, working);
		List<JSONObject> arr = new ArrayList<JSONObject>();
		for(Object obj : list){
			Object[] _arr = (Object[])obj;
			Long value = (Long)_arr[0];
			String name = (String)_arr[1];
			JSONObject json = new JSONObject();
			json.put("value", value);
			json.put("name", name);
			arr.add(json);
		}
		return arr;
	}

}
