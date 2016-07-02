package com.ideal.spdb.education.service;

import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.education.model.EducationModel;
import com.ideal.spdb.utils.BaseService;

public interface IEducationService extends BaseService<EducationModel>{
	/**
	 * 根据
	 * @param application
	 * @return
	 */
	public EducationModel queryEducationRecordByAPPID(ApplicationModel application);
}
