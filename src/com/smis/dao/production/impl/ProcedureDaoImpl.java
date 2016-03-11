package com.smis.dao.production.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.smis.dao.base.impl.BaseDaoImpl;
import com.smis.dao.production.IProcedureDao;
import com.smis.model.production.ProducePlanPersonnel;

@Repository("procedureDao")
public class ProcedureDaoImpl extends BaseDaoImpl<ProducePlanPersonnel> implements IProcedureDao {

	@Override
	public List statisticalAnalysis(String comtinueNo, String working) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT count(sonnel.personnelMemo), sonnel.personnelMemo from ProducePlan plan, ProducePlanPersonnel sonnel where 1=1");
		query.append(" and plan.productNo=sonnel.productPersonnelNo and sonnel.personnelMemo != ''");
		query.append(" and plan.comtinueNo=:comtinueNo and plan.working=:working");
		query.append(" group by sonnel.personnelMemo");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("comtinueNo", comtinueNo);
		param.put("working", working);
		List list = this.findQueryNoCast(query.toString(), param);
		return list;
	}
	
}
