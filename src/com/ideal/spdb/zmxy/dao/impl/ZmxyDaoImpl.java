package com.ideal.spdb.zmxy.dao.impl;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.datamanager.model.ApplicationModel;
import com.ideal.spdb.pboc.dao.PbocDao;
import com.ideal.spdb.utils.BaseDaoImpl;
import com.ideal.spdb.zmxy.dao.ZmxyDao;
import com.ideal.spdb.zmxy.model.ZmxyModel;

@Repository("zmxyDao")
public class ZmxyDaoImpl extends BaseDaoImpl<ZmxyModel> implements ZmxyDao{
}
