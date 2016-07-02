package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.manuallyManager.dao.ManuallyManageDao;
import com.ideal.spdb.thirdinfo.dao.IApprovalDao;
import com.ideal.spdb.thirdinfo.model.AppInfoModel;
import com.ideal.spdb.thirdinfo.model.ApprovalZmxyIvsModel;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.writemodel.ApprovalZmxyIvsWriteModel;
import com.ideal.spdb.utils.BaseDaoImpl;
@Repository
public class ApprovalDaoImpl extends BaseDaoImpl<ThirdinfoModel> implements IApprovalDao{
	@Inject
	private ManuallyManageDao dao;

	@Override
	public boolean updateApprovalFlag(ThirdinfoModel thirdinfoModel, String sql) {
		boolean res = false;
		this.getSqlSession().update(sql,thirdinfoModel);
		res = true;
		return res;
	}

	@Override
	public List<ThirdinfoModel> getNeedExportInfo(String sql) {
		List<ThirdinfoModel> list = null;
		list = this.getSqlSession().selectList(sql);
		return list;
	}

	@Override
	public List<ApprovalZmxyIvsModel> getNeedZmxyIvsAppInfo(String sql) {
		List<ApprovalZmxyIvsModel> list = null;
		list = this.getSqlSession().selectList(sql);
		return list;
	}

	@Override
	public boolean updateZmxyIvsAppFlag(ApprovalZmxyIvsModel model, String sql) {
		boolean res = false;
		this.getSqlSession().update(sql,model);
		res = true;
		return res;
	}

	@Override
	public void insertOrUpdateAppInfo(AppInfoModel model) {
		List<String> approcodeList = dao.queryAppinfoData();
		if (model.getApprovalcode() == null || (approcodeList == null || !approcodeList.contains(model.getApprovalcode()))) {
			model.setApprovalcode("");
		}
		this.getSqlSession().update("approval.insertorupdateappinfo",model);
	}
	
}
