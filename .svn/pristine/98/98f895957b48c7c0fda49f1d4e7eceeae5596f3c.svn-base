package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.IZfbzxDao;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.model.ZfbzxModel;
import com.ideal.spdb.utils.BaseDaoImpl;
@Repository
public class ZfbzxDaoImpl extends BaseDaoImpl<ZfbzxModel> implements IZfbzxDao{

	@Override
	public List<ZfbzxModel> getNeedExportInfo(String sql) {
		List<ZfbzxModel> list = null;
		list = this.getSqlSession().selectList(sql);
		return list;
	}

	@Override
	public boolean  updateFlag(ZfbzxModel ZfbzxModel, String sql) {
		boolean res = false;
		this.getSqlSession().update(sql,ZfbzxModel);
		res = true;
		return res;
		
	}

}
