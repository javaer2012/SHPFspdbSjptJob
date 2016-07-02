package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.ITencentInstinctDao;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.utils.BaseDaoImpl;
@Repository
public class TencentInstinctDao extends BaseDaoImpl<ThirdinfoModel> implements ITencentInstinctDao{
	@Override
	public List<ThirdinfoModel> getNeedExportInfo() {
		
		List<ThirdinfoModel> list = null;
		list = this.getSqlSession().selectList("tencentInstinct.getNeedThirdinfoList");
		return list;
	}

	@Override
	public void updateFlag(ThirdinfoModel ssm) {
		this.getSqlSession().update("tencentInstinct.updataFlag",ssm);
		this.getSqlSession().update("tencentInstinct.updataFlag2",ssm);
	}
}	
