package com.ideal.spdb.zfb.dao.impl;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.pboc.dao.PbocDao;
import com.ideal.spdb.utils.BaseDaoImpl;
import com.ideal.spdb.zfb.dao.ZfbDao;
import com.ideal.spdb.zfb.model.ZfbModel;
import com.ideal.spdb.zmxy.dao.ZmxyDao;
import com.ideal.spdb.zmxy.model.ZmxyModel;

@Repository("zfbDao")
public class ZfbDaoImpl extends BaseDaoImpl<ZfbModel> implements ZfbDao{
}
