package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.IApprovalIdcheckDao;
import com.ideal.spdb.thirdinfo.model.ApprovalIdcheckModel;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.utils.BaseDaoImpl;
@Repository
public class ApprovalIdcheckDaoImpl extends BaseDaoImpl<ApprovalIdcheckModel> implements IApprovalIdcheckDao{

	@Override
	public List<ApprovalIdcheckModel> getNeedExportInfo(String string) {
		List<ApprovalIdcheckModel> list = null;
		list = this.getSqlSession().selectList(string);
		return list;
	}

	@Override
	public void updateInstinctFlag(ApprovalIdcheckModel approvalIdcheckModel, String string) {
		this.getSqlSession().update(string,approvalIdcheckModel);
	}

}
