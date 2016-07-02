package com.ideal.spdb.thirdinfo.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.thirdinfo.dao.ISZOverdueDao;
import com.ideal.spdb.thirdinfo.model.SZOverdueModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository
public class SZOverdueDaoImpl  extends BaseDaoImpl<SZOverdueModel> implements ISZOverdueDao{

	@Override
	public String insertIntoData(SZOverdueModel model) {
		String appid = "";
		Map<String,String>map=new HashMap<String, String>();
		map.put("IN_OVERDUEIDENTITY", model.getOverdueIdentity());
		map.put("IN_OVERDUENAME", model.getOverdueName());
		map.put("out_system_seq", "");
		this.getSqlSession().selectOne("SZOverdue.insertIntoData",map);
		appid = map.get("out_system_seq");
		model.setShenqingshucode(appid);
		return appid;
	}

	
	@Override
	public boolean insertApp(SZOverdueModel model) {
		boolean flag = false;
		this.getSqlSession().update("SZOverdue.insertApp",model);
		flag =true;
		return flag;
	}

	@Override
	public void initprocess(SZOverdueModel model) {
		this.getSqlSession().update("SZOverdue.initprocess",model);
	}

}
