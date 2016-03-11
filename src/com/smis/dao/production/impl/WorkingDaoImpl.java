package com.smis.dao.production.impl;

import org.springframework.stereotype.Repository;

import com.smis.dao.base.impl.BaseDaoImpl;
import com.smis.dao.production.IWorkingDao;
import com.smis.model.production.Working;

@Repository("workingDao")
public class WorkingDaoImpl extends BaseDaoImpl<Working> implements IWorkingDao {

}
