package com.ideal.spdb.bjwt.dao.impl;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.bjwt.dao.BjwtPersonDao;
import com.ideal.spdb.bjwt.model.BjwtPersonRecordModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository("BjwtPersonDao")
public class BjwtPersonDaoImpl extends BaseDaoImpl<BjwtPersonRecordModel> implements BjwtPersonDao {
	
}
