package com.smis.dao.production.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.smis.dao.base.impl.BaseDaoImpl;
import com.smis.dao.production.IProcedureDao;
import com.smis.model.production.ProducePlan;
import com.smis.model.production.ProducePlanPersonnel;

@Repository("procedureDao")
public class ProcedureDaoImpl extends BaseDaoImpl<ProducePlanPersonnel> implements IProcedureDao {

	@Override
	public List statisticalAnalysis(ProducePlan plan) {
		StringBuilder query = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();
		query.append("SELECT count(sonnel.personnelMemo), sonnel.personnelMemo from ProducePlan plan, ProducePlanPersonnel sonnel where 1=1");
		query.append(" and plan.productNo=sonnel.productPersonnelNo and sonnel.personnelMemo != '' and plan.comFlag=:comFlag");
		//query.append(" and plan.comtinueNo=:comtinueNo and plan.working=:working ");
		if(plan != null){
			if(!StringUtils.isEmpty(plan.getComtinueNo())){
				query.append(" and plan.comtinueNo=:comtinueNo");
				param.put("comtinueNo", plan.getComtinueNo());
			}
			if(!StringUtils.isEmpty(plan.getWorking())){
				query.append(" and plan.working=:working");
				param.put("working", plan.getWorking());
			}
			if(!StringUtils.isEmpty(plan.getDepartment())){
				query.append(" and plan.department=:department");
				param.put("department", plan.getDepartment());
			}
			if(plan.getStartDate() != null && plan.getEndDate() != null){
				query.append(" and plan.producePlanDate >=:startDate and plan.producePlanDate <=:endDate");
				param.put("startDate", plan.getStartDate());
				param.put("endDate", plan.getEndDate());
			}
		}
		query.append(" group by sonnel.personnelMemo");
		param.put("comFlag", "已审核");
		List list = this.findQueryNoCast(query.toString(), param);
		return list;
	}
	
}
