package com.ideal.spdb.juxinliBlackList.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ideal.spdb.juxinliBlackList.dao.JuxinliBlackListRecordDao;
import com.ideal.spdb.juxinliBlackList.model.JuxinliBlackListRecordModel;
import com.ideal.spdb.thirdinfo.model.JuxinliBlackListExportModel;
import com.ideal.spdb.utils.BaseDaoImpl;

@Repository
public class JuxinliBlackListRecordDaoImpl extends BaseDaoImpl<JuxinliBlackListRecordModel> implements JuxinliBlackListRecordDao {

	@Override
	public JuxinliBlackListRecordModel quertJuxinliBlackListByAPPID(
			JuxinliBlackListRecordModel juxinliBlackListRecordModel) {
		// TODO Auto-generated method stub
		return (JuxinliBlackListRecordModel) super.getSqlSession().selectOne("juxinliBlackList.quertJuxinliBlackListRecordByAPPID", juxinliBlackListRecordModel);
	}

	@Override
	public List<JuxinliBlackListRecordModel> queryJuxinliBlackListInfo() {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("juxinliBlackList.queryJuxinliBlackListRecordInfo");
	}

	@Override
	public void updateJuxinliBlackListInfoStatus(
			JuxinliBlackListRecordModel juxinliBlackListRecordModel) {
		// TODO Auto-generated method stub
		super.getSqlSession().update("juxinliBlackList.updateJuxinliBlackListRecordInfoStatus", juxinliBlackListRecordModel);
	}

	@Override
	public List<JuxinliBlackListExportModel> queryJuxinliBlackListInfoExport() {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("juxinliBlackList.queryJuxinliBlackListInfoExport");
	}

}
