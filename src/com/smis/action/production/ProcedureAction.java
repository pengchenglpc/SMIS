package com.smis.action.production;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.smis.action.base.BaseAction;
import com.smis.model.production.ProducePlan;
import com.smis.service.production.IProcedureService;

import net.sf.json.JSONArray;

@Controller("procedureAction")
public class ProcedureAction extends BaseAction {
	
	private ProducePlan plan;
	@Autowired
	private IProcedureService procedureService;
	
	public void analysis() throws IOException{
		outJSON(JSONArray.fromObject(procedureService.statisticalAnalysis(plan.getComtinueNo(), plan.getWorking())));
	}
	
	public void working() throws IOException{
		outJSON(JSONArray.fromObject(procedureService.findAllWorking()));
	}
	
	public void produceNo() throws IOException{
		outJSON(JSONArray.fromObject(procedureService.findProduceNo()));
	}

	public ProducePlan getPlan() {
		return plan;
	}

	public void setPlan(ProducePlan plan) {
		this.plan = plan;
	}
	
	
}
