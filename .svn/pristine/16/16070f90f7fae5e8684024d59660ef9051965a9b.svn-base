package com.ideal.spdb.publicsecurity.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.publicsecurity.dao.PublicSecurityDao;
import com.ideal.spdb.publicsecurity.model.PublicSecurityModel;
import com.ideal.spdb.publicsecurity.service.PublicSecurityService;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service
public class PublicSecurityServiceImpl extends BaseServiceImpl<PublicSecurityModel> implements PublicSecurityService {
	
	private static final Logger log = Logger.getLogger(PublicSecurityServiceImpl.class);
	
	@Inject
	public PublicSecurityDao dao;

	@Override
	public PublicSecurityModel quertPublicSecurityByAPPID(
			PublicSecurityModel publicSecurityModel) {
		// TODO Auto-generated method stub
		return dao.quertPublicSecurityByAPPID(publicSecurityModel);
	}

	@Override
	public List<PublicSecurityModel> queryPublicSecurityInfo() {
		// TODO Auto-generated method stub
		return dao.queryPublicSecurityInfo();
	}

	@Override
	public void updatePublicSecurityInfoStatus(
			PublicSecurityModel publicSecurityModel) {
		// TODO Auto-generated method stub
		dao.updatePublicSecurityInfoStatus(publicSecurityModel);
	}

}
