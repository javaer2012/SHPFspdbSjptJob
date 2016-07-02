package com.ideal.spdb.bjwt.service.impl;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.bjwt.dao.BjwtUnitDao;
import com.ideal.spdb.bjwt.model.BjwtUnitRecordModel;
import com.ideal.spdb.bjwt.service.BjwtUnitService;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service("BjwtUnitService")
public class BjwtUnitServiceImpl extends BaseServiceImpl<BjwtUnitRecordModel> implements BjwtUnitService {
	private static final Logger log = Logger.getLogger(BjwtUnitServiceImpl.class);
	
	@Inject
	private BjwtUnitDao dao;
}
