package com.ideal.spdb.thirdinfo.dao;

import java.util.List;

import com.ideal.spdb.thirdinfo.model.AppInfoModel;
import com.ideal.spdb.thirdinfo.model.ApprovalZmxyIvsModel;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.writemodel.ApprovalZmxyIvsWriteModel;

public interface IApprovalDao {
	public boolean updateApprovalFlag(ThirdinfoModel thirdinfoModel,String sql);
	public boolean updateZmxyIvsAppFlag(ApprovalZmxyIvsModel writeModel,String sql);
	public List<ThirdinfoModel> getNeedExportInfo(String sql);
	public List<ApprovalZmxyIvsModel> getNeedZmxyIvsAppInfo(String sql);
	public void insertOrUpdateAppInfo(AppInfoModel model);
}
