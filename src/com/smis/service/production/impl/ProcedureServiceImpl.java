package com.smis.service.production.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smis.dao.production.IProcedureDao;
import com.smis.dao.production.IProducePlanDao;
import com.smis.dao.production.IWorkingDao;
import com.smis.model.production.ProducePlan;
import com.smis.model.production.Working;
import com.smis.service.production.IProcedureService;

import net.sf.json.JSONObject;

@Service("procedureService")
public class ProcedureServiceImpl implements IProcedureService {

	@Autowired
	private IProcedureDao procedureDao;
	
	@Autowired
	private IWorkingDao workingDao;
	
	@Autowired
	private IProducePlanDao producePlanDao;
	
	@Override
	public List<JSONObject> statisticalAnalysis(ProducePlan plan) {
		List list = procedureDao.statisticalAnalysis(plan);
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
	@Override
	public List<Working> findAllWorking() {
		return this.workingDao.findAll();
	}
	@Override
	public List<JSONObject> findProduceNo() {
		List list = this.producePlanDao.findProduceNo();
		List<JSONObject> arr = new ArrayList<JSONObject>();
		for(Object o : list){
			JSONObject obj = new JSONObject();
			obj.put("name", o);
			arr.add(obj);
		}
		return arr;
	}
	@Override
	public List<JSONObject> findDept() {
		List list = this.producePlanDao.findDept();
		List<JSONObject> arr = new ArrayList<JSONObject>();
		for(Object o : list){
			JSONObject obj = new JSONObject();
			obj.put("name", o);
			arr.add(obj);
		}
		return arr;
	}
	@Override
	public List<JSONObject> deptAnalysis(ProducePlan plan) {
		List list = procedureDao.deptAnalysis(plan);
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
	@Override
	public Map<String, Object> dutyCompare(ProducePlan plan) {
		List list = procedureDao.dutyCompare(plan);
		Set<String> technology = new HashSet<String>();
		List<String> monthSet = new ArrayList<String>();
		List<JSONObject> arr = new ArrayList<JSONObject>();
		for(Object obj : list){
			Object[] datas = (Object[])obj;
			Long value = ((BigInteger)datas[0]).longValue();
			String name = (String)datas[1];
			Integer month = (Integer)datas[2];
			technology.add(name);
			JSONObject json = new JSONObject();
			json.put("value", value);
			json.put("name", name);
			json.put("month", month + "月");
			if(monthSet.indexOf(month + "月") < 0)
				monthSet.add(month + "月");
			arr.add(json);
		}
		Map<String, List> dataMap = new HashMap<String, List>();
		for(String tech : technology){
			List data = new ArrayList();
			for(String month : monthSet){
				System.out.println("month--------->" + month);
				boolean existFlag = false;
				for(JSONObject json : arr){
					if(month.equals(json.get("month")) && tech.equals(json.get("name"))){
						data.add(json.get("value"));
						existFlag = true;
						break;
					}
				}
				if(!existFlag){
					data.add(0);
				}
			}
			dataMap.put(tech, data);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", dataMap);
		map.put("month", monthSet);
		map.put("technology", technology);
		System.out.println(JSONObject.fromObject(map));
		
		return map;
	}

}
