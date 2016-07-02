package com.ideal.spdb.education.dao;

import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.education.model.EducationModel;
import com.ideal.spdb.utils.BaseDao;

public interface IEducationDao extends BaseDao<EducationModel>{
	/**
	 * 根据
	 * @param application
	 * @return
	 */
	public EducationModel queryEducationRecordByAPPID(ApplicationModel application);
}
