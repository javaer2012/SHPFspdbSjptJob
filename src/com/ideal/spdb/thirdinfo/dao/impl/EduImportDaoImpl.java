package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.IEduImportDao;
import com.ideal.spdb.thirdinfo.model.EduImportModel;
import com.ideal.spdb.utils.BaseDaoImpl;
@Repository
public class EduImportDaoImpl extends BaseDaoImpl<EduImportModel> implements IEduImportDao{

	@Override
	public void insertOrUpdate(List<EduImportModel> datalist) {
		for(EduImportModel e:datalist){
			this.getSqlSession().update("eduimport.insertOrUpdateAPP",e);
		}
	}

	@Override
	public void initProcess(List<EduImportModel> datalist) {
		for(EduImportModel e:datalist){
			this.getSqlSession().update("eduimport.initProcess",e);
		}
	}

}
