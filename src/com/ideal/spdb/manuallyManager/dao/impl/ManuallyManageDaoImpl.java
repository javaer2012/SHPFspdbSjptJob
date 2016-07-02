package com.ideal.spdb.manuallyManager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.manuallyManager.dao.ManuallyManageDao;
import com.ideal.spdb.manuallyManager.model.ManuallyModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository("ManuallyManageDao")
public class ManuallyManageDaoImpl extends BaseDaoImpl<ManuallyModel> implements ManuallyManageDao {

	@Override
	public int addApplicationInfoById(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return super.getSqlSession().insert("manuallyMapper.addApplicationInfoById", manuallyModel);
	}

	@Override
	public int addPf_process(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return super.getSqlSession().insert("manuallyMapper.addPf_process", manuallyModel);
	}

	@Override
	public int updatePf_process(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		if(super.getSqlSession().update("manuallyMapper.updatePf_process", manuallyModel) == 0){
			super.getSqlSession().insert("manuallyMapper.addPf_process", manuallyModel);
		}
		return 0;
	}

	@Override
	public int deleteApplication(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return super.getSqlSession().delete("manuallyMapper.deleteApplication", manuallyModel);
	}

	@Override
	public int deletePf_process(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return super.getSqlSession().delete("manuallyMapper.deletePf_process", manuallyModel);
	}

	@Override
	public int updateApplicationInfoById(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("manuallyMapper.updateApplication", manuallyModel);
	}

	@Override
	public int insertOrUpdateAppinfo(ManuallyModel manuallyModel) {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("manuallyMapper.insertorupdateappinfo", manuallyModel);
	}

	@Override
	public List<String> queryAppinfoData() {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("manuallyMapper.queryAppinfoData");
	}
	
	
	
}
