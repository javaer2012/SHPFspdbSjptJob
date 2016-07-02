package com.ideal.spdb.pboc.dao.impl;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.pboc.dao.PbocDao;
import com.ideal.spdb.pboc.model.PbocModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository("pbocDao")
public class PbocDaoImpl extends BaseDaoImpl<PbocModel> implements PbocDao{

	@Override
	public int getUserCount(String username) throws Exception {
		log.info("dao getCount!");
		int result = 0;
		try {
			result =(Integer) this.getSqlSession().selectOne("pboc.selectUserCount",username);
		} catch (Exception e) {
			log.error("dao getCount:",e);
			throw e;
		}
		return result;
	}

}
