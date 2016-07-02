package com.ideal.spdb.yellowpage.service.impl;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.utils.BaseServiceImpl;
import com.ideal.spdb.yellowpage.dao.YellowPageDao;
import com.ideal.spdb.yellowpage.model.YellowPageRecordModel;
import com.ideal.spdb.yellowpage.service.YellowPageService;

@Service("YellowPageService")
public class YellowPageServiceImpl extends BaseServiceImpl<YellowPageRecordModel> implements YellowPageService {
	private static final Logger log = Logger.getLogger(YellowPageServiceImpl.class);
	
	@Inject
	private YellowPageDao dao;
}
