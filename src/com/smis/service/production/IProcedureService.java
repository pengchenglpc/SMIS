package com.smis.service.production;

import java.util.List;

import com.smis.model.production.Working;

import net.sf.json.JSONObject;

public interface IProcedureService {
	/**
	 * 工序责任统计分析
	 * @param comtinueNo
	 * @param working
	 * @return
	 */
	public List<JSONObject> statisticalAnalysis(String comtinueNo, String working);
	
	public List<Working> findAllWorking();
	
	public List<JSONObject> findProduceNo();
}
