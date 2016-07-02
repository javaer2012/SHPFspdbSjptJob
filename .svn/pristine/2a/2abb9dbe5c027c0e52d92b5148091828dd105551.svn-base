package com.ideal.spdb.thirdinfo.dao.impl;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.MobileNumberDao;
import com.ideal.spdb.thirdinfo.model.MobileNumberModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository("mobileNumberDao")
public class MobileNumberDaoImpl extends BaseDaoImpl<MobileNumberModel> implements MobileNumberDao {

	@Override
	public void deleteAll() {
		getSqlSession().delete("MobileNumberModel.deleteAll");
	}
	
}
