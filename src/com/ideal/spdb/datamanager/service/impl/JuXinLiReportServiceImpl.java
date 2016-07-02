package com.ideal.spdb.datamanager.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ideal.spdb.datamanager.dao.JuXinLiReportDao;
import com.ideal.spdb.datamanager.model.JuXinLiReportModel;
import com.ideal.spdb.datamanager.service.JuXinLiReportService;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service
public class JuXinLiReportServiceImpl extends BaseServiceImpl<JuXinLiReportModel> implements JuXinLiReportService {
	
	@Inject
	private JuXinLiReportDao dao;
	
	
	
}
