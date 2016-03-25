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

	@Override
	public List deptAnalysis(ProducePlan plan) {
		StringBuilder query = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();
		query.append("SELECT count(plan.working), plan.working from ProducePlan plan, ProducePlanPersonnel sonnel where 1=1");
		query.append(" and plan.productNo=sonnel.productPersonnelNo and sonnel.personnelMemo != '' and plan.comFlag=:comFlag");
		if(plan != null){
			if(!StringUtils.isEmpty(plan.getDepartment())){
				query.append(" and plan.department=:department");
				param.put("department", plan.getDepartment());
			}
			if(!StringUtils.isEmpty(plan.getComtinueNo())){
				query.append(" and plan.comtinueNo=:comtinueNo");
				param.put("comtinueNo", plan.getComtinueNo());
			}
			if(plan.getStartDate() != null && plan.getEndDate() != null){
				query.append(" and plan.producePlanDate >=:startDate and plan.producePlanDate <=:endDate");
				param.put("startDate", plan.getStartDate());
				param.put("endDate", plan.getEndDate());
			}
		}
		query.append(" group by plan.working");
		param.put("comFlag", "已审核");
		List list = this.findQueryNoCast(query.toString(), param);
		return list;
	}

	@Override
	public List dutyCompare(ProducePlan plan) {
		StringBuilder query = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();
		if(0==plan.getWay()){
			query.append("SELECT count(plan.working), plan.working, MONTH(producePlanDate) _month from ProducePlan plan, ProducePlanPersonnel sonnel where 1=1 ");
		}else if(1==plan.getWay()){
			query.append("SELECT count(sonnel.personnelMemo), sonnel.personnelMemo, MONTH(producePlanDate) _month from ProducePlan plan, ProducePlanPersonnel sonnel where 1=1 ");
		}
		query.append(" and  plan.productNo=sonnel.productPersonnelNo and sonnel.personnelMemo != '' and plan.comFlag=:comFlag");
		if(!StringUtils.isEmpty(plan.getDepartment())){
			query.append(" and plan.department=:department");
			param.put("department", plan.getDepartment());
		}
		if(!StringUtils.isEmpty(plan.getComtinueNo())){
			query.append(" and plan.comtinueNo=:comtinueNo");
			param.put("comtinueNo", plan.getComtinueNo());
		}
		if(!StringUtils.isEmpty(plan.getYear())){
			query.append(" and YEAR(producePlanDate)=:year");
			param.put("year", plan.getYear());
		}
		if(!StringUtils.isEmpty(plan.getQuarter())){
			query.append(" and MONTH(producePlanDate)>=:minMonth and MONTH(producePlanDate)<=:maxMonth");
			String minMonth = "",
					maxMonth = "";
			if("1".equals(plan.getQuarter())){
				minMonth = "1";
				maxMonth = "3";
			}else if("2".equals(plan.getQuarter())){
				minMonth = "4";
				maxMonth = "6";
			}else if("3".equals(plan.getQuarter())){
				minMonth = "7";
				maxMonth = "9";
			}else if("4".equals(plan.getQuarter())){
				minMonth = "10";
				maxMonth = "12";
			}
			param.put("minMonth", minMonth);
			param.put("maxMonth", maxMonth);
		}
		if(0==plan.getWay()){
			query.append(" group by plan.working, _month order by _month asc");
		}else if(1==plan.getWay()){
			query.append(" group by sonnel.personnelMemo, _month order by _month asc");
		}
		param.put("comFlag", "已审核");
		
		List list = this.findNativeQuery(query.toString(), param);
		return list;
	}
	
}
