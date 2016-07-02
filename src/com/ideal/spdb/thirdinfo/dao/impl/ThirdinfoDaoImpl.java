package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.IThirdinfoDao;
import com.ideal.spdb.thirdinfo.model.AllCountModel;
import com.ideal.spdb.thirdinfo.model.SheBaoInfoExcelModel;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository
public class ThirdinfoDaoImpl extends BaseDaoImpl<ThirdinfoModel> implements IThirdinfoDao{

	@Override
	public List<ThirdinfoModel> getNeedExportInfo() {
		
		List<ThirdinfoModel> list = null;
		list = this.getSqlSession().selectList("thirdinfo.getNeedThirdinfoList");
		return list;
	}


	@Override
	public void updateFlag(ThirdinfoModel ssm) {
		this.getSqlSession().update("thirdinfo.updataFlag",ssm);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<SheBaoInfoExcelModel> getSheBaoReturnList() {
		
		return this.getSqlSession().selectList("thirdinfo.getSheBaoReturnList");
	}


	@Override
	public void updateFlagTo1(SheBaoInfoExcelModel model) {
		
		this.getSqlSession().update("thirdinfo.updateFlagTo1", model);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AllCountModel> getCount(AllCountModel model) {
		
		return this.getSqlSession().selectList("thirdinfo.getData", model);
	}
   
}
