package com.ideal.spdb.thirdinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.spdb.thirdinfo.dao.MobileNumberDao;
import com.ideal.spdb.thirdinfo.model.MobileNumberModel;
import com.ideal.spdb.thirdinfo.service.MobileNumberService;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service("mobileNumberService")
public class MobileNumberServiceImpl extends BaseServiceImpl<MobileNumberModel> implements MobileNumberService {

	@Autowired
	private MobileNumberDao mobileNumberDao;
	
	@Override
	public void batchUpdate(List<MobileNumberModel> list) {
		try {
			mobileNumberDao.deleteAll();
			mobileNumberDao.batchAdd("MobileNumberModel.batchAdd", list);
		} catch (Exception e) {
			throw new RuntimeException("batchUpdate");
		}
	}


}
