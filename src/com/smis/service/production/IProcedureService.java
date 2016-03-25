package com.smis.service.production;

import java.util.List;
import java.util.Map;

import com.smis.model.production.ProducePlan;
import com.smis.model.production.Working;

import net.sf.json.JSONObject;

public interface IProcedureService {
	/**
	 * 工序责任统计分析
	 * @param comtinueNo
	 * @param working
	 * @return
	 */
	public List<JSONObject> statisticalAnalysis(ProducePlan plan);
	
	public List<JSONObject> deptAnalysis(ProducePlan plan);
	
	public List<Working> findAllWorking();
	
	public List<JSONObject> findProduceNo();
	
	public List<JSONObject> findDept();
	
	public Map<String, Object> dutyCompare(ProducePlan plan);
}
