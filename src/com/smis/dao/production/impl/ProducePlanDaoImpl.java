package com.smis.dao.production.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.smis.dao.base.impl.BaseDaoImpl;
import com.smis.dao.production.IProducePlanDao;
import com.smis.model.production.ProducePlan;

@Repository("producePlanDao")
public class ProducePlanDaoImpl extends BaseDaoImpl<ProducePlan> implements IProducePlanDao {

	@Override
	public List findProduceNo() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT distinct comtinueNo from ProducePlan where comFlag='已审核'");
		return this.findQueryNoCast(query.toString(), null);
	}


}
