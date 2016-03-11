package com.smis.action.production;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.smis.action.base.BaseAction;
import com.smis.service.production.IProcedureService;

import net.sf.json.JSONArray;

@Controller("procedureAction")
public class ProcedureAction extends BaseAction {
	@Autowired
	private IProcedureService procedureService;
	public void analysis() throws IOException{
		outJSON(JSONArray.fromObject(procedureService.statisticalAnalysis("PM201509-0002", "热压成型")));
	}
}
