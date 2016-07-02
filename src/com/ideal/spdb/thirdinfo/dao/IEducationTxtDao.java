package com.ideal.spdb.thirdinfo.dao;

import java.util.List;
import java.util.Map;

import com.ideal.spdb.thirdinfo.model.EducationTxtModel;


public interface IEducationTxtDao {
	public List<EducationTxtModel>  getNeedExportEducation();
	public boolean updateFlag(EducationTxtModel etm);
	public Map<String,String> getXuHao(int type);
}
