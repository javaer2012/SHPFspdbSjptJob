package com.ideal.spdb.thirdinfo.service;

import java.util.List;

import com.ideal.spdb.thirdinfo.model.AllCountModel;
import com.ideal.spdb.thirdinfo.model.SheBaoInfoExcelModel;
import com.ideal.spdb.utils.BaseService;

public interface IThirdInfoService extends BaseService<AllCountModel>{
	public boolean uploadThirdInfo();
	/**
	 * 获取社保返回信息列表
	 * @return
	 */
	List<SheBaoInfoExcelModel> getSheBaoReturnList();
	
	/**
	 * 更新上传标识为1
	 */
	void updateFlagTo1(SheBaoInfoExcelModel model);
	
	/**
	 * 统计数量
	 */
	List<AllCountModel> getCount(AllCountModel model);
}
