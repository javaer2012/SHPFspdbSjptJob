package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.ISocialsecurityDao;
import com.ideal.spdb.thirdinfo.model.SocialsecurityModel;
import com.ideal.spdb.utils.BaseDaoImpl;
@Repository
public class SocialsecurityDaoImpl extends BaseDaoImpl<SocialsecurityModel> implements ISocialsecurityDao{
	/**
	 * 查询符合要求的社保信息，flag=0 同时PF_application表中有该件
	 */
	@SuppressWarnings("unchecked")
	public List<SocialsecurityModel> getNeedExportSocialsecurity() {
		List<SocialsecurityModel> list = null;
		list = this.getSqlSession().selectList("socialsecurity.getNeedSocialsecurityList");
		return list;
	}
	/**
	 * 更新flag上传信息状态为1
	 */
	@Override
	public boolean updateFlag(SocialsecurityModel stm) {
		boolean res = false;
		this.getSqlSession().update("socialsecurity.updataFlag",stm);
		res = true;
		return res;
	}
	public Map<String,String> getXuHao(int type){
		Map<String,String>map=new HashMap<String, String>();
		String type1 = type + "";
		map.put("in_type", type1);
		map.put("out_system_seq","");
		this.getSqlSession().selectOne("socialsecurity.getSequenceValue",map);
		return map;
	}
	
	public Map<String,String> getXuHao(String type){
		Map<String,String>map=new HashMap<String, String>();
		String type1 = type + "";
		map.put("in_type", type1);
		map.put("out_system_seq","");
		this.getSqlSession().selectOne("socialsecurity.getSequenceValue",map);
		return map;
	}

}
