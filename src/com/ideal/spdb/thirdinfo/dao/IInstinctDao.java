package com.ideal.spdb.thirdinfo.dao;

import java.util.List;

import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;

public interface IInstinctDao {
	public boolean updateInstinctFlag(ThirdinfoModel thirdinfoModel,String sql);
	public List<ThirdinfoModel> getNeedExportInfo(String sql);
	public boolean insertFaceDatas(String sql);
}
