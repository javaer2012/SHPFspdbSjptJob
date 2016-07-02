package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.IEducationTxtDao;
import com.ideal.spdb.thirdinfo.model.EducationTxtModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository
public class EducaitonTxtDaoImpl extends BaseDaoImpl<EducationTxtModel> implements IEducationTxtDao{

	/**
	 * 查询符合要求的学历信息，flag=0 同时PF_application表中有该件
	 */
	@SuppressWarnings("unchecked")
	public List<EducationTxtModel> getNeedExportEducation() {
		List<EducationTxtModel> list = null;
		list = this.getSqlSession().selectList("educationTxt.getNeedEducationList");
		return list;
	}
	/**
	 * 更新flag上传信息状态为1
	 */
	@Override
	public boolean updateFlag(EducationTxtModel etm) {
		boolean res = false;
		this.getSqlSession().update("educationTxt.updataFlag",etm);
		res = true;
		return res;
	}
	/**
	 * 用于获取批次号
	 */
	public Map<String,String> getXuHao(int type){
		Map<String,String>map=new HashMap<String, String>();
		String type1 = type + "";
		map.put("in_type", type1);
		map.put("out_system_seq","");
		this.getSqlSession().selectOne("educationTxt.getSequenceValue",map);
		return map;
	}

}
