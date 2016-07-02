package com.ideal.spdb.education.dao.impl;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.education.dao.IEducationDao;
import com.ideal.spdb.education.model.EducationModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository("EducationDao")
public class EducationDaoImpl extends BaseDaoImpl<EducationModel> implements IEducationDao{

	@Override
	public EducationModel queryEducationRecordByAPPID(
			ApplicationModel application) {
		// TODO Auto-generated method stub
		return (EducationModel) super.getSqlSession().selectOne("education.queryEducationRecordByAPPID", application);
	}

}
