package com.ideal.spdb.thirdinfo.dao;

import java.util.List;

import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;

public interface ITencentInstinctDao {
	public List<ThirdinfoModel> getNeedExportInfo();
	public void updateFlag(ThirdinfoModel ssm);
}
