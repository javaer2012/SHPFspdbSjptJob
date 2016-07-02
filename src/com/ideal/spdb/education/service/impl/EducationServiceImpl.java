package com.ideal.spdb.education.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.education.dao.IEducationDao;
import com.ideal.spdb.education.model.EducationModel;
import com.ideal.spdb.education.service.IEducationService;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service("EducationService")
public class EducationServiceImpl extends BaseServiceImpl<EducationModel> implements IEducationService{
	
	@Inject
	private IEducationDao dao;
	
	@Override
	public EducationModel queryEducationRecordByAPPID(
			ApplicationModel application) {
		// TODO Auto-generated method stub
		return dao.queryEducationRecordByAPPID(application);
	}

}
