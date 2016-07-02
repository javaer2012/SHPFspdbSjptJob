package com.ideal.spdb.juxinliBlackList.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.juxinliBlackList.dao.JuxinliBlackListRecordDao;
import com.ideal.spdb.juxinliBlackList.model.JuxinliBlackListRecordModel;
import com.ideal.spdb.juxinliBlackList.service.JuxinliBlackListRecordService;
import com.ideal.spdb.thirdinfo.model.JuxinliBlackListExportModel;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service
public class JuxinliBlackListRecordServiceImpl extends BaseServiceImpl<JuxinliBlackListRecordModel> implements JuxinliBlackListRecordService {

	private static final Logger log = Logger.getLogger(JuxinliBlackListRecordServiceImpl.class);
	
	@Inject
	private JuxinliBlackListRecordDao dao;
	
	@Override
	public JuxinliBlackListRecordModel quertJuxinliBlackListByAPPID(
			JuxinliBlackListRecordModel juxinliBlackListRecordModel) {
		// TODO Auto-generated method stub
		return dao.quertJuxinliBlackListByAPPID(juxinliBlackListRecordModel);
	}

	@Override
	public List<JuxinliBlackListRecordModel> queryJuxinliBlackListInfo() {
		// TODO Auto-generated method stub
		return dao.queryJuxinliBlackListInfo();
	}

	@Override
	public void updateJuxinliBlackListInfoStatus(
			JuxinliBlackListRecordModel juxinliBlackListRecordModel) {
		// TODO Auto-generated method stub
		dao.updateJuxinliBlackListInfoStatus(juxinliBlackListRecordModel);
	}

	@Override
	public List<JuxinliBlackListExportModel> queryJuxinliBlackListInfoExport() {
		// TODO Auto-generated method stub
		return dao.queryJuxinliBlackListInfoExport();
	}
	
}
