package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.IInstinctDao;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.utils.BaseDaoImpl;
@Repository
public class InstinctDaoImpl extends BaseDaoImpl<ThirdinfoModel>  implements IInstinctDao{
	public boolean updateInstinctFlag(ThirdinfoModel thirdinfoModel,String sql) {
		boolean res = false;
		this.getSqlSession().update(sql,thirdinfoModel);
		res = true;
		return res;
	}
	
	public List<ThirdinfoModel> getNeedExportInfo(String sql) {
		List<ThirdinfoModel> list = null;
		list = this.getSqlSession().selectList(sql);
		return list;
	}
	
	@Override
	public boolean insertFaceDatas(String sql) {
		this.getSqlSession().insert(sql);
		return true;
	}
}
