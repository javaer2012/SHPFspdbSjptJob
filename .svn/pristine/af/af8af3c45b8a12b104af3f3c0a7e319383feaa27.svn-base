package com.ideal.spdb.datamanager.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.datamanager.dao.FsApplicationDao;
import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.datamanager.model.FsApplicationModel;
import com.ideal.spdb.datamanager.service.FsApplicationService;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service("FsApplicationService")
public class FsApplicationServiceImpl extends BaseServiceImpl<FsApplicationModel> implements FsApplicationService {
private static final Logger log = Logger.getLogger(FsApplicationServiceImpl.class);
	
	@Inject
	private FsApplicationDao dao;

	@Override
	public List<FsApplicationModel> queryFSApplicationByAPPID(
			ApplicationModel application) {
		// TODO Auto-generated method stub
		return dao.queryFSApplicationByAPPID(application);
	}
	
}
