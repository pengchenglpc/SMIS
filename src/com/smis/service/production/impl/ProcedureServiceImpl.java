package com.smis.service.production.impl;

import java.util.ArrayList;
import java.util.List;

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

}
