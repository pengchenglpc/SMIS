package com.smis.dao.production;

import java.util.List;

import com.smis.dao.base.IBaseDao;
import com.smis.model.production.ProducePlan;
import com.smis.model.production.ProducePlanPersonnel;

public interface IProcedureDao extends IBaseDao<ProducePlanPersonnel> {
	public List statisticalAnalysis(ProducePlan plan);
	
	public List deptAnalysis(ProducePlan plan);
	
	public List dutyCompare(ProducePlan plan);
}
