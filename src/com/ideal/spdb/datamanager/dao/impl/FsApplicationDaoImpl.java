package com.ideal.spdb.datamanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.datamanager.dao.FsApplicationDao;
import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.datamanager.model.FsApplicationModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository("FsApplicationDao")
public class FsApplicationDaoImpl extends BaseDaoImpl<FsApplicationModel> implements FsApplicationDao {

	@Override
	public List<FsApplicationModel> queryFSApplicationByAPPID(
			ApplicationModel application) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("FsApplicationMapper.queryFSApplicationByAPPID", application);
	}

}
