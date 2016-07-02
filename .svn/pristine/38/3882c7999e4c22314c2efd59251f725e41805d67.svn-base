package com.ideal.spdb.juxinliBlackList.dao;

import java.util.List;

import com.ideal.spdb.juxinliBlackList.model.JuxinliBlackListRecordModel;
import com.ideal.spdb.thirdinfo.model.JuxinliBlackListExportModel;
import com.ideal.spdb.utils.BaseDao;

public interface JuxinliBlackListRecordDao extends BaseDao<JuxinliBlackListRecordModel> {
	/**
	 * 根据查询聚信力黑名单信息
	 * @param JuxinliBlackListRecordModel
	 * @return
	 */
	public JuxinliBlackListRecordModel quertJuxinliBlackListByAPPID(JuxinliBlackListRecordModel juxinliBlackListRecordModel);
	
	/**
	 * 查询聚信力黑名单需上传信息
	 * @param JuxinliBlackListRecordModel
	 * @return
	 */
	public List<JuxinliBlackListRecordModel> queryJuxinliBlackListInfo();
	
	/**
	 * 查询聚信力黑名单需导出信息
	 * @return
	 */
	public List<JuxinliBlackListExportModel> queryJuxinliBlackListInfoExport();
	
	/**
	 * 更新聚信力黑名单
	 * @param JuxinliBlackListRecordModel
	 * @return
	 */
	public void updateJuxinliBlackListInfoStatus(JuxinliBlackListRecordModel juxinliBlackListRecordModel);
}
