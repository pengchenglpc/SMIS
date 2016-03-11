package com.smis.service.production;

import java.util.List;

import net.sf.json.JSONObject;

public interface IProcedureService {
	public List<JSONObject> statisticalAnalysis(String comtinueNo, String working);
}
