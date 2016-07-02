package com.ideal.spdb.manuallyManager.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.manuallyManager.dao.ManuallyManageDao;
import com.ideal.spdb.manuallyManager.model.ManuallyModel;
import com.ideal.spdb.manuallyManager.service.ManuallyManageService;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service("ManuallyManageService")
public class ManuallyManageServiceImpl extends BaseServiceImpl<ManuallyModel> implements ManuallyManageService {
	
	private static final Logger log = Logger.getLogger(ManuallyManageServiceImpl.class);
	
	@Inject
	private ManuallyManageDao dao;

	@Override
	public int addApplicationInfoById(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return dao.addApplicationInfoById(manuallyModel);
	}

	@Override
	public int addPf_process(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return dao.addPf_process(manuallyModel);
	}

	@Override
	public int updatePf_process(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return dao.updatePf_process(manuallyModel);
	}

	@Override
	public int deleteApplication(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return dao.deleteApplication(manuallyModel);
	}

	@Override
	public int deletePf_process(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return dao.deletePf_process(manuallyModel);
	}

	@Override
	public int updateApplicationInfoById(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return dao.updateApplicationInfoById(manuallyModel);
	}

	@Override
	public int insertOrUpdateInfo(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		List<String> approcodeList = dao.queryAppinfoData();
		if(manuallyModel.getApprovalcode() == null || (approcodeList == null || !approcodeList.contains(manuallyModel.getApprovalcode()))){
			manuallyModel.setApprovalcode("");
		}
		return dao.insertOrUpdateAppinfo(manuallyModel);
	}

}
