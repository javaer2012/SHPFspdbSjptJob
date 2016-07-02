package com.ideal.spdb.datamanager.dao.impl;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.datamanager.dao.ApplicationDao;
import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository("ApplicationDao")
public class ApplicationDaoImpl extends BaseDaoImpl<ApplicationModel> implements ApplicationDao {

	@Override
	public ApplicationModel queryApplicationInfoById(
			ApplicationModel application) {
		// TODO Auto-generated method stub
		return (ApplicationModel) this.getSqlSession().selectOne("ApplicationMapper.queryApplicationInfoById",application);
	}

}
