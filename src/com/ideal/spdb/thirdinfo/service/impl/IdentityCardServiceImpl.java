package com.ideal.spdb.thirdinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideal.spdb.thirdinfo.dao.IdentityCardDao;
import com.ideal.spdb.thirdinfo.model.IdentityCardModel;
import com.ideal.spdb.thirdinfo.service.IdentityCardService;
import com.ideal.spdb.utils.BaseServiceImpl;

@Service("identityCardService")
public class IdentityCardServiceImpl extends BaseServiceImpl<IdentityCardModel> implements IdentityCardService{
	@Autowired
	private IdentityCardDao cardDao;
	
	@Override
	public void batchUpdate(List<IdentityCardModel> list) {
		try {
			cardDao.deleteAll();
			cardDao.batchAdd("IdentityCardModel.batchAdd", list);
		} catch (Exception e) {
			throw new RuntimeException("batchUpdate");
		}
	}

}
