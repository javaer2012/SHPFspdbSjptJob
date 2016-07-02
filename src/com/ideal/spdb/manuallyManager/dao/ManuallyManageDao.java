package com.ideal.spdb.manuallyManager.dao;

import java.util.List;

import com.ideal.spdb.manuallyManager.model.ManuallyModel;
import com.ideal.spdb.utils.BaseDao;

public interface ManuallyManageDao extends BaseDao<ManuallyModel>{
	/**
	 * 添加申请件
	 * @param manuallyModel
	 * @return
	 */
	public int addApplicationInfoById(ManuallyModel manuallyModel);
	
	/**
	 * 更新申请件
	 * @param manuallyModel
	 * @return
	 */
	public int updateApplicationInfoById(ManuallyModel manuallyModel);
	
	/**
	 * 添加流程处理
	 * @param manuallyModel
	 * @return
	 */
	public int addPf_process(ManuallyModel manuallyModel);
	
	/**
	 * 更新流程处理
	 * @param manuallyModel
	 * @return
	 */
	public int updatePf_process(ManuallyModel manuallyModel);
	
	/**
	 * 删除进件表数据
	 * @param manuallyModel
	 * @return
	 */
	public int deleteApplication(ManuallyModel manuallyModel);
	
	/**
	 * 删除流程处理
	 * @param manuallyModel
	 * @return
	 */
	public int deletePf_process(ManuallyModel manuallyModel);
	
	/**
	 * 更新分行审批机构代码
	 * @param manuallyModel
	 * @return
	 */
	public int insertOrUpdateAppinfo(ManuallyModel manuallyModel);

	/**
	 * 查询分行审批代码
	 * @param name
	 * @return
	 */
	public List<String> queryAppinfoData();
}
