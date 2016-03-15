package com.smis.dao.production;

import java.util.List;

import com.smis.dao.base.IBaseDao;
import com.smis.model.production.ProducePlan;

public interface IProducePlanDao extends IBaseDao<ProducePlan> {
	public List findProduceNo();
	public List findDept();
}
