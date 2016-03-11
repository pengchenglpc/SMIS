package com.smis.dao.production;

import java.util.List;

import com.smis.dao.base.IBaseDao;
import com.smis.model.production.ProducePlanPersonnel;

public interface IProcedureDao extends IBaseDao<ProducePlanPersonnel> {
	public List statisticalAnalysis(String comtinueNo, String working);
}
