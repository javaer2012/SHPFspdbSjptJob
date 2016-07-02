package com.ideal.spdb.datamanager.service.impl;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.datamanager.dao.ApplicationDao;
import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.datamanager.service.ApplicationService;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service("ApplicationService")
public class ApplicationServiceImpl extends BaseServiceImpl<ApplicationModel> implements ApplicationService {
	private static final Logger log = Logger.getLogger(ApplicationServiceImpl.class);

	@Inject
	private ApplicationDao dao;

	@Override
	public ApplicationModel queryApplicationInfoById(
			ApplicationModel application) {
		// TODO Auto-generated method stub
		return dao.queryApplicationInfoById(application);
	}
}
