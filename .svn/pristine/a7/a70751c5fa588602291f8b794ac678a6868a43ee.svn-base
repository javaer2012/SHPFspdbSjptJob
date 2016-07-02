package com.ideal.spdb.thirdinfo.dao.impl;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.IdentityCardDao;
import com.ideal.spdb.thirdinfo.model.IdentityCardModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository("identityCardDao")
public class IdentityCardDaoImpl extends BaseDaoImpl<IdentityCardModel> implements IdentityCardDao {

	@Override
	public void deleteAll() {
		getSqlSession().delete("IdentityCardModel.deleteAll");
	}
	
}
